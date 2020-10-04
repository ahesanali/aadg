package com.saralhisab.androidlearning;

/**
 * Created by del790 on 22-08-2016.
 */
public class Book {

    private String bookTitle;
    private String author;
    private double price;

    public Book() {

    }

    public Book(String bookTitle, String author, double price) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.price = price;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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
}
