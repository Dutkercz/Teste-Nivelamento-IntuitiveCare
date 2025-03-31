package test2;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PDFExtract {

    public static List<String[]> extractDataPDF (String pdfPath, Map<String, String> abbreviation){
        System.out.println("Estou 1");
        try{
            PDDocument pdDocument = Loader.loadPDF(new File(pdfPath));
            List<String[]> tableInfo = new ArrayList<>();
            System.out.println("Estou 2");


            PDFTextStripper textStripper = new PDFTextStripper();
            textStripper.setStartPage(3);

            String pdfText = textStripper.getText(pdDocument);
            String[] rows = pdfText.split("\n");

            tableInfo.add(rows[0].split("\\s{2}"));

            for (int i = 1; i < rows.length ; i++) {
                String[] rowInfo = rows[i].split("\\s{2}");

                for (int j = 0; j < rows.length; j++) {
                    if (abbreviation.containsKey(rowInfo[j])){
                        rowInfo[j] = abbreviation.get(rowInfo[j]);
                    }
                }
                tableInfo.add(rowInfo);
            }

            return tableInfo;

        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
