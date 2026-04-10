class Resto {
    // Stok awal ayam
    private int chickenStock = 100;

    // Menambahkan 'synchronized' agar hanya satu thread (kasir) 
    // yang bisa menjalankan method ini dalam satu waktu.
    public synchronized void serveCustomer(String cashierName) {
        if (chickenStock > 0) {
            // Simulasi proses transaksi
            try { 
                Thread.sleep(10); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            chickenStock--; 
            System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);
        } else {
            System.out.println(cashierName + " gagal: Stok Habis!");
        }
    }

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {
        Resto ayamJuicyLuicyGallagher = new Resto();

        // Setiap kasir (thread) akan mencoba melayani 40 pelanggan
        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
            }
        };

        // Membuat 3 thread kasir
        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        // Memulai simulasi
        kasir1.start();
        kasir2.start();
        kasir3.start();

        // Menunggu semua kasir selesai bekerja sebelum mencetak hasil akhir
        kasir1.join();
        kasir2.join();
        kasir3.join();

        System.out.println("\n======================================");
        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
        System.out.println("======================================");
    }
}