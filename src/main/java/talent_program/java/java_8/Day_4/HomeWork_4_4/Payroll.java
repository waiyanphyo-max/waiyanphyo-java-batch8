package main.java.talent_program.java.java_8.Day_4.HomeWork_4_4;

import java.util.ArrayList;

public class Payroll {
    public static void main(String[] args) {
        final var arrayList = getEmployees();

        Employee[] employeeArrays = arrayList.toArray(new Employee[0]);

        for (Employee employeeArray : employeeArrays) {
            System.out.println(" ");
            System.out.println("Name  : " + employeeArray.getName());
            System.out.println(employeeArray);
            System.out.println("Monthly Pay  : " + (double) Math.round(employeeArray.calculatePay() * 100) / 100);
        }
    }

    private static ArrayList<Employee> getEmployees() {
        HourlyEmployee mgMg = new HourlyEmployee(1, "Mg Mg");
        mgMg.setHourlyRate(32.20);
        mgMg.setHoursWorked(189.5);

        SalariedEmployee hlaHla = new SalariedEmployee(1, "Hla Hla");
        hlaHla.setAnnualSalary(72000);

        HourlyEmployee mya = new HourlyEmployee(2, "Mya Mya");
        mya.setHourlyRate(33.60);
        mya.setHoursWorked(193.7);

        SalariedEmployee kaung = new SalariedEmployee(2, "Kaung Kaung");
        kaung.setAnnualSalary(74000);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(mgMg);
        employees.add(hlaHla);
        employees.add(mya);
        employees.add(kaung);

        return employees;
    }
}
