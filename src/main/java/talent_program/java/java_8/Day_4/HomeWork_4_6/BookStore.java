package main.java.talent_program.java.java_8.Day_4.HomeWork_4_6;

import java.util.ArrayList;

public class BookStore {
    public static void main(String[] args) {
        final var arrayList = getBooks();

        Book[] books = arrayList.toArray(new Book[0]);

        for( Book book : books) {
            System.out.println(book.toString());
        }
    }

    private static ArrayList<Book> getBooks() {
        Book book1 = new Book("War And Peace", "Leo Tolstoy", 80000.00);
        book1.discount(20);
        Book book2 = new Book("A Game Of Thrones", "George R.R. Martin", 48000.00);
        Book book3 = new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 55000.00);

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        return books;
    }
}
