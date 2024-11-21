package com.DesignPatterns.IteratorPattern.BookIterator;

public class Book {

    private int price;
    private String bookName;

    public Book(int price, String bookName) {
        this.price = price;
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public String getBookName() {
        return bookName;
    }
}
