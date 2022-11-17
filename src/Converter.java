import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class Converter {
    public static void saveStringIntoFile(String filePath, String contentToSave)
            throws IOException {
        File f = new File(filePath);
        FileUtils.writeStringToFile(f, contentToSave, "UTF-8");
    }

    public static String loadFileIntoString(String filePath,
                                            String fileEncoding) throws
            IOException {
        return IOUtils.toString(Files.newInputStream(Paths.get(filePath)), fileEncoding);
    }

    public static String snailCase(String fichier) {
        int i = 0;
        char c;
        StringBuilder fichierMod = new StringBuilder(fichier);
        try {
            while (i + 1< fichierMod.length()) {
                if (Character.isLowerCase(fichierMod.charAt(i)) && Character.isUpperCase(fichierMod.charAt(i + 1))) {
                    c = Character.toLowerCase(fichierMod.charAt(i + 1));
                    fichierMod.deleteCharAt(i + 1);
                    fichierMod.insert(i + 1, "_" + c);
                }
                i++;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("String : " + fichierMod + "\nIndice i : " + i);
        }
        return fichierMod.toString();
    }

    public static void main(String[] args) throws IOException {
        int i = 0;
        try {
            while (i < args.length) {
                String input = loadFileIntoString(args[i], "UTF-8");
                String output = snailCase(input);
                saveStringIntoFile(args[i++], output);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(args[i]);
        }


        /*
        String input;
        int i = 0;
        while (i < args.length) {
            input = loadFileIntoString(args[i], "UTF-8");
            input = input.replace("    ","   ");
            saveStringIntoFile(args[i++], input);
        }*/
    }
}
