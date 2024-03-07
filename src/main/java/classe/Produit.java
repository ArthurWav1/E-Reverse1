package classe;

public class Produit {
    private String nom;
    private double prix;

    // Constructeur
    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // Méthodes d'accès (getters et setters) pour les propriétés
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
