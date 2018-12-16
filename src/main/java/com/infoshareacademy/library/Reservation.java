package com.infoshareacademy.library;



import java.time.LocalDate;

public class Reservation {
    private int id;                     //id rezerwacji
    private Book book;
    private Reader reader;
    private LocalDate dateOfReservation;     //data rezerwacji
    private LocalDate dateOfExpiration;     //data wygaśnięcia rezerwacji

    public Reservation(int id, Book book, Reader reader, LocalDate dateOfReservation, LocalDate dateOfExpiration) {
        this.id = id;
        this.book = book;
        this.reader = reader;
        this.dateOfReservation = dateOfReservation;
        this.dateOfExpiration = dateOfExpiration;
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public LocalDate getDateOfReservation() {
        return dateOfReservation;
    }

    public LocalDate getDateOfExpiration() {
        return dateOfExpiration;
    }

    public int getId() {
        return id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setDateOfReservation(LocalDate dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public void setDateOfExpiration(LocalDate dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printReservation() {
        String description = String.format("Nr id rezerwacji: %s, Data rezerwacji: %s, Data wygaśnięcia rezerwacji: %s",
                id, dateOfReservation, dateOfExpiration);
        System.out.println(description);
        System.out.println("Dane czytelnika: "); //pobranie danych czytelnika i książki z innych klas
        reader.printReader();
        System.out.println("Numer książki w bazie: ");
        book.getIdBook();
        System.out.println("Tytuł książki: ");
        book.getTitleBook();
    }
}

