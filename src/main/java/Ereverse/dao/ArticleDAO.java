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
    public static Article TrouverArticle(String ref_article) {
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
            statement.setString(1, ref_article);

            // Exécuter la requête
            resultSet = statement.executeQuery();
            // Vérifier s'il y a un résultat
            if (resultSet.next()) {
                // Créer un objet Article avec les données récupérées de la base de données
                article = new Article(
                        resultSet.getInt("id"),
                        resultSet.getString("reference"),
                        resultSet.getString("nom"),
                        resultSet.getDouble("prix"),
                        resultSet.getString("description")
                        // Ajoutez d'autres attributs de l'article ici si nécessaire
                );
            }
            else{
                System.out.println("Article introuvable");
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
        System.out.println("l'identifiant de l'article est " + article.get_id() + " et sa reference est " + article.get_ref());
        return article;
    }

    /**
     * Méthode permettant de renvoyer la liste des gourdes d'une certaine gamme
     * @param id_gamme : id de la gamme voulue
     * @return liste des gourdes de la gamme voulue (null si la liste est vide)
     */
    public static ArrayList<Gourde> ListerGourde(int id_gamme) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Gourde> ListeGourde = new ArrayList<>();

        try {
            // Obtenir la connexion à la base de données
            connection = ServiceConnexionBDD.getConnection();

            // Requête SQL pour sélectionner tous les articles et les éléments
            String query = "SELECT article.*, gamme.*,couleur.libelle AS libelle_couleur " +
                    "FROM article " +
                    "JOIN gamme ON article.id_gamme = gamme.id " +
                    "JOIN couleur ON article.id_couleur = couleur.id " +
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
    public static ArrayList<Article> ListerArticleType(String libelle_type) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Article> articles = new ArrayList<>();

        try {
            connection = ServiceConnexionBDD.getConnection();

            String query = "SELECT article.* " +
                    "FROM article " +
                    "JOIN type ON article.id_type = type.id " +
                    "WHERE type.libelle = ? ";

            statement = connection.prepareStatement(query);
            statement.setString(1, libelle_type);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
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
     *
     * @param gamme   : potentielle gamme de l'article que l'on veut rajouter
     * @param couleur : potentielle couleur de l'article que l'on veut rajouter
     * @param type    : type de l'article que l'on veut rajouter
     * @param saveur  : potentielle saveur de l'article que l'on veut rajouter
     * @return true lorsque l'article existe déjà, false lorsque aucun article de ce genre n'existe
     */
    public static boolean getArticlePrecis(String gamme, String couleur, String type, String saveur) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Article> articles = new ArrayList<>();

        try {
            connection = ServiceConnexionBDD.getConnection();
            if (gamme == null) { //Test si le produit possède une gamme (= une gourde)
                if (saveur == null) { //Test si le produit possède une saveur (= une pastille) Cas pour module et accessoire
                    String query = "SELECT article.* " +
                            "FROM article, type, couleur " +
                            "WHERE type.libelle = ? AND couleur.libelle = ? ";

                    statement = connection.prepareStatement(query);
                    statement.setString(1, type);
                    statement.setString(2, couleur);
                    resultSet = statement.executeQuery();
                } else { // Cas pour les pastilles
                    String query = "SELECT article.* " +
                            "FROM article, couleur " +
                            "WHERE couleur.libelle = ? AND article.saveur = ?";

                    statement = connection.prepareStatement(query);
                    statement.setString(1, couleur);
                    statement.setString(2, saveur);
                    resultSet = statement.executeQuery();
                }
            } else { //Cas pour les gourdes
                String query = "SELECT article.* " +
                        "FROM article, type, couleur, gamme " +
                        "WHERE couleur.libelle = ? AND gamme.gamme = ?";

                statement = connection.prepareStatement(query);
                statement.setString(1, couleur);
                statement.setString(2, gamme);
                resultSet = statement.executeQuery();
            }

            return resultSet.next(); //Renvoie true si l'article existe déjà

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String AjoutArticle(String reference, String saveur, String description, double prix, String image, int id_type, int id_gamme, int id_couleur, String nom){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ServiceConnexionBDD.getConnection();
            int i =1;
            String query;
            switch (id_type){
                case 1:
                    query = "INSERT INTO article(reference, description, prix, image, id_type, id_gamme, id_couleur, nom)" +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
                    statement = connection.prepareStatement(query);
                    statement.setString(i++,reference);
                    statement.setString(i++,description);
                    statement.setDouble(i++,prix);
                    statement.setString(i++, image);
                    statement.setInt(i++, id_type);
                    statement.setInt(i++,id_gamme);
                    statement.setInt(i++,id_couleur);
                    statement.setString(i++,nom);
                    break;
                case 2:
                    query = "INSERT INTO article(reference, saveur, description, prix, image, id_type, nom)" +
                            "VALUES(?, ?, ?, ?, ?, ?, ?)";
                    statement = connection.prepareStatement(query);
                    statement.setString(i++,reference);
                    statement.setString(i++,saveur);
                    statement.setString(i++,description);
                    statement.setDouble(i++,prix);
                    statement.setString(i++, image);
                    statement.setInt(i++, id_type);
                    statement.setString(i++,nom);
                    break;
                case 3:
                case 4:
                    query = "INSERT INTO article(reference, description, prix, image, id_type, nom)" +
                            "VALUES(?, ?, ?, ?, ?, ?)";
                    statement = connection.prepareStatement(query);
                    statement.setString(i++,reference);
                    statement.setString(i++,description);
                    statement.setDouble(i++,prix);
                    statement.setString(i++, image);
                    statement.setInt(i++, id_type);
                    statement.setString(i++,nom);
            }
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ("Article '" + nom + "' de référence: " + reference + " rajouté");
    }

    public static ArrayList<String> ListerType() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> listeType = new ArrayList<>();

        try {
            connection = ServiceConnexionBDD.getConnection();
            String query = "SELECT libelle FROM type"; // Sélectionnez seulement la colonne libelle

            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            // Parcourir les résultats et ajouter les libellés des types à la liste
            while (resultSet.next()) {
                String libelleType = resultSet.getString("libelle");
                listeType.add(libelleType);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Fermer les ressources (ResultSet, PreparedStatement et Connection)
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listeType;
    }

    public static ArrayList<Gourde> ListerGourde2() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Gourde> ListeGourdes = new ArrayList<>();

        try {
            // Obtenir la connexion à la base de données
            connection = ServiceConnexionBDD.getConnection();
            String query = "SELECT a.reference, a.nom, a.prix, a.description, g.gamme, g.id " +
                    "FROM article a " +
                    "JOIN gamme g ON a.id_gamme = g.id" +
                    " GROUP BY g.id, a.reference, a.nom, a.prix, a.description, g.gamme";

            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String reference = resultSet.getString("reference");
                String nomGourde = resultSet.getString("nom");
                double prix = resultSet.getDouble("prix");
                String description = resultSet.getString("description");
                String gamme = resultSet.getString("gamme");
                int id_gamme = resultSet.getInt("id");

                Boolean gammeAlreadyExists = ListeGourdes.stream().anyMatch(g -> { return g.getGamme().equals(gamme); });

                if(!gammeAlreadyExists){
                    Gourde gourde = new Gourde(reference, nomGourde, prix, description, gamme, id_gamme);
                    ListeGourdes.add(gourde);
                }
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
        return ListeGourdes;
    }


    public static void supression_article(Article article){
        try {
            Connection connection = ServiceConnexionBDD.getConnection();
            PreparedStatement prep = connection.prepareStatement(
                    "DELETE FROM article WHERE reference = ?");
            prep.setString(1,article.get_ref());
            prep.execute();
            System.out.println("Article" + article.get_ref() + " supprimé");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Article TrouverArticle(int id_article) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Article article = null;

        try {
            // Obtenir la connexion à la base de données
            connection = ServiceConnexionBDD.getConnection();

            // Requête SQL pour sélectionner l'article par son identifiant
            String query = "SELECT * FROM article WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, id_article);

            // Exécuter la requête
            resultSet = statement.executeQuery();

            // Vérifier s'il y a un résultat
            if (resultSet.next()) {
                // Créer un objet Article avec les données récupérées de la base de données
                article = new Article(
                        resultSet.getInt("id"),
                        resultSet.getString("reference"),
                        resultSet.getString("nom"),
                        resultSet.getDouble("prix"),
                        resultSet.getString("description")
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

        //System.out.println("l'identifiant de l'article est " + article.get_id() + " et sa reference est " + article.get_ref());
        return article;

    }

}



