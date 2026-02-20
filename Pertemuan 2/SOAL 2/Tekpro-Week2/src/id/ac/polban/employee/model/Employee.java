package id.ac.polban.employee.model;

public class Employee {
    private static int totalEmployee = 0;

    private int id;
    private String name;
    private Department department;
    private EmploymentType type;
    private double salary;

    public Employee(String name, Department department, EmploymentType type, double salary) {
        totalEmployee++;
        this.id = totalEmployee;
        this.name = name;
        this.department = department;
        this.type = type;
        this.salary = salary;
    }

    public static int getTotalEmployee() {
        return totalEmployee;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public EmploymentType getType() {
        return type;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    public void displayInfo() {
        System.out.println("ID             : " + id);
        System.out.println("Nama           : " + name);
        System.out.println("Departement    : " + department.getName());
        System.out.println("Tipe           : " + type.getType());
        System.out.println("Gaji           : " + salary);
        System.out.println("------------------------------");
    }
}
