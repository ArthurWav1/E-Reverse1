package Ereverse.dao;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.Client;
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

/**
    Data access object pour la table des clients (Classe pour accéder à la table Utilisateur de la BDD)
 */
public class ClientDAO {

    /**
     * Méthode permettant d'enregistrer un utilisateur dans la base de donnée.
     * @param client : l'objet client de l'utilisateur à enregistrer.
     * @param mdp : le mot de passe qu'a entré le client pour s'enregistrer.
     */
    public void enregistrement(Client client, String mdp){
        try {
            Connection connection = ServiceConnexionBDD.getConnection();
            PreparedStatement prep = connection.prepareStatement(
                    "INSERT INTO Utilisateur(nom,prenom,mail,adresse,salt,password,id_panier) " +
                            "VALUES (?,?,?,?,?,?,?)");
            //Préparations des Strings simples
            int i = 1;
            prep.setString(i++,client.getNom());
            prep.setString(i++,client.getPrenom());
            prep.setString(i++,client.getMail());
            prep.setString(i++,client.getAdresse());

            //Préparation pour le mot de passe
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            prep.setBytes(i++, salt);
            prep.setBytes(i++, hashPassword(salt, mdp));
            prep.setInt(i++,client.get_id_Panier());
            prep.execute();
            System.out.println("Client " + client.getNom() + " ajouté à la bdd");

        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Méthode qui s'exécute lorsqu'un utilisateur souhaite se connecter.
     * @param mail : login entré par l'utilisateur.
     * @param mdp : mdp entré par l'utilisateur.
     * @return l'objet correspondant au client en cas de succès de la connexion ou null dans le cas contraire.
     */
    public Client login(String mail,String mdp){
        try {
            Connection connection = ServiceConnexionBDD.getConnection();
            //Préparation de la commande.
            PreparedStatement prep = connection.prepareStatement(
                    "SELECT * FROM Utilisateur " +
                            "WHERE mail = ?");
            prep.setString(1,mail);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                byte[] salt = rs.getBytes("salt");
                byte[] hash = hashPassword(salt,mdp);
                //Test si le mdp de la BDD et créé à partir de l'utilisateur extrait sont les mêmes.
                if (Arrays.compare(hash,rs.getBytes("password")) == 0){
                    return new Client(rs.getInt("id"),rs.getString("prenom"),rs.getString("nom"),rs.getString("mail"),rs.getString("adresse"));
                }

            }
            //Renvoie null en cas d'échec.
             return null;
        }
        catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public void modification(Client client, String nouveauNom, String nouveauPrenom, String nouvelleAdresse, String nouveauMDP){
        try {
            Connection connection = ServiceConnexionBDD.getConnection();
            PreparedStatement prep = connection.prepareStatement(
                    "UPDATE utilisateur " +
                            "SET nom = ? , prenom = ? , adresse = ? , salt = ? , password = ? " +
                            "WHERE mail = ? ");
            int i = 1;
            //Changement des Strings normaux de l'utilisateur (on ne peut pas modifier le mail)
            prep.setString(i++,nouveauNom);
            prep.setString(i++,nouveauPrenom);
            prep.setString(i++,nouvelleAdresse);

            //Changement du mot de passe et du salt de la bdd à partir du nouveau mdp de l'utilisateur
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            prep.setBytes(i++, salt);
            prep.setBytes(i++, hashPassword(salt, nouveauMDP));
            prep.execute();
            System.out.println("Les données du client ont bien été modifiées.");

        } catch (SQLException e) {
            throw new RuntimeException("Erreur de connection à la base de donnée");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

    }

    public void suppressionClient(Client client){
        Connection connection = null;
        try {
            connection = ServiceConnexionBDD.getConnection();
            PreparedStatement prep = connection.prepareStatement(
                "DELETE FROM utilisateur WHERE mail = ? "
            );
            prep.setString(1,client.getMail());
            prep.execute();
            System.out.println("Utilisateur" + client.getNom() + " supprimé");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Renvoie le hash d'un mot de passe avec du sel
     *
     * @param salt sel
     * @param password mot de passe
     * @return le hash du mot de passe
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    private byte[] hashPassword(byte[] salt, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Augmenter iteration count pour plus de sécurité
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1024, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return factory.generateSecret(spec).getEncoded();
    }

    public static int Trouver_id_Client(String mail_client) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Client client = null;

        try {
            // Obtenir la connexion à la base de données
            connection = ServiceConnexionBDD.getConnection();

            // Requête SQL pour sélectionner le client par son identifiant
            String query = "SELECT * FROM utilisateur WHERE mail = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, mail_client);

            // Exécuter la requête
            resultSet = statement.executeQuery();

            // Vérifier s'il y a un résultat
            if (resultSet.next()) {
                // Créer un objet client avec les données récupérées de la base de données
                client = new Client(
                        resultSet.getInt("id"),
                        resultSet.getString("prenom"),
                        resultSet.getString("nom"),
                        resultSet.getString("mail"),
                        resultSet.getString("adresse")
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

        System.out.println("l'identifiant du client est " + client.getId() + ", son adresse mail est " + client.getMail());
        return client.getId();

    }
}
