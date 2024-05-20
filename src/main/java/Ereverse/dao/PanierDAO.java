package Ereverse.dao;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.Client;
import Ereverse.bean.Panier;
import Ereverse.bean.articles.Article;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import java.util.ArrayList;

/**
 Data access object pour la table des paniers (Classe pour accéder à la table panier de la BDD)
 */

public class PanierDAO {

    /**
     * Méthode permettant d'ajouter un article dans la table du panier (BDD).
     * @param panier :  panier de l'utilisateur.
     * @param article : l'article à ajouter.
     */

    public void ajout_d_article (Panier panier, Article article, int nb_article) {
        try {
            Connection connection = ServiceConnexionBDD.getConnection();
            PreparedStatement prep = connection.prepareStatement(
                    "INSERT INTO panier(id_utilisateur, id_article, nbarticle) " +
                            "VALUES (?,?,?)");

            //Préparations des Strings simples
            prep.setInt(1,panier.get_id_utilisateur());
            prep.setInt(2,article.get_id());
            prep.setInt(3,nb_article);

            panier.set_nb_articles(nb_article);

            prep.execute();
            System.out.println(article.getNom_Article() + " numero " + article.get_ref() + " ajouté à la table du panier");

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * Méthode permettant de supprimer un article dans la table du panier (BDD).
     * @param article :  panier de l'utilisateur.
     */
    public void supression_d_article (Article article) {

        Connection connection = null;
        try {
            connection = ServiceConnexionBDD.getConnection();
            PreparedStatement prep = connection.prepareStatement(
                    "DELETE FROM panier WHERE id_article = ? "
            );
            prep.setInt (1,article.get_id());
            prep.execute();
            System.out.println("article " + article.getNom_Article() + " numero "+article.get_ref() + " supprimé du panier ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Méthode permettant de modifier les quantités d'un article dans la table du panier (BDD).
     * @param nouveau_nb : l'article à ajouter.
     */
    //Changement nbarticle
    public void modification_nb_articles(Panier panier,Article article, int nouveau_nb){
        try {
            Connection connection = ServiceConnexionBDD.getConnection();
            PreparedStatement prep = connection.prepareStatement(
                    "UPDATE panier " +
                            "SET nbarticle = ? " +
                            "WHERE id_article = ? ");
            prep.setInt(1,nouveau_nb);
            prep.setInt(2,article.get_id());

            panier.set_nb_articles(nouveau_nb);

            prep.execute();
            System.out.println( "nouveau nombre article " + article.get_ref() + " est " + panier.get_nb_article());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Méthode permettant de récupérer la liste des articles du panier et leur quantités respectives (BDD).
     */
    //Recupération liste des articles du panier et leur quantité respective
    public static ArrayList recup_articles_panier(){

        ArrayList <Article> liste_articles = new ArrayList <>();

        try {
            Connection connection = ServiceConnexionBDD.getConnection();
            PreparedStatement prep = connection.prepareStatement(
                    "SELECT id_utilisateur, nbarticle FROM panier " +
                            "WHERE id_utilisateur = ? ");
            ResultSet rst = prep.executeQuery() ;
            System.out.println( "liste articles du panier = " + rst);

            return liste_articles ;
        } catch (SQLException e) {
            throw new RuntimeException("Erreur de connection à la base de donnée");
        }
    }


}
