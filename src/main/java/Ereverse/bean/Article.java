package Ereverse.bean;

public class Article {

    private int id;
    private String nom;
    private double prix;
    private int nbAcheté;

    // Constructeur
    public Article(String nom, double prix) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbAcheté() {
        return nbAcheté;
    }

    public void setNbAcheté(int nbAcheté) {
        this.nbAcheté = nbAcheté;
    }
}
