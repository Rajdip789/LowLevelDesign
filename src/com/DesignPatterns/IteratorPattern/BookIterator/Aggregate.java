package com.DesignPatterns.IteratorPattern.BookIterator;

import com.DesignPatterns.IteratorPattern.BookIterator.Iterators.Iterator;

public interface Aggregate {
    Iterator createIterator();
}
