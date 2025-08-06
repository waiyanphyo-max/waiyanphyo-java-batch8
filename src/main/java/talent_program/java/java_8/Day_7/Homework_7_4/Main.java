package main.java.talent_program.java.java_8.Day_7.Homework_7_4;

import main.java.talent_program.java.java_8.Day_7.Homework_7_1.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        final var students = getStudents();

        displayStudents(students);

        findTopStudent(students);

        removeStudent(students, "Kaung Kaung");

        displayStudents(students);
    }

    private static void removeStudent(HashMap<String, Integer> students, String name) {

        if(students.containsKey(name)) {
            students.remove(name);
            System.out.println(" ");
            System.out.printf("%s is removed successfully.%n", name);
        } else  {
            System.out.println(STR."There is no student with name = \{name}");
        }
    }

    private static void findTopStudent(HashMap<String, Integer> students) {

        String topStudent = null;
        Integer maxMarks = Integer.MIN_VALUE;

        var entryIterator = findEntry(students);

        while (entryIterator.hasNext()) {
            HashMap.Entry<String, Integer> entry =entryIterator.next();
            String name = entry.getKey();
            Integer mark = entry.getValue();

            if(mark > maxMarks) {
                maxMarks = mark;
                topStudent = name;
            }
        }

        System.out.println(" ");
        System.out.printf("%s is topStudent with marks of %s%n", topStudent, maxMarks);

    }

    private static void displayStudents(HashMap<String, Integer> students) {

        var entryIterator = findEntry(students);

        System.out.println(" ");
        while (entryIterator.hasNext()) {
            HashMap.Entry<String, Integer> entry =entryIterator.next();
            String name = entry.getKey();
            Integer mark = entry.getValue();
            System.out.printf("%s is %s marks%n", name, mark);
        }

    }

    private static Iterator<HashMap.Entry<String, Integer>> findEntry(HashMap<String, Integer> students) {

        return students.entrySet().iterator();

    }

    static HashMap<String, Integer> getStudents() {

        HashMap<String, Integer> marks = new HashMap<>();

        marks.put("Maung Maung", 443);
        marks.put("Aung Aung", 428);
        marks.put("Kaung Kaung", 489);
        marks.put("Khaing", 435);
        marks.put("Hlaing", 523);

        return marks;
    }

}
