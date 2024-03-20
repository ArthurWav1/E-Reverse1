package classe;

public class Client {
    private int id;
    private String prenom;
    private String nom;
    private String mail;
    private String adresse;

    public Client(String prenom,String nom,String mail,String adresse){
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