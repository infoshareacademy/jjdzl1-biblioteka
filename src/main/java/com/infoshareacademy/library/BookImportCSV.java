package com.infoshareacademy.library;

import java.io.IOException;
import java.util.List;

public interface BookImportCSV {

    List bookObjectCreate(String filePath) throws IOException;

}
