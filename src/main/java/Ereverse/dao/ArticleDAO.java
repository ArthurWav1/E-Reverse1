package Ereverse.dao;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.articles.Article;
import Ereverse.bean.articles.Gourde;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleDAO {

    // Méthode pour trouver un article par son identifiant
    public static Article TrouverArticle(int ref_article) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Article article = null;

        try {
            // Obtenir la connexion à la base de données
            connection = ServiceConnexionBDD.getConnection();

            // Requête SQL pour sélectionner l'article par son identifiant
            String query = "SELECT * FROM article WHERE ref_article = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, ref_article);

            // Exécuter la requête
            resultSet = statement.executeQuery();

            // Vérifier s'il y a un résultat
            if (resultSet.next()) {
                // Créer un objet Article avec les données récupérées de la base de données
                article = new Article(
                        resultSet.getInt("ref_article"),
                        resultSet.getString("nom"),
                        resultSet.getDouble("prix")
                        // Ajoutez d'autres attributs de l'article ici si nécessaire
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return article;
    }

    public static ArrayList<Article> ListerGourde(int id_gamme){
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            ArrayList<Article> articles = new ArrayList<>();

            try {
                // Obtenir la connexion à la base de données
                connection = ServiceConnexionBDD.getConnection();

                // Requête SQL pour sélectionner tous les articles et les éléments
                String query ="SELECT article.*, couleur.nom, gamme.taille, gamme.gamme, gamme.volume " +
                              "FROM article " +
                              "JOIN gourde ON article.id = gourde.id_article " +
                              "WHERE gamme.id_gamme = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_gamme);
                // Exécuter la requête
                resultSet = statement.executeQuery();

                // Parcourir les résultats et créer des objets Article pour chaque ligne
                while (resultSet.next()) {
                    Article article = new Article(
                            resultSet.getInt("id"),
                            resultSet.getString("nom"),
                            resultSet.getDouble("prix")
                            // Ajoutez d'autres attributs de l'article ici si nécessaire
                    );
                    articles.add(article);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Fermer les ressources
                try {
                    if (resultSet != null) resultSet.close();
                    if (statement != null) statement.close();
                    if (connection != null) connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return articles;
        }


    }



