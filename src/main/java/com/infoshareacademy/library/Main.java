package com.infoshareacademy.library;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Menu.header();
        MenuForImportData.readPathToFile();
        Menu.header();
        Menu.menuItems();
        Menu.menuApp();
    }
}
