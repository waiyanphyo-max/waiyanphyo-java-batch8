package main.java.talent_program.java.java_8.Day_4.HomeWork_4_3;

public class MotorCycle extends Vehicle{

    public MotorCycle(String country, int year) {
        super(country, year);
    }

    @Override
    public void startEngine() {
        System.out.println("MotorCycle is starting engine");
    }

    public void drive() {
        System.out.println("MotorCycle is driving now.");
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.MotorCycle;
    }

}
