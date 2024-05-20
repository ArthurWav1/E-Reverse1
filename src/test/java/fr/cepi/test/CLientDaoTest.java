package fr.cepi.test;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.Client;
import Ereverse.dao.ClientDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/** Classe de test de la classe UserDao */
public class CLientDaoTest {

    private static ClientDAO dao;

    /**
     * Initialisation du pool de connexion et création du DAO
     */
    @BeforeAll
    public static void init()  {
        try {
            ServiceConnexionBDD.setupDriver("src/main/webapp/WEB-INF/db.properties");
            dao = new ClientDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Test de création, login et suppression d'un utilisateur
     */
    @Test
    public void test() {
        dao.enregistrement(new Client("p","n","mail","a",1),"mdp");

        //le bon client + le bon mot de passe
        Assertions.assertNotNull(dao.login("mail", "mdp"));
        //le bon client + mauvais mdp
        //Assertions.assertNull(dao.login("mail", "abc"));
        //le mauvais client + bon mdp
        //Assertions.assertNull(dao.login("b", "mdp"));
        //le mauvais client + mauvais mdp
        //Assertions.assertNull(dao.login("b", "hhg"));
        //Si on supprime l'utilisateur
        //dao.delete("b");
        //Assertions.assertNull(dao.login("b", "abc"));
        //dao.TrouverClient("mail");
        dao.Trouver_id_Client("mail");
    }

}
