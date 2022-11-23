public class Fournisseur extends Station {
     enum ProduitFournisseur {
        ACANTHITE("acanthite", 2),
        CASSITERITE("cassiteerite", 7),
        CHALCOCITE("chalcocite", 3),
        CHARBON("charbo", 1),
        ;

        public final String nom;
        public final int nombreTours;

         ProduitFournisseur(String nom, int nombreTours) {
            this.nom = nom;
            this.nombreTours = nombreTours;
        }
    }
    private int numeroStation;
    private int numeroBoite;
    private String produit;
    private Adresse adresse;

    public Fournisseur(int numeroStation, int numeroBoite,
                       String produit) {
        this.numeroStation = numeroStation;
        this.numeroBoite = numeroBoite;
        this.produit = produit;
    }

    public String toString () {
        return "fou F: " + numeroStation + " " + produit + " " +
                numeroBoite
                + " (" + numeroStation + "," + numeroBoite + ")";
    }
}


