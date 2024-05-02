package Ereverse.bean.articles;

/**
 * Une gourde est un type d'article vendu sur le site E-Reverse
 * @author prune
 */
public class Gourde extends Article {

    private String couleur;
    private int volume;
    private String gamme;

    public Gourde(String reference, String nom_gourde, int prix, String description, String couleur, int volume) {
        super(reference, nom_gourde, prix, description);
        this.couleur=couleur;
        this.volume=volume;

    }

    public Gourde(int id_gourde,String reference,int id_type, String nom_gourde,String gamme,
                  String taille, String couleur, int prix) {
        super(id_gourde, reference, nom_gourde, id_type,prix);
    }

    public Gourde(String taille, String couleur, String gamme,int prix){
        this.volume = volume;
        this.couleur = couleur;
        this.gamme = gamme;
        this.prix = prix;
    }
    // Getter et Setter pour la taille
    public int getTaille() {
        return volume;
    }

    public void setTaille(int volume) {
        this.volume = volume;
    }

    // Getter et Setter pour la gamme
    public String getGamme() {
        return gamme;
    }

    public void setGamme(String gamme) {
        this.gamme = gamme;
    }

    // Getter et Setter pour la couleur
    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}

