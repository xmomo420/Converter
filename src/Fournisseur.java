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

    private ProduitFournisseur produit;
    private Adresse adresse;

}
