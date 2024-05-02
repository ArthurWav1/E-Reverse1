package Ereverse.bean.articles;

import java.io.Serializable;

/**
 * Classe représentant un article du site web
 */
public class Article implements Serializable {

    //Attributs d'un article
    protected String type_Article;
    protected int id;
    protected String ref_Article;
    protected int id_type;
    protected int id_gamme;
    protected int id_couleur;
    protected String nom_Article;
    protected double prix;
    protected int nb_dispo;
    protected int nb_Achete;
    protected int id_Kit_appartenance;
    protected String description;


    //constructeur definissant les nom, ref et prix de l'article, pour consulter un article (en général)
    public Article(String ref_Article, String nom_Article, double prix) {
        this.ref_Article=ref_Article;
        this.nom_Article=nom_Article;
        this.prix=prix;
    }

    public Article(String ref_Article, String nom_Article, double prix, String description) {
        this.ref_Article=ref_Article;
        this.nom_Article=nom_Article;
        this.prix=prix;
        this.description=description;
    }

    public Article(){
    }
    //constructeur affectant reference et identifiant de l'article, pour ajouter un article
    public Article(int id, String ref_Article, String nom_Article,int id_type,double prix) {
        this(ref_Article,nom_Article,prix);
        this.id_type=id_type;
        this.id=id;
    }


    public String getNom_Article() {
        return nom_Article;
    }

    public int get_idType(){
        return id_type;}

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String get_ref(){
        return ref_Article;}

    public int get_nb_Achete() {
        return nb_Achete;
    }

    public int get_nb_dispo() {
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
    };

    /** Getters et Setters

     setters*/

    public void set_nom(String nom) {
        nom_Article = nom;
    }

    public void set_type(int id_type) {
        id_type= id_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
