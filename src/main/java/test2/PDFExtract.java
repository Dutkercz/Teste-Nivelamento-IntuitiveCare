package test2;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PDFExtract {

    public static List<List<String>> extractDataPDF (String pdfPath, Map<String, String> abbreviation) {

        try (PDDocument pdDocument = Loader.loadPDF(new File(pdfPath))) {

            List<List<String>> tableInfo = new ArrayList<>();

            PDFTextStripper textStripper = new PDFTextStripper();

            textStripper.setStartPage(4);//remover

            String pdfText = textStripper.getText(pdDocument);



            String[] rows = pdfText.split("\n");

            System.out.println(rows.length);
            int rowsAffect = 0;

            for (String row : rows) {
                List<String> rowInfo = new ArrayList<>(List.of(row.split("\\s{1,}")));

                for (int j = 0; j < rowInfo.size(); j++) {

                    if(abbreviation.containsKey(rowInfo.get(j))){
                        rowInfo.set(j, abbreviation.get(rowInfo.get(j)));
                        rowsAffect+=1;
                    }

                }
                tableInfo.add(rowInfo);
            }
            System.out.println(rowsAffect);
            return tableInfo;


            } catch(IOException e){
                throw new RuntimeException(e);
            }
        }
    }