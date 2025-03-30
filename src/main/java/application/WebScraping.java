package application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.CreateDirectory;
import utils.Downloader;
import utils.FileZip;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebScraping {
    public static void main(String[] args) {

        String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-" +
                "sociedade/atualizacao-do-rol-de-procedimentos";
        String keyword = "Anexo";

        String directoryName = "anexos";
        File directory = CreateDirectory.newDirectory(directoryName);

        try {
            Document document = Jsoup.connect(url).get();
            Elements links = document.select("a[href*=" + keyword + "][href$=.pdf]");

            List<String> files = new ArrayList<>();
            for (Element link : links) {
                String urlFile = link.absUrl("href");
                files.add(Downloader.fileDownloader(directory.getPath(), urlFile));
            }
            String fileZipName = directory + "\\anexos.zip";

            FileZip.Ziper(fileZipName, files);

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
