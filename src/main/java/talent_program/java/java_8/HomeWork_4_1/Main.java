package main.java.talent_program.java.java_8.HomeWork_4_1;

import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        final var arrayList = getPeople();

        Person[] people = arrayList.toArray(new Person[0]);

        for (Person person : people) {

            if(Objects.equals(person.getRole(), "Student")) {
                System.out.println("Hello Sir.");
            } else {
                System.out.println("Hello Kid.");
            }
            person.introduce(person.getName(), person.getAge());
        }
    }

    private static ArrayList<Person> getPeople() {
        Student student = new Student("Mg Mg", 17);
        Student student1 = new Student("Mya Mya", 19);

        Teacher teacher = new Teacher("Oo Saw", 35);
        Teacher teacher1 = new Teacher("Daw Hla", 40);

        student.setGradeLevel(3);
        student1.setGradeLevel(4);

        teacher.setSubject("Physics");
        teacher1.setSubject("Chemistry");

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(student);
        arrayList.add(teacher);
        arrayList.add(student1);
        arrayList.add(teacher1);
        return arrayList;
    }
}
