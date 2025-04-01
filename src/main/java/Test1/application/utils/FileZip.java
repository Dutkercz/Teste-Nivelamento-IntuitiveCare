package Test1.application.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileZip {

    public static void Ziper(String fileName, List<String> files) {

        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(fileName))) {
            for (String file : files) {
                File fileToZip = new File(file);
                try (FileInputStream fileIn = new FileInputStream(fileToZip)) {
                    zipOut.putNextEntry(new ZipEntry(fileToZip.getName()));
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fileIn.read(buffer)) >= 0) {
                        zipOut.write(buffer, 0, length);
                    }
                    zipOut.closeEntry();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
