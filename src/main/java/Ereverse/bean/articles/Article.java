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


    //constructeur definissant les nom, ref et prix de l'article, pour consulter un article (en général)
    public Article(int ref_Article, String nom_Article, double prix) {
        this.ref_Article=ref_Article;
        this.nom_Article=nom_Article;
        this.prix=prix;
    }

    //constructeur affectant reference et identifiant de l'article, pour ajouter un article
    public Article(int id, int ref_Article, String nom_Article,String type_Article,double prix) {
        this(ref_Article,nom_Article,prix);
        this.type_Article=type_Article;
        this.id=id;
        this.ref_Article=ref_Article;
    }

    /** Getters et Setters

        getters*/
    public String get_Nom() {
        return nom_Article;
    }

    public String get_Type(){
        return type_Article;}

    public double get_Prix() {
        return prix;
    }

    public int get_Id() {
        return id;
    }

    public int get_ref(){
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

    public void set_type(String type) {
        type_Article = type;
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
