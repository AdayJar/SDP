public class EmployeeReport {
    private TaxCalculator taxCalculator;

    public EmployeeReport(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public void generateReport(Employee employee) {
        System.out.println("Employee Report:");
        System.out.println(employee);
        System.out.println("Tax: " + taxCalculator.calculateTax(employee));
    }

    public static void main(String[] args) {
        Employee employee = new Employee("John Doe", 30, 50000);
        TaxCalculator taxCalculator = new SimpleTaxCalculator();
        EmployeeReport report = new EmployeeReport(taxCalculator);

        report.generateReport(employee);
    }
}
