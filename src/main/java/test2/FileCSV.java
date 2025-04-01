package test2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileCSV {

    public static void fileToCSV (List<List<String>> table, String csvPath) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(csvPath))){

            for (List<String> row : table){
                String csvRow = String.join(",", row);
                bufferedWriter.write(csvRow);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

