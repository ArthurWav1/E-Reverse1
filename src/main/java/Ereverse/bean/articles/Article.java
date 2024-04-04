package Ereverse.bean.articles;

import java.io.Serializable;

/**
 * Classe représentant un article du site web
 */
public class Article implements Serializable {

    //Attributs d'un article

    protected int id;
    protected int ref_Article;
    protected String type_Article;
    protected String nom_Article;
    protected double prix;
    protected int nb_dispo;
    protected int nb_Achete;
    protected int id_Kit_appartenance;
    protected String caracteristique;


    //constructeur definissant les nom, ref et prix de l'article, pour consulter un article (en général)
    public Article(int ref_Article, String nom_Article, double prix, String caracteristique) {
        this.ref_Article = ref_Article;
        this.nom_Article = nom_Article;
        this.prix = prix;
        this.caracteristique = caracteristique;
    }

    //constructeur affectant reference et identifiant de l'article, pour ajouter un article
    public Article(int id, int ref_Article, String nom_Article, String type_Article, double prix, String caracteristique) {
        this(ref_Article, nom_Article, prix, caracteristique);
        this.type_Article = type_Article;
        this.id = id;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRef_Article() {
        return ref_Article;
    }

    public void setRef_Article(int ref_Article) {
        this.ref_Article = ref_Article;
    }

    public String getType_Article() {
        return type_Article;
    }

    public void setType_Article(String type_Article) {
        this.type_Article = type_Article;
    }

    public String getNom_Article() {
        return nom_Article;
    }

    public void setNom_Article(String nom_Article) {
        this.nom_Article = nom_Article;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNb_dispo() {
        return nb_dispo;
    }

    public void setNb_dispo(int nb_dispo) {
        this.nb_dispo = nb_dispo;
    }

    public int getNb_Achete() {
        return nb_Achete;
    }

    public void setNb_Achete(int nb_Achete) {
        this.nb_Achete = nb_Achete;
    }

    public int getId_Kit_appartenance() {
        return id_Kit_appartenance;
    }

    public void setId_Kit_appartenance(int id_Kit_appartenance) {
        this.id_Kit_appartenance = id_Kit_appartenance;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }
}