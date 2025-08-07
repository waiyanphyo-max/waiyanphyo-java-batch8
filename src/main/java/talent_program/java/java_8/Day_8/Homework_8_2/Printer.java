package main.java.talent_program.java.java_8.Day_8.Homework_8_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Printer<T> {

    ArrayList<T> arrayList = new ArrayList<>();

    public void add(T item) {
        arrayList.add(item);
    }

    public void printAll() {
        System.out.println(arrayList.toString());
    }
}
