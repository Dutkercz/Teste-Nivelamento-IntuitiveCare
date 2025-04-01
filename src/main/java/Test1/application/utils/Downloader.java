package Test1.application.utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class Downloader {

    public static String fileDownloader(String directory, String urlFile) {

        // O nome do arquivo será extraido logo após a ultima barra ("/") da url.
        String fileName = urlFile.substring(urlFile.lastIndexOf('/') + 1);

        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlFile))
                    .GET()
                    .build();

            String pathFile = directory + File.separator + fileName;

            HttpResponse<Path> response = client.send
                    (request, HttpResponse.BodyHandlers.ofFile
                            (Path.of(pathFile)));

            if (response.statusCode() == 200) {
                System.out.println("Download concluido!");
                return pathFile;
            } else {
                System.out.println("Erro ao tentar efetuar o download.");
                return null;
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
