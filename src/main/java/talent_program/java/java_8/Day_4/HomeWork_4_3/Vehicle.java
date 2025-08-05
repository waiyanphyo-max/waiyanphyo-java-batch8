package main.java.talent_program.java.java_8.Day_4.HomeWork_4_3;

public class Vehicle {
    private String country;
    private int year;
    private int fuelLevel;
    VehicleType vehicleType;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle(String country, int year) {
        this.country = country;
        this.year = year;
    }

    public void startEngine() {
        System.out.println("Vehicle is starting engine");
    }

    public void refuel(int fuelLevel, VehicleType vehicleType) {
        System.out.println("Vehicle is refuel now.");
    }
}
