package classe;

public class Client {
    private int id;
    private String prenom;
    private String nom;
    private String mail;
    private String adresse;

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
    }

    /**
     * Constructeur pour la connexion de l'utilisateur
     * @param id : id unique de l'utilisateur
     * @param prenom
     * @param nom
     * @param mail
     * @param adresse
     */
    public Client(int id, String prenom, String nom, String mail, String adresse) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.adresse = adresse;
    }

    //Méthodes d'accès
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
}