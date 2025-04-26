package employees;

public class SalariedEmployee extends Employee {
    private double annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, long employeeId, String hireDate, double annualSalary, boolean isRetired) {
        super(name, birthDate, employeeId, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    public double retire() {
        return isRetired ? annualSalary * 0.8 : collectPay();
    }

    @Override
    public double collectPay() {
        return annualSalary / 12;
    }
}
