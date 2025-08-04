package main.java.talent_program.java.java_8.HomeWork_5_1;

public class Circle extends Shape{
    private static final double pi = Math.PI;
    private String name;
    private double radius;

    @Override
    double calculateArea() {
        double r = radius;
        return pi * r * r;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
