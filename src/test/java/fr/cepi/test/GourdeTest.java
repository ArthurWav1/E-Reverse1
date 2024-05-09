package fr.cepi.test;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.Client;
import Ereverse.bean.articles.Gourde;
import Ereverse.dao.ArticleDAO;
import Ereverse.dao.ClientDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * Classe de test de la classe UserDao
 */
public class GourdeTest {

    private static ArticleDAO dao;

    /**
     * Initialisation du pool de connexion et création du DAO
     */
    @BeforeAll
    public static void init() {
        try {
            ServiceConnexionBDD.setupDriver("src/main/webapp/WEB-INF/db.properties");
            dao = new ArticleDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Test de création, login et suppression d'un utilisateur
     */
    @Test
    public void test() {
        ArrayList<Gourde> l = dao.ListerGourde(1);

        //le bon client + le bon mot de passe
        Assertions.assertEquals(4, l.size());
    }
}