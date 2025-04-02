package test2;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PDFExtract {

    public static List<List<String>> extractDataPDF(String pdfPath) {

        try (PDDocument pdDocument = Loader.loadPDF(new File(pdfPath))) {
            List<List<String>> tableInfo = new ArrayList<>();
            PDFTextStripper textStripper = new PDFTextStripper();
            String pdfText = textStripper.getText(pdDocument);
            String[] rows = pdfText.split("\n");

            for (String row : rows) {
                List<String> rowInfo = new ArrayList<>(List.of(row.split("\\s+")));
                tableInfo.add(ConvertAbbreviations.converter(rowInfo));
            }
            return tableInfo;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}