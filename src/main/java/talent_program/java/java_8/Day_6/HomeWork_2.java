package main.java.talent_program.java.java_8.Day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class HomeWork_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to do?");
        System.out.println("If do you want to write Students' scores, please type 'input[i]'");
        System.out.println("If do you want to read Students' scores, please type 'output[o]'");
        String answer = sc.nextLine();

        while (!Objects.equals(answer, "Exit")) {
            if (Objects.equals(answer, "i")) {
                studentScore();
                System.out.println("If do you want to write Students' scores, please type 'input'");
                System.out.println("If do you want to read Students' scores, please type 'output'");
                System.out.println("If do you want to exit, just type 'Exit'");
                answer = sc.nextLine();
            } else {
                read();
                answer = sc.nextLine();
            }
        }
    }

    static void studentScore() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a folder to store your file.");
            System.out.println("Example  : C:\\users");
            String input = sc.nextLine();
            String folder = input.replace("\\", "\\\\");
            String textFile = folder + "\\grades"+".txt";
            File myFile = new File(textFile);
            if(myFile.createNewFile()) {
                FileWriter myWriter = new FileWriter(textFile);
                System.out.println("Enter Students' scores line by line. Example : John, 85");
                System.out.println("Type 'End' when you finish");
                while (true) {
                    String line = sc.nextLine();
                    if(Objects.equals(line, "End")) {
                        break;
                    }
                    myWriter.write(line + "\n");
                }
                myWriter.close();
                System.out.println("File is written successfully");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }

    static void read() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter text-file to read Students' scores.");
            System.out.println("Example  : C:\\users\\text_file.txt");
            String input = sc.nextLine();
            String textFile = input.replace("\\", "\\\\");
            File myFile = new File(textFile);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String texts = myReader.nextLine();
                String[] arrays = texts.split(", ");
                System.out.println(" ");
                System.out.println("Name   : "+arrays[0]);
                System.out.println("Score  : "+arrays[1]);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong");
        }
    }
}
