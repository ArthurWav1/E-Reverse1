package fr.cepi.test;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.Client;
import Ereverse.bean.articles.Article;
import Ereverse.dao.ArticleDAO;
import Ereverse.dao.ClientDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ArticlesTest {
    private static ArticleDAO dao;

    /**
     * Initialisation du pool de connexion et création du DAO
     */
    @BeforeAll
    public static void init()  {
        try {
            ServiceConnexionBDD.setupDriver("src/main/webapp/WEB-INF/db.properties");
            dao = new ArticleDAO();
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
        dao.AjoutArticle("ref 1", "saveur 1", "description", 50, null, 1, 1, 1, "gourde");

        //test supression d'article dans BDD
       //dao.supression_article(new Article("ref 2","gourde",50));

        //test Trouver article dans BDD
        //dao.TrouverArticle("ref 2");


    }
}
