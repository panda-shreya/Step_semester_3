package classes_objects.assigment_problems;

public class EmployeeCompany {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeCompany(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        EmployeeCompany e1 = new EmployeeCompany("Divya", 65000);

        EmployeeCompany e2 = new EmployeeCompany("Arjun", 45000);

        EmployeeCompany e3 = new EmployeeCompany("Priya", 55000);

        System.out.println("3 Employee objects created");

        EmployeeCompany.printCompanyInfo();
    }
}