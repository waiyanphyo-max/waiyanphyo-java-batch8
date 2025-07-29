package main.java.talent_program.java.java_8;

public class MyTriangle {
    public static void main(String[] args) {
        for(int j = 1; j<6; j++) {
            System.out.println("%s%s%s".formatted(" ".repeat(5-j), "*".repeat(j+(j-1)), " ".repeat(5-j)));
        }
    }
}
