package com.infoshareacademy.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.infoshareacademy.library.BookStatus.*;

public class BookService {
    private int id;
    private Book book;
    private Reader reader;
    private LocalDate dateOfChangeOfStatus;
    private LocalDate dateOfExpiry;

    public BookService(int id, Book book, Reader reader, LocalDate dateOfChangeOfStatus, LocalDate dateOfExpiry) {
        this.id = id;
        this.book = book;
        this.reader = reader;
        this.dateOfChangeOfStatus = dateOfChangeOfStatus;
        this.dateOfExpiry = dateOfExpiry;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setDateOfChangeOfStatus(LocalDate dateOfChangeOfStatus) {
        this.dateOfChangeOfStatus = dateOfChangeOfStatus;
    }

    public void setDateOfExpiry(LocalDate dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
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

    public LocalDate getDateOfChangeOfStatus() {
        return dateOfChangeOfStatus;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    @Override
    public String toString() {
        return "BookService{" +
                "id=" + id +
                ", book=" + book +
                ", reader=" + reader +
                ", dateOfChangeOfStatus=" + dateOfChangeOfStatus +
                ", dateOfExpiry=" + dateOfExpiry +
                '}';
    }

    protected static final List<BookService> listOfReservation = new ArrayList<>();
    protected static final List<BookService> listOfBorrowedBooks = new ArrayList<>();
    private static List<Book> positions;

    public static void bookService() {
        //pobranie pozycji z wyszukiwarki
        positions = Search.searchBook();
        System.out.println();

        //sprawdzenie czy wyszukiwanie znalazło więcej niż jedną książkę (lub żadnej)
        if (positions.isEmpty()) {
            System.out.println("Nie znaleziono książki" + "\n");
            chooseOption();
        } else if (positions.size() > 1) {
            System.out.println("Nie możesz wybrać kilku książek jednocześnie, musisz zawęzić wyszukiwanie książki" + "\n");
            positions.clear();
            chooseOption();
        } else {
            //jeśli znalazło jedną książkę pytamy użytkownika o rezerwację
            System.out.println(Menu.getAnswer() == 2 ? "Potwierdzam rezerwację: (T/N)" : "Potwierdzam wypożyczenie: (T/N)");
            Scanner text = new Scanner(System.in);
            String answer = text.nextLine().toLowerCase();
            if (answer.equals("t")) {
                if (positions.get(0).getStatus().equals(AVAILABLE))
                    addBookToList();
                else {
                    System.out.println("Ta pozycja nie jest dostępna - sprawdź status książki" + "\n");
                    chooseOption();
                }
            } else if (answer.equals("n")) {
                chooseOption();
            } else {
                System.out.println("Podałeś niepoprawną komendę" + "\n");
                bookService();
            }
        }
    }

    public static void addBookToList() {
        if (Menu.getAnswer() == 2) {
            //zmiana statusu książki
            positions.get(0).setStatus(RESERVED);

            BookService reservation = new BookService
                    (listOfReservation.size() + 1, positions.get(0), null, LocalDate.now(), LocalDate.now().plusDays(3));
            System.out.println("Zarezerwowana książka:");
            System.out.println(reservation);

            //dodanie książki do listy rezerwacji
            listOfReservation.add(reservation);
        } else if (Menu.getAnswer() == 3) {
            positions.get(0).setStatus(BORROWED);

            BookService borrowedBook = new BookService
                    (listOfBorrowedBooks.size() + 1, positions.get(0), null, LocalDate.now(), LocalDate.now().plusDays(30));
            System.out.println("Wypożyczona książka:");
            System.out.println(borrowedBook);

            //dodanie książki do listy wypożyczeń
            listOfBorrowedBooks.add(borrowedBook);
        }
    }

    // wyświetlenie listy rezerwacji
    public static void showBooksInLists() {
        System.out.println("Lista rezerwacji: ");
        if (listOfReservation.isEmpty())
            System.out.println("brak");
        else {
            for (BookService j : listOfReservation)
                System.out.println(j);
        }
        System.out.println("Lista wypożyczeń: ");
        if (listOfBorrowedBooks.isEmpty())
            System.out.println("brak");
        else {
            for (BookService j : listOfBorrowedBooks)
                System.out.println(j);
        }
    }

    //metoda do nawigacji w menu
    public static void chooseOption() {
        System.out.println("Wybierz opcję:");
        System.out.println("1. Wyszukaj ponownie");
        System.out.println("2. Powrót do menu");
        try {
            Scanner text = new Scanner(System.in);
            int chooseOption = text.nextInt();
            switch (chooseOption) {
                case 1:
                    bookService();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Wybierz 1 lub 2");
                    chooseOption();
            }
        } catch (InputMismatchException e) {
            System.out.println("Podałeś niepoprawny znak");
            chooseOption();
        }
    }
}
