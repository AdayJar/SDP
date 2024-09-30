public interface TaxCalculator {
    double calculateTax(Employee employee);
}

class SimpleTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(Employee employee) {
        return employee.getSalary() * 0.2; // Простая стратегия расчета налога (20%)
    }
}
