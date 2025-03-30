package application;

import java.io.File;

public class CreateDirectory {

    public static void newDirectory(String directoryName) {
        File directory = new File("C:\\" + directoryName +"\\");
        if(!directory.exists()){
            directory.mkdir();
            System.out.println("Diretorio criado em " + directory.getAbsolutePath());
        }else {
            System.out.println("Diretório " + directory.getName() + " encontrado em " + directory.getAbsolutePath());
        }
    }
}
