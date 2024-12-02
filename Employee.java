public class Employee {
    private int id;
    private String name;
    private String ssn;
    private String jobTitle;
    private String division;
    private double salary;

    // Constructor
    public Employee(int id, String name, String ssn, String jobTitle, String division, double salary) {
        this.id = id;
        this.name = name;
        this.ssn = ssn;
        this.jobTitle = jobTitle;
        this.division = division;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSsn() { return ssn; }
    public void setSsn(String ssn) { this.ssn = ssn; }
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public String getDivision() { return division; }
    public void setDivision(String division) { this.division = division; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}
