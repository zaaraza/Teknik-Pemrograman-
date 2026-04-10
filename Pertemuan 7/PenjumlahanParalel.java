import java.util.Scanner;

public class PenjumlahanParalel {

    // Variabel untuk menyimpan total akhir, menggunakan volatile agar
    // perubahan dari satu thread langsung terlihat oleh thread lain
    private static long totalAkhir = 0;

    // Objek kunci (lock) khusus untuk sinkronisasi saat menjumlahkan hasil parsial
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // --- INPUT ---
        System.out.print("Masukkan Jumlah Thread : ");
        int jumlahThread = scanner.nextInt();

        System.out.print("Masukkan Angka Akhir   : ");
        int angkaAkhir = scanner.nextInt();

        scanner.close();

        // --- PEMBAGIAN TUGAS (DIVIDE AND CONQUER) ---
        // Hitung berapa angka yang ditangani setiap thread
        int ukuranBagian = angkaAkhir / jumlahThread;

        // Array untuk menyimpan semua objek Thread
        Thread[] threads = new Thread[jumlahThread];

        System.out.println("\n--- PROSES PENJUMLAHAN PARALEL ---");

        // --- PEMBUATAN DAN PENJALANAN THREAD ---
        for (int i = 0; i < jumlahThread; i++) {
            // Tentukan batas bawah dan batas atas untuk setiap thread
            int batasBawah = (i * ukuranBagian) + 1;
            // Thread terakhir mengambil sisa angka jika angkaAkhir tidak habis dibagi
            int batasAtas = (i == jumlahThread - 1) ? angkaAkhir : (i + 1) * ukuranBagian;

            // Nama thread dimulai dari "Thread-1"
            String namaThread = "Thread-" + (i + 1);

            // Buat thread baru menggunakan lambda, dengan final variable agar bisa diakses di dalam lambda
            final int finalBawah = batasBawah;
            final int finalAtas = batasAtas;

            threads[i] = new Thread(() -> {
                // Tampilkan tugas yang dikerjakan thread ini
                System.out.println(Thread.currentThread().getName() +
                        " : Menjumlahkan " + finalBawah + " - " + finalAtas);

                // Hitung hasil parsial untuk rentang angka yang diberikan
                long hasilParsial = 0;
                for (int j = finalBawah; j <= finalAtas; j++) {
                    hasilParsial += j;
                }

                // Tampilkan hasil parsial dari thread ini
                System.out.println(Thread.currentThread().getName() +
                        " : Hasil Parsial = " + hasilParsial);

                // --- THREAD SAFETY / SINKRONISASI ---
                // Gunakan blok synchronized saat menambahkan hasil parsial ke totalAkhir
                // agar tidak terjadi Race Condition (hanya satu thread yang boleh
                // memodifikasi totalAkhir pada satu waktu)
                synchronized (lock) {
                    totalAkhir += hasilParsial;
                }

            }, namaThread); // Nama thread diberikan langsung di konstruktor

            // Jalankan thread
            threads[i].start();
        }

        // --- SINKRONISASI THREAD UTAMA ---
        // join() memastikan thread utama menunggu semua thread selesai
        // sebelum mencetak hasil akhir
        for (int i = 0; i < jumlahThread; i++) {
            threads[i].join();
        }

        // --- OUTPUT HASIL AKHIR ---
        System.out.println("\n--- HASIL AKHIR ---");
        System.out.println("Total Penjumlahan 1 sampai " + angkaAkhir +
                " menggunakan " + jumlahThread + " thread = " + totalAkhir);
    }
}