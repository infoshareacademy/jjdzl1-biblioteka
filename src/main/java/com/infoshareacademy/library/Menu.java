package com.infoshareacademy.library;

public class Menu {

    private Menu(){
        throw new IllegalStateException("Klasa uzytkowa");
    }

    private static int answer;

    public static int getAnswer() {
        return answer;
    }

    public static void menuApp() {
        answer = MenuForImportData.readNumber();
        int i = 0;
        while (i < 1) {
            if (answer == 1) {
                System.out.println("Przeglądanie listy książek");
                Search.searchBook();
                header();
                menuItems();
            } else if (answer == 2) {
                System.out.println("Rezerwacja książki");
               BookService.bookService();
                header();
                menuItems();
            } else if (answer == 3) {
                System.out.println("Wypożyczenie książki");
                BookService.bookService();
                header();
                menuItems();
            } else if (answer == 4) {
                BookService.showBooksInLists();
                header();
                menuItems();
            } else if (answer == 5)
                break;
            else {
                System.out.println("Wpisano nieprawidłową wartość.");
                System.out.println("Wybierz ponownie.");
            }
            answer = MenuForImportData.readNumber();

        }
    }
    public static void header() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("|                 Witaj w aplikacji Biblioteka by Arkadius                   |");
        System.out.println("-----------------------------------------------------------------------------");

    }

    public static void menuItems() {
        System.out.println("1. Przegladanie listy książek");
        System.out.println("2. Rezerwacja książki");
        System.out.println("3. Wypożyczenie książki");
        System.out.println("4. Lista zarezerwowanych/wypożyczonych książek");
        System.out.println("5. Zakończ program");
        System.out.println();
        System.out.println("Wybierz  1, 2, 3, 4 lub 5 i naciśnij ENTER");

    }
}
