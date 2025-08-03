package main.java.talent_program.java.java_8.HomeWork_4_6;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void discount(double disPercent) {
        this.price -= price * (disPercent / 100.00);
        System.out.println(" ");
        System.out.printf("%s is now discounted by %s%%. So new price is %s MMK%n", title, disPercent, price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "\nTitle    : " + title +
                "\nAuthor   : " + author +
                "\nPrice    : " + price + " MMK"
                ;
    }
}
