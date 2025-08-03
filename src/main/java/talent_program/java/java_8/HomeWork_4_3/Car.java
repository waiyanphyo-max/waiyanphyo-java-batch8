package main.java.talent_program.java.java_8.HomeWork_4_3;

public class Car extends Vehicle{


    public Car(String country, int year) {
        super(country, year);
    }

    @Override
    public void startEngine() {
        System.out.println("Car is starting Engine.");
    }

    public void drive() {
        System.out.println("Car is driving now.");
    }

    @Override
    public VehicleType getVehicleType() {
         return VehicleType.Car;
    }

}
