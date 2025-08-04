package main.java.talent_program.java.java_8.HomeWork_5_1;

public class Rectangle extends Shape{
    private String name;
    private double width;
    private double length;

    @Override
    double calculateArea() {
        return width * length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
