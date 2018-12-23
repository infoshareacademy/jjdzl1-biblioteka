package com.infoshareacademy.library;

import java.time.LocalDate;

public class BookService {
    private int id;
    private Book book;
    private Reader reader;
    private LocalDate firstDate;
    private LocalDate secondDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setFirstDate(LocalDate firstDate) {
        this.firstDate = firstDate;
    }

    public void setSecondDate(LocalDate secondDate) {
        this.secondDate = secondDate;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public LocalDate getFirstDate() {
        return firstDate;
    }

    public LocalDate getSecondDate() {
        return secondDate;
    }

    @Override
    public String toString() {
        return "BookService{" +
                "id=" + id +
                ", book=" + book +
                ", reader=" + reader +
                ", firstDate=" + firstDate +
                ", secondDate=" + secondDate +
                '}';
    }
}
