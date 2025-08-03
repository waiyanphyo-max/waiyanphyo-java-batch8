package main.java.talent_program.java.java_8.HomeWork_4_4;

public class SalariedEmployee extends Employee{
    private double annualSalary;

    public SalariedEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    double calculatePay() {
        return annualSalary / 12;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee" +
                "\nannualSalary=" + annualSalary ;
    }
}
