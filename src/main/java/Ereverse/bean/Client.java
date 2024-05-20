package Ereverse.bean;

import java.io.Serializable;

public class Client implements Serializable {
    private int id;
    private String prenom;
    private String nom;
    private String mail;
    private String adresse;
    private int id_panier;
    private boolean access;
    /**
     * Constructeur pour l'enregistrement de l'utilisateur
     * @param prenom
     * @param nom
     * @param mail
     * @param adresse
     */
    public Client(String prenom,String nom,String mail,String adresse){
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.adresse = adresse;
        this.access = false;
    }

    public Client(String prenom,String nom,String mail,String adresse,int id_panier){
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.adresse = adresse;
        this.id_panier = id_panier;
        this.access = false;
    }

    /**
     * Constructeur pour la connexion de l'utilisateur
     * @param id : id unique de l'utilisateur
     * @param prenom : prenom
     * @param nom : nom
     * @param mail : mail
     * @param adresse : adresse
     */
    public Client(int id, String prenom, String nom, String mail, String adresse) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.adresse = adresse;
        //Test si son adresse mail correspond à celle d'un vendeur pour lui donner des accès particuliers
        if (mail.equals("vendeur@reverse.com")){
            this.access = true;
        }
        else{
            this.access = false;
        }
    }


    //Méthodes d'accès
    public int getId(){
        return this.id;
    }
    public String getNom(){
        return this.nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getMail() {
        return mail;
    }
    public String getAdresse() {
        return adresse;
    }
    public boolean getAccess(){
        return access;
    }
    public int get_id_Panier(){
        return this.id_panier;
    }

    @Override
    public String toString() {
        return "Nom du client: " + this.getNom() + ", id du client: " + this.getId();
    }
}