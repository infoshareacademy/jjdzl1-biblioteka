package com.infoshareacademy.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Reservation extends BookService {
    @Override
    public String toString() {
        return "Reservation{}" + super.toString();
    }

    public static List<Reservation> listOfReservation = new ArrayList<>();

    public static void reservation() {
        //pobranie pozycji z wyszukiwarki
        List<Book> positions = Search.searchBook();
        System.out.println();

        //sprawdzenie czy wyszukiwanie znalazło więcej niż jedną książkę (lub żadnej)
        if (positions.size() == 0) {
            System.out.println("Nie znaleziono książki" + "\n");
            chooseOption();
        } else if (positions.size() > 1) {
            System.out.println("Nie możesz zarezerwować kilku książek jednocześnie, musisz zawęzić wyszukiwanie książki" + "\n");
            chooseOption();
        } else {
            //jeśli znalazło jedną książkę pytamy użytkownika o rezerwację
            System.out.println("Czy zarezerwować znalezioną książkę? (T/N)");
            Scanner text = new Scanner(System.in);
            String answer = text.nextLine().toLowerCase();
            if (answer.equals("t")) {
                if (positions.get(0).getStatusReservation() || positions.get(0).getStatusLoan()) {
                    System.out.println("Ta książka jest już zarezerwowana lub wypożyczona" + "\n");
                    chooseOption();
                } else {
                    //zmiana statusu książki
                    positions.get(0).setStatusReservation(true);

                    //tworzenie obiektu rezerwacji
                    Reservation reservation = new Reservation();
                    reservation.setBook(positions.get(0));
                    reservation.setFirstDate(LocalDate.now());
                    reservation.setSecondDate(LocalDate.now().plusDays(3));
                    reservation.setId(listOfReservation.size() + 1);

                    System.out.println("Zarezerwowałeś książkę:");
                    System.out.println(reservation);

                    //dodanie rezerwacji do listy
                    Reservation.listOfReservation.add(reservation);
                }
            } else if (answer.equals("n")) {
                chooseOption();
            } else {
                System.out.println("Podałeś niepoprawną komendę" + "\n");
                reservation();
            }
        }
    }

    // wyświetlenie listy rezerwacji
    public static void showReservation() {
        System.out.println("Twoje rezerwacje to: ");
        if (listOfReservation.size() == 0)
            System.out.println("brak");
        else {
            for (Reservation j : listOfReservation)
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
                    reservation();
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




