package Ereverse.bean.articles;

import java.io.Serializable;

/**
 * Classe représentant un article du site web
 */
public class Article implements Serializable {

    //Attributs d'un article

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


    //constructeur definissant les nom, ref et prix de l'article, pour consulter un article (en général)
    public Article(String ref_Article, String nom_Article, double prix) {
        this.ref_Article=ref_Article;
        this.nom_Article=nom_Article;
        this.prix=prix;
    }

    public Article(){
    }
    //constructeur affectant reference et identifiant de l'article, pour ajouter un article
    public Article(int id, String ref_Article, String nom_Article,int id_type,double prix) {
        this(ref_Article,nom_Article,prix);
        this.id_type=id_type;
        this.id=id;
    }

    /** Getters et Setters

        getters*/
    public String get_Nom() {
        return nom_Article;
    }

    public int get_idType(){
        return id_type;}

    public double get_Prix() {
        return prix;
    }

    public int get_Id() {
        return id;
    }

    public String get_ref(){
        return ref_Article;}

    public int get_nb_Achete() {
        return nb_Achete;
    }

    public int get_nb_dispo() {
        return nb_dispo;
    }

    public int get_id_Kit(){
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

    public void set_prix(double prix) {
        this.prix = prix;
    }

    public void set_nb_achete(int nbAchete) {
        nb_Achete = nbAchete;
    }

    public void Set_id_Kit(int a){
        id_Kit_appartenance = a;}

    public void set_nb_dispo(int nb) {
        nb_dispo=nb;}


    @Override
    public String toString() {
        return super.toString();
    }
}
