package com.infoshareacademy.library;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        header();
        MenuForImportData.readPathToFile();

        header();
        System.out.println("Wczytano plik z danymi");
        System.out.println();

        // Funkcjonalnść poniżej jeszcze nie działa
        menuItems();
        int answer = MenuForImportData.readNumber();
        int i = 0;
        while (i < 1) {
            if (answer == 1) {
                System.out.println("Przeglądanie listy książek");
                Search.searchBook()
                header();
                menuItems();
            } else if (answer == 2) {
                System.out.println("Rezerwacja książki");
                // do stuff
                header();
                menuItems();
            } else if (answer == 3) {
                System.out.println("Wypożyczenie książki");
                // do stuff
                header();
                menuItems();
            } else if (answer == 4) {
                break;
            } else {
                System.out.println("Wpisano nieprawidłową wartość.");
                System.out.println("Wybierz ponownie.");
            }
            answer = MenuForImportData.readNumber();

        }
    }

    public static void header() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("|                        Witaj w aplikacji Bibliteka                        |");
        System.out.println("-----------------------------------------------------------------------------");

    }

    public static void menuItems() {
        System.out.println("1. Przegladanie listy książek");
        System.out.println("2. Rezerwacja książki");
        System.out.println("3. Wypożyczenie ksiązki");
        System.out.println("4. Zakończ program");
        System.out.println();
        System.out.println("Wybierz  1, 2, 3 lub 4 i naciśnij ENTER");

    }

}
