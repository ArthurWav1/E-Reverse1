package fr.cepi.test;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.Client;
import Ereverse.bean.Panier;
import Ereverse.bean.articles.Article;
import Ereverse.dao.ArticleDAO;
import Ereverse.dao.ClientDAO;
import Ereverse.dao.PanierDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/** Classe de test de la classe PanierDAO */

public class PanierTest {
    private static PanierDAO daoPanier;
    private static ClientDAO daoClient;

    /**
     * Initialisation du pool de connexion et création du DAO
     */
    @BeforeAll
    public static void init()  {
        try {
            ServiceConnexionBDD.setupDriver("src/main/webapp/WEB-INF/db.properties");
            daoPanier = new PanierDAO();
            daoClient=new ClientDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Test d'ajout article dans le panier d'un utilisateur
     */
    @Test
    public void test() {

        daoClient.login("mail","mdp");

        Article article = ArticleDAO.TrouverArticle("ref 1");
        int id_client = daoClient.Trouver_id_Client("mail");

        //ajout article
        //daoPanier.ajout_d_article(new Panier(id_client),article,2);

        //supp article
        //daoPanier.supression_d_article(article);

        //Changement nbarticle
        daoPanier.modification_nb_articles(new Panier(id_client),article,5);

        //Recupération liste des articles du panier et leur quantité respective
        //dao.recup_articles_panier();

    }
}



