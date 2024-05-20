package fr.cepi.test;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.Client;
import Ereverse.bean.Panier;
import Ereverse.bean.articles.Article;
import Ereverse.dao.ArticleDAO;
import Ereverse.dao.PanierDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/** Classe de test de la classe PanierDAO */

public class PanierTest {
    private static PanierDAO dao;

    /**
     * Initialisation du pool de connexion et création du DAO
     */
    @BeforeAll
    public static void init()  {
        try {
            ServiceConnexionBDD.setupDriver("src/main/webapp/WEB-INF/db.properties");
            dao = new PanierDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Test d'ajout article dans le panier d'un utilisateur
     */
    @Test
    public void test() {
        Client client = new Client("pnom","nom", "mail", "adress");
        Article article = ArticleDAO.TrouverArticle("ref 1");
        int id_client = client.getId();
        Panier panier = new Panier(id_client, article.get_id(), 0);

        //ajout article
        dao.ajout_d_article(panier,article);

        //supp article
        //dao.supression_d_article(panier,article);

        //Changement nbarticle
        //dao.modification_nb_articles_panier(panier,5);

        //Recupération liste des articles du panier et leur quantité respective
        //dao.recup_articles_panier();

    }
}



