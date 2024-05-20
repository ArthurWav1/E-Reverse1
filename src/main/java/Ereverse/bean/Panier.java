package Ereverse.bean;

import Ereverse.bean.articles.Article;
import jakarta.el.CompositeELResolver;

import java.util.ArrayList;
import java.io.Serializable;

public class Panier implements Serializable {
    //private ArrayList<Article> articles = new ArrayList<>();
    private int id_utilisateur;
    private int id_article;
    private int nb_article;
    public Panier(int id_utilisateur, int id_article) {
        this.id_utilisateur = id_utilisateur;
        this.id_article = id_article;
        }

       //setters
    public void set_nb_articles (int nb) {
        nb_article = nb;
    }

    //getters
    public int get_nb_article(){
        return nb_article;
    }

    public int get_id_article(){
        return id_article;
    }
    public int get_id_utilisateur (){
        return id_utilisateur;
    }

    //public ArrayList get_articles (){
        //return articles;
    //}

    //public void add_article(Panier panier, Article article) {
      //  panier.get_articles().add(article);
    //}

    // Méthode pour supprimer un produit du panier
    //public void supp_article(Panier panier, Article article) {
      //  panier.get_articles().remove(article);
    //}

    //calcul du montant des articles d'un panier

    public double Prix_article_Panier(Panier panier, Article article){
        return nb_article*article.getPrix();
        //double somme = 0;
        //ArrayList <Article> list_articles = panier.get_articles();
        //for( Article article : list_articles) {
          //  somme += article.getPrix();
        //}
        //return somme;
    }

    public Panier(int id_utilisateur){
        this.id_utilisateur = id_utilisateur;
    }

}



