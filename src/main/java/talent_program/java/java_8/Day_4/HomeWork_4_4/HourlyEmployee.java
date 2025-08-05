package main.java.talent_program.java.java_8.Day_4.HomeWork_4_4;

public class HourlyEmployee extends Employee{
    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    double calculatePay() {
        if(hoursWorked >= 160.00) {
            return (hourlyRate * 160) + ((hoursWorked - 160) * (hourlyRate + (hourlyRate * 1.5)));
        } else {
            return hourlyRate * hoursWorked;
        }
    }

    public double getHourlyRate(double v) {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        if(hoursWorked >= 160) {
            return "HourlyEmployee" +
                    "\nhourlyRate=" + hourlyRate + " + " + "150% for " + ((double) Math.round((hoursWorked-160) * 100) / 100) + "hours" +
                    "\nhoursWorked=" + hoursWorked ;
        } else {
            return "HourlyEmployee" +
                    "\nhourlyRate=" + hourlyRate +
                    "\nhoursWorked=" + hoursWorked ;
        }
    }
}
