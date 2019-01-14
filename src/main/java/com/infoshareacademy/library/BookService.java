package com.infoshareacademy.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.infoshareacademy.library.BookServiceType.BORROW;
import static com.infoshareacademy.library.BookServiceType.RESERVATION;

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

    public static List<BookService> listOfReservation = new ArrayList<>();
    public static List<BookService> listOfBorrowedBooks = new ArrayList<>();

    public static void bookService(BookServiceType type) {
        //pobranie pozycji z wyszukiwarki
        List<Book> positions = Search.searchBook();
        System.out.println();

        //sprawdzenie czy wyszukiwanie znalazło więcej niż jedną książkę (lub żadnej)
        if (positions.size() == 0) {
            System.out.println("Nie znaleziono książki" + "\n");
            chooseOption(type);
        } else if (positions.size() > 1) {
            System.out.println("Nie możesz wybrać kilku książek jednocześnie, musisz zawęzić wyszukiwanie książki" + "\n");
            chooseOption(type);
        } else {
            //jeśli znalazło jedną książkę pytamy użytkownika o rezerwację
            if (type.equals(RESERVATION)) System.out.println("Potwierdzam rezerwację: (T/N)");
            else System.out.println("Potwierdzam wypożyczenie: (T/N)");
            Scanner text = new Scanner(System.in);
            String answer = text.nextLine().toLowerCase();
            if (answer.equals("t")) {
                if (positions.get(0).getStatusReservation() || positions.get(0).getStatusLoan()) {
                    System.out.println("Ta książka jest już zarezerwowana lub wypożyczona" + "\n");
                    chooseOption(type);
                } else if (type.equals(RESERVATION)) {
                    //zmiana statusu książki
                    positions.get(0).setStatusReservation(true);

                    //tworzenie obiektu rezerwacji
                    BookService reservation = new BookService();
                    reservation.setBook(positions.get(0));
                    reservation.setFirstDate(LocalDate.now());
                    reservation.setSecondDate(LocalDate.now().plusDays(3));
                    reservation.setId(listOfReservation.size() + 1);

                    System.out.println("Zarezerwowana książka:");
                    System.out.println(reservation);

                    //dodanie rezerwacji do listy
                    BookService.listOfReservation.add(reservation);
                } else if (type.equals(BORROW)) {
                    positions.get(0).setStatusLoan(true);

                    //tworzenie obiektu wypożyczenia
                    BookService borrowedBook = new BookService();
                    borrowedBook.setBook(positions.get(0));
                    borrowedBook.setFirstDate(LocalDate.now());
                    borrowedBook.setSecondDate(LocalDate.now().plusDays(30));
                    borrowedBook.setId(listOfBorrowedBooks.size() + 1);

                    System.out.println("Wypożyczona książka:");
                    System.out.println(borrowedBook);

                    //dodanie książki do listy wypożyczeń
                    BookService.listOfBorrowedBooks.add(borrowedBook);
                }
            } else if (answer.equals("n")) {
                chooseOption(type);
            } else {
                System.out.println("Podałeś niepoprawną komendę" + "\n");
                bookService(type);
            }
        }
    }

    // wyświetlenie listy rezerwacji
    public static void showBooksInLists() {
        System.out.println("Lista rezerwacji: ");
        if (listOfReservation.size() == 0)
            System.out.println("brak");
        else {
            for (BookService j : listOfReservation)
                System.out.println(j);
        }
        System.out.println("Lista wypożyczeń: ");
        if (listOfBorrowedBooks.size() == 0)
            System.out.println("brak");
        else {
            for (BookService j : listOfBorrowedBooks)
                System.out.println(j);
        }
    }

    //metoda do nawigacji w menu
    public static void chooseOption(BookServiceType type) {
        System.out.println("Wybierz opcję:");
        System.out.println("1. Wyszukaj ponownie");
        System.out.println("2. Powrót do menu");
        try {
            Scanner text = new Scanner(System.in);
            int chooseOption = text.nextInt();
            switch (chooseOption) {
                case 1:
                    bookService(type);
                case 2:
                    break;
                default:
                    System.out.println("Wybierz 1 lub 2");
                    chooseOption(type);
            }
        } catch (InputMismatchException e) {
            System.out.println("Podałeś niepoprawny znak");
            chooseOption(type);
        }
    }
}
