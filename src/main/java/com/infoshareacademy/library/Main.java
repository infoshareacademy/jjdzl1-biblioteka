package com.infoshareacademy.library;

public class Main {

    public static void main(String[] args) {
        header();
        if (MenuForImportData.fileIsLoaded == 0) {
            MenuForImportData.returnPathToFile();
        }
        MenuForImportData.fileIsLoaded = 1;
        System.out.println(MenuForImportData.fileIsLoaded);
        if (MenuForImportData.fileIsLoaded == 1) {
            header();
            System.out.println("Wczytano plik z danymi");
            System.out.println();
            // Funkcjonalnść poniżej jeszcze nie działa
            System.out.println("1. Przegladanie listy książek");
            System.out.println("2. Rezerwacja książki");
            System.out.println("3. Wypożyczenie ksiązki");
        }
    }

    public static void header() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("|                                                                           |");
        System.out.println("|                        Witaj w aplikacji Bibliteka                        |");
        System.out.println("|                                                                           |");
        System.out.println("-----------------------------------------------------------------------------");

    }

}
