package Ereverse.bean.articles;

/**
 * Une gourde est un type d'article vendu sur le site E-Reverse
 * @author prune
 */
public class Gourde extends Article {

    private String couleur;
    private String taille;
    private String gamme;

    public Gourde(int id, String reference, String nom_gourde, int prix, String description,String gamme, String taille, String couleur) {
        super(id,reference, nom_gourde, prix, description);
        this.couleur=couleur;
        this.gamme=gamme;
        this.taille=taille;

    }

    public Gourde(int id_gourde,String reference,int id_type, String nom_gourde,String gamme,
                  String taille, String couleur, int prix) {
        super(id_gourde, reference, nom_gourde, id_type,prix);
    }

    public Gourde(String taille, String couleur, String gamme,int prix){
        this.taille = taille;
        this.couleur = couleur;
        this.gamme = gamme;
        this.prix = prix;
    }

}
