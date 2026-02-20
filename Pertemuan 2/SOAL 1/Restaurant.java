public class Restaurant {
    // Mengubah public menjadi private untuk enkapsulasi data
    private String[] namaMakanan;
    private double[] hargaMakanan;
    private int[] stok;
    private int id; // Mengubah dari yang tadinya static menjadi instance variable untuk menghindari
                    // masalah pada penambahan menu

    public Restaurant() {
        namaMakanan = new String[10];
        hargaMakanan = new double[10];
        stok = new int[10];
        id = 0;
    }

    // getters dan setters untuk mengakses dan memodifikasi data dengan validasi
    // sederhana
    public int getId() {
        return id;
    }

    public String getNamaMakanan(int index) {
        return namaMakanan[index];
    }

    public void setNamaMakanan(int index, String nama) {
        if (nama != null && !nama.isEmpty()) {
            namaMakanan[index] = nama;
        }
    }

    public double getHargaMakanan(int index) {
        return hargaMakanan[index];
    }

    public void setHargaMakanan(int index, double harga) {
        if (harga > 0) {
            hargaMakanan[index] = harga;
        } else {
            System.out.println("Harga harus lebih dari 0");
        }
    }

    public int getStok(int index) {
        return stok[index];
    }

    public void setStok(int index, int stokBaru) {
        if (stokBaru >= 0) {
            stok[index] = stokBaru;
        } else {
            System.out.println("Stok tidak boleh negatif");
        }
    }

    public void tambahMenuMakanan(String nama, double harga, int stokAwal) {
        setNamaMakanan(id, nama);
        setHargaMakanan(id, harga);
        setStok(id, stokAwal);
        id++;
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i < id; i++) {
            if (getStok(i) > 0) {
                System.out.println(
                        getNamaMakanan(i) + " [" + getStok(i) + "] Rp. " + getHargaMakanan(i));
            }
        }
    }

    public void pesanMakanan(String nama, int jumlah) {
        for (int i = 0; i < id; i++) {
            if (getNamaMakanan(i).equalsIgnoreCase(nama)) {

                if (getStok(i) >= jumlah) {
                    setStok(i, getStok(i) - jumlah);
                    System.out.println("Pesanan berhasil. Sisa stok: " + getStok(i));
                } else {
                    System.out.println("Pesanan ditolak. Stok tidak mencukupi");
                }
                return;
            }
        }
        System.out.println("Menu tidak ditemukan");
    }
}