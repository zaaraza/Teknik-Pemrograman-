public class RestaurantMain {
    public static void main(String[] args) {

        Restaurant menu = new Restaurant();

        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);

        System.out.println("=== Daftar Menu Awal ===");
        menu.tampilMenuMakanan();

        System.out.println("\n=== Proses Pemesanan ===");
        menu.pesanMakanan("Pizza", 5);
        menu.pesanMakanan("Spaghetti", 25);
        menu.pesanMakanan("Chicken Steak", 10);

        System.out.println("\n=== Menu Setelah Pemesanan ===");
        menu.tampilMenuMakanan();
    }
}