package java.com.infoshareacademy.library;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;

import java.io.FileReader;
import java.io.IOException;

public class BookImportCSVImpl implements BookImportCSV {

    //    moze sciezke do pliku przekazywac w menu ?
//    wtedy nie trzeba jej tu inicjalizowac ??
    private static final String filePath = "/home/sly/myOwnTests/lista.csv";

    @Override
    public void bookObjectCreate(String pathFile) throws IOException {

        try (CSVReader czytnikCSV = new CSVReaderHeaderAware(new FileReader(filePath))) {

            String[] tablicaCSV;    //

            while ((tablicaCSV = czytnikCSV.readNext()) != null) {  //dopoki czytnikCSV odczytuje kolejne linie
                Book ksiazka = new Book(); //i teraz wszystko przez settery

                ksiazka.setIdBook(Integer.parseInt(tablicaCSV[0]));
                ksiazka.setTitleBook(tablicaCSV[1]);
                ksiazka.setAuthor(tablicaCSV[2]);
                ksiazka.setDateRelease(Integer.parseInt(tablicaCSV[3]));
                ksiazka.setIsbn(tablicaCSV[4]);
                ksiazka.setStatusLoan(false);
                ksiazka.setStatusReservation(true);
            }

        }

    }
}
