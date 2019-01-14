package com.infoshareacademy.library;

import com.opencsv.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BookImportCSVImpl implements BookImportCSV {



    @Override
    public List<Book> bookObjectCreate(String filePath) throws IOException {

        //tworzymy liste obiektow Book o typie (????) ArrayList
        List<Book> ksiazki = new ArrayList<>();

        //tworzymy parser w ktorym okreslamy zasady parsowania / przetwarzania pliku csv
        CSVParser parser = new CSVParserBuilder()
                                .withIgnoreQuotations(true)
                                .withIgnoreLeadingWhiteSpace(true)
                                .withSeparator(';')     //mozemy szybko zmienic separator w razie potrzeby
                                .build();


        try (CSVReader czytnikCSV = new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(parser).withSkipLines(1).build()) {      //czytnik ignoruje linie 1 tj. naglowkowa

            String[] tablicaCSV;    //prosta tablica przetrzymujaca poszczegolne pola wiersza z pliku CSV

            //i w petli
            while ((tablicaCSV = czytnikCSV.readNext()) != null) {  //dopoki czytnikCSV odczytuje kolejne linie
                Book ksiazka = new Book(Integer.parseInt(tablicaCSV[0])); //raz nadane idBook jest juz niezmienne

                // i teraz wszystko przez settery
                ksiazka.setTitleBook(tablicaCSV[1]);
                ksiazka.setAuthor(tablicaCSV[2]);
                ksiazka.setDateRelease(Integer.parseInt(tablicaCSV[3]));
                ksiazka.setIsbn(tablicaCSV[4]);
                ksiazka.setStatusLoan(false);       //tego nie zaciagmy z pliku bo przy imporcie zakladamy start od zera ? chyba ze dodamy oblsuge zapisu pliku po zmianach
                ksiazka.setStatusReservation(false); // j.w.

//                i teraz to listy
                ksiazki.add(ksiazka);
            }

            return ksiazki;
        }
    }
}
