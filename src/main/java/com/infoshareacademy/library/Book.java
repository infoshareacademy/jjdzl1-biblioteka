package com.infoshareacademy.library;

public class Book {
    private int idBook;
    private String titleBook;
    private String author;
    private int dateRelease;
    private String isbn;
    private BookStatus status;


    public Book(int idBook) {
        this.idBook = idBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDateRelease(int dateRelease) {
        this.dateRelease = dateRelease;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIdBook() {
        return idBook;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public String getAuthor() {
        return author;
    }

    public int getDateRelease() {
        return dateRelease;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", titleBook='" + titleBook + '\'' +
                ", author='" + author + '\'' +
                ", dateRelease=" + dateRelease +
                ", isbn='" + isbn + '\'' +
                ", status=" + status +
                '}';
    }

    public void printBook() {
        System.out.println("Informacje o książce:");
        System.out.println("Numer w systemie: " + idBook);
        System.out.println("Tytuł : " + titleBook);
        System.out.println("Autor: " + author);
        System.out.println("Rok wydania: " + dateRelease);
        System.out.println("Numer ISBN: " + isbn);
        System.out.println("Status: " + status);
    }
}