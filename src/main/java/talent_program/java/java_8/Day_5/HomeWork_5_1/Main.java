package main.java.talent_program.java.java_8.Day_5.HomeWork_5_1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final var arrayList = getShapes();

        Shape[] shapes = arrayList.toArray(new Shape[0]);

        for (Shape shape : shapes) {
            System.out.println(" ");
            if(shape instanceof Circle) {
                System.out.printf("Area of %s is %s%n", ((Circle) shape).getName(), (double) Math.round(shape.calculateArea() * 100 / 100));
            } else if (shape instanceof Rectangle) {
                System.out.printf("Area of %s is %s%n", ((Rectangle) shape).getName(), (double) Math.round(shape.calculateArea() * 100 / 100));
            }
        }
    }

    private static ArrayList<Shape> getShapes() {
        Circle circle1 = new Circle();
        circle1.setName("Circle-1");
        circle1.setRadius(4.5);

        Rectangle rectangle1 = new Rectangle();
        rectangle1.setName("Rectangle-1");
        rectangle1.setWidth(20.05);
        rectangle1.setLength(7.2);

        Circle circle2 = new Circle();
        circle2.setName("Circle-2");
        circle2.setRadius(3.08);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setName("Rectangle-2");
        rectangle2.setWidth(50.99);
        rectangle2.setLength(22.42);

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(circle1);
        shapes.add(rectangle1);
        shapes.add(circle2);
        shapes.add(rectangle2);

        return shapes;
    }
}
