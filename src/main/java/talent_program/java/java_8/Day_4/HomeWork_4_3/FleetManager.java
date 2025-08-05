package main.java.talent_program.java.java_8.Day_4.HomeWork_4_3;

import java.util.ArrayList;

public class FleetManager {
    public static void main(String[] args) {
        final var arrayList = getVehicle();

        Vehicle[] vehicles = arrayList.toArray(new Vehicle[0]);

        for (Vehicle vehicle : vehicles) {
            System.out.println(" ");
            vehicle.startEngine();

            if(vehicle instanceof Car car) {
                car.drive();
            } else if (vehicle instanceof MotorCycle cycle) {
                cycle.drive();
            }

            if(vehicle.getVehicleType() == VehicleType.Car && vehicle.getFuelLevel() <= 50) {
                System.out.println("Car is refueled.");
            } else if (vehicle.getVehicleType() == VehicleType.MotorCycle && vehicle.getFuelLevel() <= 10) {
                System.out.println("MotorCycle is refueled");
            }
        }
    }

    private static ArrayList<Vehicle> getVehicle() {
        Car bmw = new Car("Germany", 2009);
        bmw.setFuelLevel(20);

        MotorCycle honda = new MotorCycle("Japan", 2017);
        honda.setFuelLevel(5);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(bmw);
        vehicles.add(honda);
        return vehicles;
    }
}
