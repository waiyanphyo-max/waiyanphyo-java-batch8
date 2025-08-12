package main.java.talent_program.java.java_8.Day_10.Learn;

import java.sql.*;
import java.util.Scanner;


public class DatabaseLearn {

    private static final String URL = "jdbc:mysql://localhost:3306/bookstoredb";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) throws ClassNotFoundException {

        try (Scanner sc = new Scanner(System.in)) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                System.out.println("Connected to database!");

                System.out.print("Enter student name: ");
                String name = sc.nextLine();

                System.out.print("Enter student age: ");
                int age = sc.nextInt();

                String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, name);
                    ps.setInt(2, age);
                    ps.executeUpdate();
                    System.out.println("Student added successfully!");
                }

                String query = "SELECT * FROM students";
                try (Statement st = conn.createStatement();
                     ResultSet rs = st.executeQuery(query)) {
                    while (rs.next()) {
                        System.out.println(STR."\{rs.getInt("id")} - \{rs.getString("name")} - \{rs.getInt("age")}");   }
                }
            } catch (Exception e) {
                e.printStackTrace(); } } }

}