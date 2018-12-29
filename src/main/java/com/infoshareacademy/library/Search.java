package com.infoshareacademy.library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Search {

    public static void searchBook(ArrayList ksiazki) throws IOException {
//        Book ksiazka1 = new Book(1);
//        ksiazka1.setAuthor("Harvey Deitel");
//        ksiazka1.setIsbn("13242");
//        ksiazka1.setTitleBook("Programowanie w Javie. Solidna wiedza w praktyce.");
//
//        Book ksiazka2 = new Book(2);
//        ksiazka2.setAuthor("Joshua Bloch");
//        ksiazka2.setIsbn("13562");
//        ksiazka2.setTitleBook("Java. Efektywne programowanie. Wydanie III");
//
//        Book ksiazka3 = new Book(3);
//        ksiazka3.setAuthor("Craig Walls");
//        ksiazka3.setIsbn("17861");
//        ksiazka3.setTitleBook("Spring w akcji. Wydanie IV");

//        ArrayList<Book> lista = new ArrayList<>();
//        lista.add(ksiazka1);
//        lista.add(ksiazka2);
//        lista.add(ksiazka3);

        System.out.println("Wpisz tytuł książki:");
        Scanner tytul = new Scanner(System.in);
        String wpisanytytul = tytul.nextLine().toLowerCase();

        System.out.println("Wyniki wyszukiwania:");

        for (int i = 0; i < ksiazki.size(); i++) {
            String newTitleBook = ksiazki.get(i).toString().toLowerCase();
            if (newTitleBook.contains(wpisanytytul)) {
                System.out.println(ksiazki.get(i));
            }
        }
    }
}
