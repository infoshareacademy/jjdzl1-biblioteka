package com.infoshareacademy.library;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Menu.header();
        MenuForImportData.readPathToFile();
        Menu.header();
        System.out.println("Wczytano plik z danymi");
        System.out.println();
        Menu.menuItems();
        Menu.menuApp();
    }
}
