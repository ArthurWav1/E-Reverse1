package Ereverse.bean;

import Ereverse.bean.articles.Article;
import jakarta.el.CompositeELResolver;

import java.util.ArrayList;
import java.io.Serializable;

public class Panier implements Serializable {
    private ArrayList<Article> articles = new ArrayList<>();
    private int id_utilisateur;
    private int id_article;
    private int nb_article;
    public Panier(int id_utilisateur, int id_article) {
        this.id_utilisateur = id_utilisateur;
        this.id_article = id_article;
        }

       //setters
    public void Set_nb_articles () {
        nb_article = articles.size();
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

    public ArrayList get_articles (){
        return articles;
    }
}



