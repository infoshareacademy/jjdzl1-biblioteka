package com.infoshareacademy.library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reservation extends BookService {
    @Override
    public String toString() {
        return "Reservation{}" + super.toString();
    }

    public static List<Reservation> listOfReservation = new ArrayList<Reservation>();

    public static void reservation() {
        List<Book> positions = Search.searchBook();
        System.out.println();

//sprawdzenie czy wyszukiwanie znalazło więcej niż jedną książkę (lub żadnej)

        if (positions.size() == 0) {
            System.out.println("Nie znaleziono książki, spróbuj ponownie" + "\n");
            reservation();
        } else if (positions.size() > 1) {
            System.out.println("Nie możesz zarezerwować kilku książek jednocześnie, musisz zawęzić wyszukiwanie książki" + "\n");
            reservation();
        } else {
//jeśli znalazło jedną książkę pytamy użytkownika o rezerwację
            System.out.println("Czy zarezerwować znalezioną książkę? (Y/N)");
            Scanner text = new Scanner(System.in);
            String answer = text.nextLine().toLowerCase();
            if (answer.equals("y")) {
                if (positions.get(0).getStatusReservation() || positions.get(0).getStatusLoan()) {
                    System.out.println("Ta książka jest już zarezerwowana lub wypożyczona");
                    reservation();
                } else {
                    positions.get(0).setStatusReservation(true);
//tworzenie obiektu rezerwacji
                    Reservation reservation = new Reservation();
                    reservation.setBook(positions.get(0));
                    reservation.setFirstDate(LocalDate.now());
                    reservation.setSecondDate(LocalDate.now().plusDays(3));
                    if (listOfReservation.size() < 1)
                        reservation.setId(1);
                    else {
                        reservation.setId(listOfReservation.size() + 1);
                    }
                    Reservation.listOfReservation.add(reservation);
                }
            } else if (answer.equals("n")) {
                reservation();
            } else {
                System.out.println("Podałeś niepoprawną komendę");
                reservation();
            }
        }
// tworzenie listy rezerwacji i wyświetlenie użytkownikowi
        System.out.println("Twoje rezerwacje to: ");
        for (Reservation j : listOfReservation)
            System.out.println(j);
    }
}



