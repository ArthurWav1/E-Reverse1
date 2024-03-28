package Ereverse.dao;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.bean.Client;

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
    public void Enregistrement(Client client, String mdp){
        try {
            Connection connection = ServiceConnexionBDD.getConnection();
            PreparedStatement prep = connection.prepareStatement(
                    "INSERT INTO Utilisateur(nom,prenom,mail,adresse,login,salt,password) " +
                            "VALUES (?,?,?,?,?,?,?)");
            //Préparations des String simples
            int i = 1;
            prep.setString(i++,client.getNom());
            prep.setString(i++,client.getPrenom());
            prep.setString(i++,client.getMail());

            prep.setString(i++,client.getAdresse());
            prep.setString(i++,client.getPrenom());
            //Préparation pour le mot de passe
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            prep.setBytes(i++, salt);
            prep.setBytes(i++, hashPassword(salt, mdp));
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
            PreparedStatement prep = connection.prepareStatement("SELECT * FROM Utilisateur WHERE mail = ?");
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
}
