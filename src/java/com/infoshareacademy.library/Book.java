package java.com.infoshareacademy.library;

public class Book {
    private int idBook ;                           // numer id książki - unikatowy
    private String titleBook;                          // tytuł książki
    private String autor;                          // autor lub autorzy książki
    private int dateRelease;                       // data wydania książki - tylko rok
    private int isbn;                              // numer ISBN książki
    private Boolean statusLoan = false;            // status wypożyczenia - true/false wypożyczona/nie wypożyczona
    private Boolean statusReservation = false;     // status rezerwacji - true/false zarezerwowana/nie zarezerwowana

// konstruktor

    public Book(int idBook, String titleBook, String autor, int dateRelease, int isbn, Boolean statusLoan, Boolean statusReservation) {
        this.idBook = idBook;
        this.titleBook = titleBook;
        this.autor = autor;
        this.dateRelease = dateRelease;
        this.isbn = isbn;
        this.statusLoan = statusLoan;
        this.statusReservation = statusReservation;
    }

//gettery

    public int getIdBook() {
        return idBook;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public String getAutor() {
        return autor;
    }

    public int getDateRelease() {
        return dateRelease;
    }

    public int getIsbn() {
        return isbn;
    }

    public Boolean getStatusLoan() {
        return statusLoan;
    }

    public Boolean getStatusReservation() {
        return statusReservation;
    }

// settery tylko dla pól true/false które będą zmieniane w trakcie pracy programu

    public void setStatusLoan(Boolean statusLoan) {
        this.statusLoan = statusLoan;
    }

    public void setStatusReservation(Boolean statusReservation) {
        this.statusReservation = statusReservation;
    }

// wyświetla info o książce
    public void printBook(int idBook, String titleBook, String autor, int dateRelease, int isbn, Boolean statusLoan, Boolean statusReservation){
        System.out.println("Informacje o książce:");
        System.out.println("Numer w systemie: "+idBook);
        System.out.println("Tytuł : " +titleBook);
        System.out.println("Autor: "+autor);
        System.out.println("Rok wydania: "+dateRelease);
        System.out.println("Numer ISBN: "+isbn);
        System.out.println("Czy wypożyczona: "+statusLoan);
        System.out.println("Czy zarezerwowana: "+statusReservation);
    }
// być może jeszcze inne metody tu się pojawią jak dodawanie książki, wyszukiwanie itd ..
}