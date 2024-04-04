package Ereverse.dao;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.Client;
import Ereverse.bean.articles.Article;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDAO {
    public void EntreArticle(Article article){
        try {
            Connection connection = ServiceConnexionBDD.getConnection();
            PreparedStatement prep = connection.prepareStatement(
                    "INSERT INTO Article(ref_Article,nom_Article,prix,caracteristique) " +
                            "VALUES (?,?,?,?)");
            //Préparations des String simples
            int i = 1;
            prep.setString(i++, article.get_Nom());
            prep.setString(i++, article.get_Nom());
            prep.setDouble(i++,article.get_Prix());
            prep.setString(i++, article.get_caracteristique());

            //Préparation pour le mot de passe

            prep.execute();

            System.out.println("Article " + article.get_Nom() + " ajouté à la bdd");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}