public class ManagerTest {
    public static void main(String[] args) {

        // Kombinasi Employee dan Manager (Polimorfisme)
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Manager("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        System.out.println("=== Sebelum Kenaikan Gaji ===");
        for (Employee e : staff) e.print();

        // Naikkan gaji semua staf sebesar 5%
        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }

        System.out.println("\n=== Setelah Kenaikan Gaji 5% ===");
        System.out.println("(Manager mendapat bonus tambahan berdasarkan tahun kerja)");
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

        // Uji shell_sort — Manager IS-A Sortable via Employee
        System.out.println("\n=== Sorting by Salary ===");
        Sortable.shell_sort(staff);
        for (Employee e : staff) e.print();
    }
}
