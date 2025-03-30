package application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class WebScraping {
    public static void main(String[] args) {

        String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-" +
                "sociedade/atualizacao-do-rol-de-procedimentos";
        String keyword = "Anexo";

        String directoryName = "anexos";
        CreateDirectory.newDirectory(directoryName);

        try{
            Document document = Jsoup.connect(url).get();
            Elements links = document.select("a[href*="+keyword+"][href$=.pdf]");

            for(Element link: links){
                System.out.println("Document: "+ link);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
