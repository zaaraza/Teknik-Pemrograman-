public class EmployeeTest {
    public static void main(String[] args) {

        // Array of 3 Employee
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        // Naikkan gaji 5%
        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }

        System.out.println("=== Data Karyawan Setelah Kenaikan Gaji 5% ===");
        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

        // Uji shell_sort berdasarkan salary
        System.out.println("\n=== Sebelum Sorting ===");
        for (Employee e : staff)
            e.print();

        Sortable.shell_sort(staff);

        System.out.println("\n=== Sesudah Sorting (ascending by salary) ===");
        for (Employee e : staff)
            e.print();
    }
}
