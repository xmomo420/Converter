import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    public class Main {

        public static final String ERROR = "Erreur, nom de fichier invalide.\n";
        public static final String PROMPT = "Entrez le nom du fichier : ";

        public static String validerNomFichier (String msgErr, String prompt) {
            System.out.print(prompt);
            Scanner input = new Scanner(System.in);
            String nomFichier = input.next();
            boolean nonValide = !estPresent(nomFichier);
            while (nonValide) {
                System.out.println(msgErr);
                System.out.print(prompt);
                nomFichier = input.next();
                nonValide = !estPresent(nomFichier);
            }
            return nomFichier;
        }

        public static boolean estPresent (String nomFichier) {
            boolean estPresent;
            try {
                Path chemin = Paths.get(nomFichier);
                Stream<String> str = Files.lines(chemin);
                estPresent = true;
            } catch (IOException e) {
                estPresent = false;
            }
            return estPresent;
        }

        public static void afficherList(List<String> list) {
            for (String s : list) {
                System.out.println(s);
            }
        }

        public static ArrayList<String> stockerDonnees(List<String> list,
                                                       String prefix) {
            ArrayList<String> array = new ArrayList<>();
            String tmp = "";
            for (String ligne : list) {
                if (ligne.startsWith(prefix)) {
                    int indiceEspace = ligne.indexOf(' ');
                    boolean estEspace = false;
                    int i;
                    for (i = indiceEspace + 1; !estEspace; ++i)
                        estEspace = ligne.charAt(i) == ' ';
                    tmp = ligne.substring(indiceEspace, i).trim();
                    array.add(tmp);
                }
            }
            return array;
        }

        public static List<String> remplirListe (String nomFichier) throws IOException {
            Path chemin = Paths.get(nomFichier);
            Stream<String> str = Files.lines(chemin);
            return str.collect(Collectors.toList());
        }

        public static void main(String[] args) throws IOException {
            String test = validerNomFichier(ERROR, PROMPT);
            List<String> list = remplirListe(test);
            list = stockerDonnees(list, "fou");
            afficherList(list);
        }
    }

