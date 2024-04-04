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
            prep.setString(i++, article.getType_Article());
            prep.setString(i++, article.getNom_Article());
            prep.setDouble(i++,article.getPrix());
            prep.setString(i++, article.getCaracteristique());

            //Préparation pour le mot de passe

            prep.execute();

            System.out.println("Article " + article.getNom_Article() + " ajouté à la bdd");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}