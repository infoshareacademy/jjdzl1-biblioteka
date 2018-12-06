package java.com.infoshareacademy.library;

import infoshareacademy.library.Reader;

import java.time.LocalDate;

public class Borrow {
    private Book book;
    private Reader reader;
    private LocalDate dateOfBorrow;     //data wypożyczenia
    private LocalDate dateOfReturn;     //data wymaganego zwrotu książki
    private int days;                   //pole przechowujące pozostałą ilość dni do oddania książki, również ilość dni
    // do naliczenia kary za przetrzymanie książki (jeśli days<0)


    public Borrow(Book book, Reader reader, LocalDate dateOfBorrow, LocalDate dateOfReturn, int days) {
        this.book = book;
        this.reader = reader;
        this.dateOfBorrow = dateOfBorrow;
        this.dateOfReturn = dateOfReturn;
        this.days = days;
    }

    public Book getBook() {
        return book;
    }

    public Reader getReader() {
        return reader;
    }

    public LocalDate getDateOfBorrow() {
        return dateOfBorrow;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public int getDays() {
        return days;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setDateOfBorrow(LocalDate dateOfBorrow) {
        this.dateOfBorrow = dateOfBorrow;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void printBorrow() {
        String description = String.format("Data wypożyczenia: %s, Data wymaganego zwrotu: %s, Pozostało dni do oddania: %s",
                dateOfBorrow, dateOfReturn, days);
        System.out.println(description);
        System.out.println("Dane czytelnika: "); //pobranie danych czytelnika i książki z innych klas
        reader.printReader();
        System.out.println("Numer książki w bazie: ");
        book.getIdBook();
        System.out.println("Tytuł książki: ");
        book.getTitleBook();
    }
}



