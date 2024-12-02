import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    // Add Employee
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employeeData (name, ssn, jobTitle, division, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getSsn());
            stmt.setString(3, employee.getJobTitle());
            stmt.setString(4, employee.getDivision());
            stmt.setDouble(5, employee.getSalary());
            stmt.executeUpdate();
            System.out.println("Employee added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Search Employee
    public Employee searchEmployee(String searchKey) {
        String query = "SELECT * FROM employeeData WHERE name = ? OR ssn = ? OR id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, searchKey);
            stmt.setString(2, searchKey);
            stmt.setString(3, searchKey);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("ssn"),
                        rs.getString("jobTitle"),
                        rs.getString("division"),
                        rs.getDouble("salary")
                );
            } else {
                System.out.println("Employee not found!");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Update Employee
    public void updateEmployee(Employee employee) {
        String query = "UPDATE employeeData SET name = ?, ssn = ?, jobTitle = ?, division = ?, salary = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, employee.getName());
            stmt.setString(2, employee.getSsn());
            stmt.setString(3, employee.getJobTitle());
            stmt.setString(4, employee.getDivision());
            stmt.setDouble(5, employee.getSalary());
            stmt.setInt(6, employee.getId());
            stmt.executeUpdate();
            System.out.println("Employee updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        String query = "DELETE FROM employeeData WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Employee deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Salary
    public void updateSalary(double percentage, double minSalary, double maxSalary) {
        String query = "UPDATE employeeData SET salary = salary + (salary * ? / 100) WHERE salary BETWEEN ? AND ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDouble(1, percentage);
            stmt.setDouble(2, minSalary);
            stmt.setDouble(3, maxSalary);
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Salary updated for " + rowsAffected + " employees.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Generate Report
    public List<Employee> generateReport(String query) {
        List<Employee> report = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                report.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("ssn"),
                        rs.getString("jobTitle"),
                        rs.getString("division"),
                        rs.getDouble("salary")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return report;
    }
}
