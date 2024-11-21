package com.DesignPatterns.IteratorPattern.BookIterator;

import com.DesignPatterns.IteratorPattern.BookIterator.Iterators.Iterator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
                new Book(700, "Database Systems"),
                new Book(600, "Networking"),
                new Book(300, "Theory of Computation"),
                new Book(500, "OS Concepts")
        );

        Library lib = new Library(bookList);
        Iterator iterator = lib.createIterator();

        while(iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println("Name: \"" + book.getBookName() + "\" Price: " + book.getPrice());
        }
    }
}
