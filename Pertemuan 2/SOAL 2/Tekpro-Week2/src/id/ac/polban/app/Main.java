package id.ac.polban.app;

import id.ac.polban.employee.model.Department;
import id.ac.polban.employee.model.Employee;
import id.ac.polban.employee.model.EmploymentType;
import id.ac.polban.employee.service.EmployeeService;

public class Main {
    public static void main(String[] args) {

        Department it = new Department("IT");
        Department hr = new Department("HR");
        Department finance = new Department("Finance");
        Department marketing = new Department("Marketing");

        EmploymentType fulltime = new EmploymentType("Full Time");
        EmploymentType contract = new EmploymentType("Contract");

        EmployeeService service = new EmployeeService();

        Employee emp1 = new Employee("Raza", it, fulltime, 5000000);
        Employee emp2 = new Employee("Aqmar", hr, contract, 4000000);
        Employee emp3 = new Employee("Bintang", finance, fulltime, 5500000);
        Employee emp4 = new Employee("Kinara", marketing, contract, 4500000);

        service.addEmployee(emp1);
        service.addEmployee(emp2);
        service.addEmployee(emp3);
        service.addEmployee(emp4);

        service.raiseSalary(1, 10);

        service.showAllEmployee();

        System.out.println("Total Employee  : " + Employee.getTotalEmployee());
        System.out.println("Total Department: " + Department.getTotalDepartment());
    }
}
