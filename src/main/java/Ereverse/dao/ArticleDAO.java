package Ereverse.dao;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.Client;
import Ereverse.bean.articles.Article;
import Ereverse.bean.articles.Gourde;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArticleDAO {

    /**
     * Méthode pour obtenir un article à partir de sa référence
     * @param ref_article : référence de l'article
     * @return Article dont la référence est ref_article (null s'il n'existe pas)
     */
    public static Article TrouverArticle(int ref_article) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Article article = null;

        try {
            // Obtenir la connexion à la base de données
            connection = ServiceConnexionBDD.getConnection();

            // Requête SQL pour sélectionner l'article par son identifiant
            String query = "SELECT * FROM article WHERE reference = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, ref_article);

            // Exécuter la requête
            resultSet = statement.executeQuery();

            // Vérifier s'il y a un résultat
            if (resultSet.next()) {
                // Créer un objet Article avec les données récupérées de la base de données
                article = new Article(
                        resultSet.getString("reference"),
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

    /**
     * Méthode permettant de renvoyer la liste des gourdes d'une certaine gamme
     * @param id_gamme : id de la gamme voulue
     * @return liste des gourdes de la gamme voulue (null si la liste est vide)
     */
    public static ArrayList<Gourde> ListerGourde(int id_gamme){
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            ArrayList<Gourde> ListeGourde = new ArrayList<>();

            try {
                // Obtenir la connexion à la base de données
                connection = ServiceConnexionBDD.getConnection();

                // Requête SQL pour sélectionner tous les articles et les éléments
                String query ="SELECT article.*, gamme.*,couleur.libelle AS libelle_couleur" +
                              "FROM article" +
                              "JOIN gamme ON article.id_gamme = gamme.id " +
                              "JOIN couleur ON article.id_couleur = couleur.id"+
                              "WHERE gamme.id = ?";
                statement = connection.prepareStatement(query);
                statement.setInt(1, id_gamme);
                // Exécuter la requête
                resultSet = statement.executeQuery();

                // Parcourir les résultats et créer des objets Article pour chaque ligne
                while (resultSet.next()) {
                    Gourde gourde = new Gourde(
                            resultSet.getString("reference"),
                            resultSet.getString("gamme"),
                            resultSet.getInt("prix"),
                            resultSet.getString("description"),
                            resultSet.getString("libelle_couleur"),
                            resultSet.getInt("volume")
                            // Ajoutez d'autres attributs de l'article ici si nécessaire
                    );
                    ListeGourde.add(gourde);
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

            return ListeGourde;
        }


    /**
     * Méthode permettant de renvoyer tous les articles d'un certain type
     * (gourde/module/pastille/accessoire)
     * @param libelle_type : nom du type
     * @return la liste des articles du type demandé (null si la liste est vide)
     */
    public static ArrayList<Article> ListerArticleType(String libelle_type){
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            ArrayList<Article> articles = new ArrayList<>();

            try {
                connection = ServiceConnexionBDD.getConnection();

                String query ="SELECT article.* "+
                        "FROM article " +
                        "JOIN type ON article.id_type = type.id " +
                        "WHERE type.libelle = ? ";

                statement = connection.prepareStatement(query);
                statement.setString(1,libelle_type);
                resultSet = statement.executeQuery();

                while (resultSet.next()){
                    Article article = new Article(
                            resultSet.getInt("id"),
                            resultSet.getString("reference"),
                            resultSet.getString("nom"),
                            resultSet.getInt("id_type"),
                            resultSet.getDouble("prix")
                    );
                    articles.add(article);
                }
            return articles;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    /**
     * Méthode permettant de connaître si un article existe déjà en donnant sa gamme, sa couleur, son type et sa saveur
     * @param gamme : potentielle gamme de l'article que l'on veut rajouter
     * @param couleur : potentielle couleur de l'article que l'on veut rajouter
     * @param type : type de l'article que l'on veut rajouter
     * @param saveur : potentielle saveur de l'article que l'on veut rajouter
     * @return true lorsque l'article existe déjà, false lorsque aucun article de ce genre n'existe
     */
        public static boolean getArticlePrecis(String gamme, String couleur, String type, String saveur){
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;
            ArrayList<Article> articles = new ArrayList<>();

            try {
                connection = ServiceConnexionBDD.getConnection();
                if (gamme == null){ //Test si le produit possède une gamme (= une gourde)
                    if (saveur == null){ //Test si le produit possède une saveur (= une pastille) Cas pour module et accessoire
                        String query ="SELECT article.* "+
                                "FROM article, type, couleur " +
                                "WHERE type.libelle = ? AND couleur.libelle = ? ";

                        statement = connection.prepareStatement(query);
                        statement.setString(1,type);
                        statement.setString(2,couleur);
                        resultSet = statement.executeQuery();
                    }
                    else{ // Cas pour les pastilles
                        String query ="SELECT article.* "+
                            "FROM article, couleur " +
                            "WHERE couleur.libelle = ? AND article.saveur = ?";

                        statement = connection.prepareStatement(query);
                        statement.setString(1,couleur);
                        statement.setString(2,saveur);
                        resultSet = statement.executeQuery();
                    }
                }
                else{ //Cas pour les gourdes
                    String query ="SELECT article.* "+
                            "FROM article, type, couleur, gamme " +
                            "WHERE couleur.libelle = ? AND gamme.gamme = ?";

                    statement = connection.prepareStatement(query);
                    statement.setString(1,couleur);
                    statement.setString(2,gamme);
                    resultSet = statement.executeQuery();
                }

                return resultSet.next(); //Renvoie true si l'article existe déjà

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public static String AjoutArticle(String reference, String saveur, String description, double prix, byte[] image, int id_type, int id_gamme, int id_couleur, String nom){
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet resultSet = null;

            try {
                connection = ServiceConnexionBDD.getConnection();
                String query = "INSERT INTO article(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                statement = connection.prepareStatement(query);
                statement.setString(1,reference);
                statement.setString(2,saveur);
                statement.setString(3,description);
                statement.setDouble(4,prix);
                statement.setBytes(5, image);
                statement.setInt(6, id_type);
                statement.setInt(7,id_gamme);
                statement.setInt(8,id_couleur);
                statement.setString(9,nom);
                resultSet = statement.executeQuery();

                return ("Article " + reference +" rajouté");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }



