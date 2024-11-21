package com.DesignPatterns.IteratorPattern.BookIterator;

import com.DesignPatterns.IteratorPattern.BookIterator.Iterators.BookIterator;
import com.DesignPatterns.IteratorPattern.BookIterator.Iterators.Iterator;

import java.util.List;

public class Library implements Aggregate {
    private List<Book> bookList;

    public Library(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public Iterator createIterator() {
        return new BookIterator(bookList);
    }
}
