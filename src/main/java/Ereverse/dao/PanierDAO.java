package Ereverse.dao;

import Ereverse.bean.Panier;
import Ereverse.bean.articles.Article;

import java.util.ArrayList;

public class PanierDAO {


    // Méthode pour ajouter un produit au panier
    public void add_article(Panier panier, Article article) {
        panier.get_articles().add(article);
    }

    // Méthode pour supprimer un produit du panier
    public void supp_article(Panier panier, Article article) {
        panier.get_articles().remove(article);
    }

    //calcul du montant des articles d'un panier
    public double TotalPanier(Panier panier){
        double somme = 0;
        ArrayList <Article> list_articles = panier.get_articles();
        for( Article article : list_articles) {
            somme += article.getPrix();
        }
        return somme;
    }

}
