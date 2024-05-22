package fr.cepi.test;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.articles.Article;
import Ereverse.bean.articles.Gamme;
import Ereverse.dao.ArticleDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ArticlesTest {

    /**
     * Initialisation du pool de connexion et création du DAO
     */
    @BeforeAll
    public static void init()  {
        try {
            ServiceConnexionBDD.setupDriver("src/main/webapp/WEB-INF/db.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Test de création, ajout et suppression d'un article
     */
    @Test
    public void test() {
        //test ajout d'article dans BDD
        ArticleDAO.AjoutArticle("ref 5", "saveur 1", "description", 50, null, 1, 1, 1, "gourde");

    }
    @Test
    public void test2(){
        //test supression d'article dans BDD
        ArticleDAO.suppression_article(new Article("ref 5","gourde",50));
    }

    @Test
    public void test3(){
        //test Trouver article dans BDD
        ArticleDAO.TrouverArticle("ref 2");
    }

    @Test
    public void testGamme(){
        ArticleDAO.ajoutGamme("gammeTest",100,150);

        ArrayList<Gamme> liste = ArticleDAO.listerGamme();
        for(Gamme g : liste){
            System.out.println("Id: " + g.getId_gamme() + " Gamme: " + g.getGamme() + " Prix: " + g.getPrix() + " Volume: " + g.getVolume());
        }

        ArticleDAO.supprimerGamme(liste.get(liste.size()-1).getId_gamme());

        liste = ArticleDAO.listerGamme();
        for(Gamme g : liste){
            System.out.println("Id: " + g.getId_gamme() + " Gamme: " + g.getGamme() + " Prix: " + g.getPrix() + " Volume: " + g.getVolume());
        }
    }
}
