package main.java.talent_program.java.java_8.Day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class JavaFiles {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("What do you want to do.");
            System.out.println("Choose : 1. Write a file,  2. Read file.  3. Delete the file, 4. Exit");
            int answer = sc.nextInt();

            while (answer <= 4) {
                if (answer == 1) {
                    write();
                    System.out.println("Choose : 1. Write a file,  2. Read file.  3. Delete the file, 4. Exit");
                    answer = sc.nextInt();
                } else if (answer == 2) {
                    fileRead();
                    System.out.println("Choose : 1. Write a file,  2. Read file.  3. Delete the file, 4. Exit");
                    answer = sc.nextInt();
                } else if (answer == 3) {
                    fileDelete();
                    System.out.println("Choose : 1. Write a file,  2. Read file.  3. Delete the file, 4. Exit");
                    answer = sc.nextInt();
                } else if (answer == 4) {
                    System.out.println("Exiting.....");
                    break;
                } else {
                    System.out.println("Please choose within 1 to 4.");
                    System.out.println("Exiting.....");
                    break;
                }
            }
    }

    static void write() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter text-file to write your texts");
            System.out.println("Example  : C:\\users\\text_file.txt");
            String input = sc.nextLine();
            String textFile = input.replace("\\", "\\\\");
            FileWriter myWriter = new FileWriter(textFile);
            myWriter.write("Java is amazing. They say.\n");
            System.out.println("Enter texts what do you want to write. Type 'End' when you finish");
            while (true) {
                String line = sc.nextLine();
                if(Objects.equals(line, "End")) {
                    break;
                }
                myWriter.write(line + "\n");
            }
            myWriter.close();
            System.out.println("File is written successfully");
        } catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
    static void fileRead() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter text-file to read texts.");
            System.out.println("Example  : C:\\users\\text_file.txt");
            String input = sc.nextLine();
            String textFile = input.replace("\\", "\\\\");
            File myFile = new File(textFile);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String texts = myReader.nextLine();
                System.out.println(texts);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong");
        }
    }

    static void fileDelete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text-file to delete.");
        System.out.println("Example  : C:\\users\\text_file.txt");
        String input = sc.nextLine();
        String textFile = input.replace("\\", "\\\\");
        File myFile = new File(textFile);
        try {
            if(myFile.delete()) {
                System.out.println("Text-File is deleted.");
            }
        } catch (Exception e) {
            System.out.println("Text-File can't deleted.");
        }
    }
}
