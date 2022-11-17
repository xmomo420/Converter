package gestionFichier;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.IOUtils;

public class FileReader {
    public static String loadFileIntoString(String filePath,
                                            String fileEncoding) throws
            FileNotFoundException, IOException {
        return IOUtils.toString(Files.newInputStream(Paths.get(filePath)), fileEncoding);
    }
}