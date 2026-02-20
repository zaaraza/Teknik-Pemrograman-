package id.ac.polban.employee.model;
public class Department {
    private static int totalDepartment = 0;

    private int id;
    private String name;

    public Department(String name) {
        totalDepartment++;
        this.id = totalDepartment;
        this.name = name;
    }

    public static int getTotalDepartment() {
        return totalDepartment;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}