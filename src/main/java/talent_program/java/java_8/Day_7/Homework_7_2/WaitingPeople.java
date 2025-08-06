package main.java.talent_program.java.java_8.Day_7.Homework_7_2;

import java.util.Iterator;
import java.util.LinkedList;

public class WaitingPeople {
    public static void main(String[] args) {
        LinkedList<String> waitingPeople = new LinkedList<>();

        waitingPeople.add("Daw May Thi");
        waitingPeople.add("Daw Sein Kyi");
        waitingPeople.add("U Hla");
        waitingPeople.add("Daw Mya");
        waitingPeople.add("U Ba");

        System.out.println(" ");
        for (String waitingPerson : waitingPeople) {
            System.out.println(waitingPerson);
        }

        waitingPeople.removeFirst();

        System.out.println(" ");
        for (String waitingPerson : waitingPeople) {
            System.out.println(waitingPerson);
        }

        waitingPeople.addLast("U Thein Tan");

        System.out.println(" ");
        for (String waitingPerson : waitingPeople) {
            System.out.println(waitingPerson);
        }

        System.out.println(" ");
        System.out.printf("%d people are waiting%n", waitingPeople.size());
    }

}
