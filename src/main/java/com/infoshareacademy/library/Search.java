package com.infoshareacademy.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
    public static List<Book> searchBook() {
        List<Book> positions = new ArrayList<>();
        System.out.println("Wpisz tytuł książki lub naciśnij ENTER aby wyświetlić wszystkie:");
        Scanner title = new Scanner(System.in);
        String inputTitle = title.nextLine().toLowerCase();

        System.out.println("Wyniki wyszukiwania:");

        for (int i = 0; i < MenuForImportData.listaKsiazek.size(); i++) {
            String newTitleBook = MenuForImportData.listaKsiazek.get(i).getTitleBook().toLowerCase();
            if (newTitleBook.contains(inputTitle)) {
                System.out.println(MenuForImportData.listaKsiazek.get(i));
                positions.add(MenuForImportData.listaKsiazek.get(i));
            }
        }
        return positions;
    }
}
