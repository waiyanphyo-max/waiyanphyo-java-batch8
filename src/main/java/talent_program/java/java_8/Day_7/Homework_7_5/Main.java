package main.java.talent_program.java.java_8.Day_7.Homework_7_5;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final var arrayList = getStudents();

        final var hashSet = getSubjects();

        final var hashMap = getStud_Subs(arrayList, hashSet);

        printStudents(hashMap);

        System.out.println(" ");
        System.out.println("Enter Student's name and subject to add subject");
        Scanner sc = new Scanner(System.in);
        String add_name = sc.nextLine();
        String add_subject = sc.nextLine();
        addSubject(add_name, add_subject, hashMap);

        System.out.println(" ");
        System.out.println("Enter Student's name and subject to remove subject from that student");
        Scanner scanner = new Scanner(System.in);
        String remove_name = scanner.nextLine();
        String remove_subject = scanner.nextLine();
        removeSubject(remove_name, remove_subject, hashMap);

        displayAllSubjects(hashMap);
    }

    private static void displayAllSubjects(HashMap<String, HashSet<String>> hashMap) {
        HashSet<String> allSubjects = new HashSet<>();

        for (HashSet<String> subject : hashMap.values()) {
            allSubjects.addAll(subject);
        }

        System.out.println(" ");
        System.out.println("Here are all subjects offered in the department :");
        String[] subjects = allSubjects.toArray(new String[0]);

        for (int i = 0; i<subjects.length; i++){
            System.out.printf("%s. %s%n", i+1, subjects[i]);
        }

    }

    private static void removeSubject(String name, String subject, HashMap<String, HashSet<String>> hashMap) {
        Iterator<HashMap.Entry<String , HashSet<String>>> iterator = hashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, HashSet<String>> entry = iterator.next();
            if (Objects.equals(entry.getKey(), name)) {
                entry.getValue().remove(subject);
                System.out.println(" ");
                System.out.printf("%s is so boring in learning %s%n",name, subject);
                System.out.println(entry.getKey());
                for (String subs : entry.getValue()) {
                    System.out.println("      "+subs);
                }
            }
        }
    }

    private static void addSubject(String name, String subject, HashMap<String, HashSet<String>> hashMap) {

        Iterator<HashMap.Entry<String , HashSet<String>>> iterator = hashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, HashSet<String>> entry = iterator.next();
            if (Objects.equals(entry.getKey(), name)) {
                entry.getValue().add(subject);
                System.out.println(" ");
                System.out.printf("%s is also learn %s%n",name, subject);
                System.out.println(entry.getKey());
                for (String subs : entry.getValue()) {
                    System.out.println("      "+subs);
                }
            }
        }

    }

    private static void printStudents(HashMap<String, HashSet<String>> hashMap) {

        Iterator<HashMap.Entry<String , HashSet<String>>> iterator = hashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            HashMap.Entry<String, HashSet<String>> entry = iterator.next();
            String student = entry.getKey();
            HashSet<String> subjects = entry.getValue();
            System.out.println(" ");
            System.out.println(student);
            for (String subs : subjects) {
                System.out.println("      "+subs);
            }
        }
    }

    private static HashMap<String, HashSet<String>> getStud_Subs(ArrayList<String> arrayList, HashSet<String> hashSet) {

        HashMap<String, HashSet<String>> stud_subs= new HashMap<>();

        for (String student : arrayList) {
                stud_subs.put(student, new HashSet<>(hashSet));
        }
        return stud_subs;
    }

    private static HashSet<String> getSubjects() {
        String subject1 = "Physics";
        String subject2 = "Chemistry";
        String subject3 = "Biology";
        String subject4 = "History";
        String subject5 = "Economy";

        HashSet<String> subjects = new HashSet<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);
        subjects.add(subject4);
        subjects.add(subject5);

        return subjects;
    }

    static ArrayList<String> getStudents() {
        String student1 = "Maung Maung";
        String student2 = "Kaung Kaung";
        String student3 = "Aung Aung";

        ArrayList<String> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        return students;
    }
}
