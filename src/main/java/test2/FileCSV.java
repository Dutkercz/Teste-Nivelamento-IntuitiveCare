package test2;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class FileCSV {

    public static void fileToCSV(List<List<String>> table, String csvPath) {

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvPath))) {
            for (List<String> row : table) {
                writer.writeNext(row.toArray(new String[0]));
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever o arquivo CSV", e);
        }
    }
}

