class Account {
    int balance = 150;
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Thread 1: Transfer dari acc1 ke acc2
        Thread t1 = new Thread(() -> {
            // SOLUSI: Selalu mengunci acc1 dulu, baru acc2
            synchronized (acc1) { 
                System.out.println("Thread 1: Mengunci acc1...");
                try { Thread.sleep(100); } catch (Exception e) { e.printStackTrace(); }

                synchronized (acc2) { 
                    System.out.println("Thread 1: Berhasil mengunci acc2. Melakukan transfer...");
                    acc2.balance += acc1.balance;
                    acc1.balance = 0;
                }
            }
        });

        // Thread 2: Transfer dari acc2 ke acc1
        Thread t2 = new Thread(() -> {
            // Urutan synchronized kunci disamakan dengan Thread 1 (acc1 dulu baru acc2)
            synchronized (acc1) { 
                System.out.println("Thread 2: Mengunci acc1...");
                try { Thread.sleep(100); } catch (Exception e) { e.printStackTrace(); }

                synchronized (acc2) { 
                    System.out.println("Thread 2: Berhasil mengunci acc2. Melakukan transfer...");
                    acc1.balance += acc2.balance;
                    acc2.balance = 0; 
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}