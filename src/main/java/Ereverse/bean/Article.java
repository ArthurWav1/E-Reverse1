package Ereverse.bean;

import java.io.Serializable;

/**
 * Classe représentant un article du site web
 */
public class Article implements Serializable {

    //Attributs d'un article

    private int id;
    private int ref_Article;
    private String type_Article;
    private String nom_Article;
    private double prix;
    protected int nb_article_dispo;
    private int nb_Acheté;
    private int id_Kit_appartenance;


    //constructeur definissant les nom, type et prix de l'article
    public Article(String nom_Article, String type_Article,double prix) {
        this.type_Article=type_Article;
        this.nom_Article=nom_Article;
        this.prix=prix;
    }

    //constructeur affectant reference et identifiant de l'article
    public Article(int id, int ref_Article, String nom_Article,String type_Article,double prix) {
        this(nom_Article,type_Article,prix);
        this.id=id;
        this.ref_Article=ref_Article;
    }

    // Méthodes d'accès (getters et setters) pour les propriétés

    public String get_Nom() {
        return nom_Article;
    }

    public void set_Nom(String nom) {
        this.nom_Article = nom;
    }

    public String get_Type(){
        return type_Article;}

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public int getNbAcheté() {
        return nb_Acheté;
    }

    public void setNbAcheté(int nbAcheté) {
        this.nb_Acheté = nbAcheté;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
