package java.com.infoshareacademy.library;

import infoshareacademy.library.Reader;

import java.time.LocalDate;

public class Borrow {
    private int id;                     //id wypożyczenia
    private Book book;
    private Reader reader;
    private LocalDate dateOfBorrow;     //data wypożyczenia
    private LocalDate dateOfReturn;     //data wymaganego zwrotu książki


    public Borrow(int id, Book book, Reader reader, LocalDate dateOfBorrow, LocalDate dateOfReturn) {
        this.id = id;
        this.book = book;
        this.reader = reader;
        this.dateOfBorrow = dateOfBorrow;
        this.dateOfReturn = dateOfReturn;
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

    public int getId() {
        return id;
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

    public void setId(int id) {
        this.id = id;
    }

    public void printBorrow() {
        String description = String.format("Nr id wypożyczenia: %s, Data wypożyczenia: %s, Data wymaganego zwrotu: %s",
                id, dateOfBorrow, dateOfReturn);
        System.out.println(description);
        System.out.println("Dane czytelnika: "); //pobranie danych czytelnika i książki z innych klas
        reader.printReader();
        System.out.println("Numer książki w bazie: ");
        book.getIdBook();
        System.out.println("Tytuł książki: ");
        book.getTitleBook();
    }
}



