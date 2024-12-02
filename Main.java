import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Update Salary");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter employee details: ");
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("SSN: ");
                    String ssn = scanner.next();
                    System.out.print("Job Title: ");
                    String jobTitle = scanner.next();
                    System.out.print("Division: ");
                    String division = scanner.next();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    service.addEmployee(new Employee(0, name, ssn, jobTitle, division, salary));
                    break;

                case 2:
                    System.out.print("Enter Name, SSN, or ID to search: ");
                    String searchKey = scanner.next();
                    Employee employee = service.searchEmployee(searchKey);
                    if (employee != null) {
                        System.out.println("Employee Found: " + employee.getName());
                    }
                    break;

                case 3:
                    // Add update logic here
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int id = scanner.nextInt();
                    service.deleteEmployee(id);
                    break;

                case 5:
                    System.out.print("Enter percentage increase: ");
                    double percentage = scanner.nextDouble();
                    System.out.print("Enter min salary: ");
                    double minSalary = scanner.nextDouble();
                    System.out.print("Enter max salary: ");
                    double maxSalary = scanner.nextDouble();
                    service.updateSalary(percentage, minSalary, maxSalary);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}
