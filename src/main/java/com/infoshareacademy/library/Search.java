package com.infoshareacademy.library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {

//    SlyT - metoda statyczna
    public static void searchBook(List<Book> ksiazki) throws IOException {

        System.out.println("Wpisz tytuł książki:");
        Scanner tytul = new Scanner(System.in);
        String wpisanytytul = tytul.nextLine().toLowerCase();

        System.out.println("Wyniki wyszukiwania:");


        for (int i = 0; i < MenuForImportData.listaKsiazek.size(); i++) {
            String newTitleBook = MenuForImportData.listaKsiazek.get(i).toString().toLowerCase();
            if (newTitleBook.contains(wpisanytytul)) {
                System.out.println(MenuForImportData.listaKsiazek.get(i));
            }
        }
    }
}
