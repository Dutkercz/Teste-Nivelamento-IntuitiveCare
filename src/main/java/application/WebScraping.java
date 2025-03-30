package application;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebScraping {
    public static void main(String[] args) {



        String url = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-da-" +
                "sociedade/atualizacao-do-rol-de-procedimentos";

        try{
            Document document = Jsoup.connect(url).get();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
