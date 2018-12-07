package java.com.infoshareacademy.library;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.io.IOException;

public class CSVCreateObjects {

    // klasa wykonawcza ?
//id;tytuł;autor;rok_wydania;isbn;status_wyp;status_rez
    private static final String filePath = "/home/sly/myOwnTests/lista.csv";


    public static void main(String[] args) throws IOException {


        try (CSVReader czytnikCSV = new CSVReader(new FileReader(filePath))) {
//        CSVReader czytnikCSV = new CSVReaderBuilder(new FileReader(filePath)).build();

            String[] tablicaCSV;
            while ((tablicaCSV = czytnikCSV.readNext()) != null) {
                System.out.println("ID : " + tablicaCSV[0]);
                System.out.printf("Autor: %s", tablicaCSV[1]);
                System.out.println("Rok wydania: " + tablicaCSV[2]);
                System.out.printf("Rok wydania: %s", tablicaCSV[4]);
                System.out.printf("ISBN: %s", tablicaCSV[5]);
                System.out.printf("Czy wypozyczona: %s", tablicaCSV[6]);
                System.out.printf("Czy zarezerwowana: %s", tablicaCSV[7]);
            }
        }
    }
}
