import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Niveau {
    //
    public static final String ERROR = "Erreur, nom de fichier invalide.\n";
    public static final String PROMPT = "Entrez le nom du fichier contenant le niveau : ";
    //
    private String nomFichier;
    private int montantDebut;
    private int montantVictoire;
    private List<String[]> ligneFichiers;

    public Niveau(){}

    public ArrayList<Station> extraireDonnees() throws IOException {
        String nomFichier = validerNomFichier(ERROR, PROMPT);
        List<String> list = remplirListe(nomFichier);
        ArrayList<Station> stations;
        montantDebut = Integer.parseInt(list.get(0));
        montantVictoire= Integer.parseInt(list.get(1));
    }

    public ArrayList<Station> remplirStations(List<String> list) {
        ArrayList<Station> stations = new ArrayList<>(list.size());
        Fournisseur f;
        Machine m;
        String[] tab;
        for (String ligne : list) {
            if (ligne.startsWith("fou")) {
                tab = ligne.split(" ");
                f = new Fournisseur(Integer.parseInt(tab[1]),
                        Integer.parseInt(tab[2]), tab[3]);
                stations.add(f);
            } else if (ligne.startsWith("m")) {
                tab = ligne.split(" ");
                m = new Machine();
            }


        }
    }

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

    public static List<String> remplirListe (String nomFichier) throws IOException {
        Path chemin = Paths.get(nomFichier);
        Stream<String> str = Files.lines(chemin);
        return str.collect(Collectors.toList());
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

}
