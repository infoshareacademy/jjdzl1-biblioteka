package com.infoshareacademy.library;


import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuForImportData {

//    SlyT - to pierwsza zmiana
public static List<Book> listaKsiazek;

    public static void readPathToFile() throws IOException {
        String path = "";
        String defaultFileLocation = "src/main/resources/books.csv";
        System.out.println("Wczytywanie danych z pliku zewnętrznego");
        System.out.println("Domyślna lokalizacja pliku: \"" + defaultFileLocation + "\"");

        // Wczytywanie pozycji menu
        printMenuItems();
        int i = 0;
        while (i < 1) {
            int answer = readNumber();
            if (answer == 1) {
                path = defaultFileLocation;
                System.out.println("Wybrano domyślną lokalizację pliku: \"" + path + "\"");
                i++;
            } else if (answer == 2) {
                System.out.println("Wybrano inny plik. Podaj scieżke do pliku i naciśnij ENTER.");
                Scanner scanner1 = new Scanner(System.in);
                path = scanner1.next();
                System.out.println("Nowa lokalizacja pliku to: \"" + path + "\"");

                // sprawdzenie czy w podanej sciezce istnieje taki plik
                File file = new File(path);
                if (file.exists() && !file.isDirectory()) {
                    i++;
                } else {
                    System.out.println("Błąd: Pliku nie odnaleziono! Wybierz ponownie.");
                    printMenuItems();
                }

            } else {
                System.out.println("Wpisano nieprawidłową wartość.");
                System.out.println("Wybierz ponownie.");
                printMenuItems();
            }
        }
        //uruchamia metodę wczytywania danych z pliku csv
        BookImportCSV bookImportCSV = new BookImportCSVImpl();
//        SlyT - to druga zmiana
        listaKsiazek = bookImportCSV.bookObjectCreate(path);
    }

    public static void printMenuItems() {
        // Poszczegolne pozycje menu
        System.out.println();
        System.out.println("1. Wczytaj plik z domyślnej lokalizacji");
        System.out.println("2. Wczytaj plik z innej lokalizacji  ");
        System.out.println();
        System.out.println("Wybierz 1 lub 2 i naciśnij ENTER");
    }

    public static int readNumber() {
        // odczyt wyboru uzytkownika
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        try {
            answer = scanner.nextInt();
        } catch (InputMismatchException e) {
        }
        return answer;
    }

}