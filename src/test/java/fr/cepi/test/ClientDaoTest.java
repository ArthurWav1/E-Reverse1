package fr.cepi.test;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.Client;
import Ereverse.dao.ClientDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/** Classe de test de la classe UserDao */
public class ClientDaoTest {

    private static ClientDAO dao;

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
     * Test de création, login et suppression d'un utilisateur
     */
    @Test
    public void test() {
        ClientDAO.enregistrement(new Client("p","n","mail","a"),"mdp");

        //le bon client + le bon mot de passe
        Assertions.assertNotNull(ClientDAO.login("mail", "mdp"));
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
        ClientDAO.Trouver_id_Client("mail");
    }

    @Test
    public void testClientComplet(){
        ClientDAO.suppressionClient(new Client("prenom","nom","mail1","adresse"));


        System.out.println("Création du client -- enregistrement");
        ClientDAO.enregistrement(new Client("prenom","nom","mail1","adresse"),"motdepasse");
        System.out.println();

        System.out.println("Récupération du client -- login");
        Client c = ClientDAO.login("mail1","motdepasse");
        System.out.println(c);
        System.out.println();

        System.out.println("Modification -- AvecMDP");
        ClientDAO.modificationAvecMDP(c,null,"prenom1000",null,"password");
        boolean b = ClientDAO.compareMDP(c.getMail(),"motdepasse");
        System.out.println("Comparaison motdepasse: " + b);

        b = ClientDAO.compareMDP(c.getMail(),"password");
        System.out.println("Comparaison password : " + b);

        c = ClientDAO.login("mail1","password");
        System.out.println(c);

        System.out.println();
        System.out.println("Modification -- SansMDP");
        ClientDAO.modificationSansMDP(c,"nom4000","prenom2","Ales");
        c = ClientDAO.login("mail1","password");
        System.out.println(c);
        System.out.println();

        System.out.println("Suppression du client");
        ClientDAO.suppressionClient(c);
        System.out.println();

    }
}
