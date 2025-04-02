import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import test1.CreateDirectory;
import test1.Downloader;
import test1.FileZip;
import test2.FileCSV;
import test2.PDFExtract;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraping {

    private static final String URL = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-" +
            "sociedade/atualizacao-do-rol-de-procedimentos";

    private static final String LINK_KEYWORD = "Anexo";

    public static void main(String[] args) {

        String directoryName = "anexos";
        File directory = CreateDirectory.newDirectory(directoryName);
        String fileZipName = directory + "\\anexos.zip";
        String csvZipName = directory + "\\Teste_CristianDutkercz.zip";
        String csvPathFile = directory + "\\dados.csv";

        try {
            Document document = Jsoup.connect(URL).get();
            Elements links = document.select("a[href*=" + LINK_KEYWORD + "][href$=.pdf]");

            List<String> files = new ArrayList<>();
            for (Element link : links) {
                System.out.println("Processando download.");
                String urlFile = link.absUrl("href");
                files.add(Downloader.fileDownloader(directory.getPath(), urlFile));
            }
            FileZip.zipper(fileZipName, files);

            String pdfPath = directory + "\\Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf";
            List<List<String>> tableFile = PDFExtract.extractDataPDF(pdfPath);
            FileCSV.fileToCSV(tableFile, csvPathFile);
            FileZip.zipper(csvZipName, List.of(csvPathFile));

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
