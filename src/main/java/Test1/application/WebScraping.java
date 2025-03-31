package Test1.application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import Test1.application.utils.CreateDirectory;
import Test1.application.utils.Downloader;
import Test1.application.utils.FileZip;
import test2.PDFExtract;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebScraping {
    public static void main(String[] args) {

//        String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-" +
//                "sociedade/atualizacao-do-rol-de-procedimentos";
//        String keyword = "Anexo";
//
//        String directoryName = "anexos";
//        File directory = CreateDirectory.newDirectory(directoryName);
//
//        try {
//            Document document = Jsoup.connect(url).get();
//            Elements links = document.select("a[href*=" + keyword + "][href$=.pdf]");
//
//            List<String> files = new ArrayList<>();
//            for (Element link : links) {
//                System.out.println("Processando");
//                String urlFile = link.absUrl("href");
//                files.add(Downloader.fileDownloader(directory.getPath(), urlFile));
//            }
//            String fileZipName = directory + "\\anexos.zip";
//
//            FileZip.Ziper(fileZipName, files);

            Map<String, String> abbreviattion = new HashMap<>();
            abbreviattion.put("OD", "Seg. Odontológica");
            abbreviattion.put("AMB"," Seg. Ambulatorial" );

            var teste = PDFExtract.extractDataPDF("C:\\anexos\\Anexo_I_Rol_2021RN_465.2021_RN627L.2024.pdf", abbreviattion);
            System.out.println(teste);

//        } catch (IOException e) {
//            throw new RuntimeException(e.getMessage());
//        }
    }
}
