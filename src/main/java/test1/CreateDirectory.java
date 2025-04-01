package test1;

import java.io.File;

public class CreateDirectory {

    public static File newDirectory(String directoryName) {

        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
            System.out.println("Diretorio criado em " + directory.getAbsolutePath());
            return directory;
        } else {
            System.out.println("Diretório " + directory.getName() + " encontrado em " + directory.getAbsolutePath());
            return directory;
        }
    }
}
