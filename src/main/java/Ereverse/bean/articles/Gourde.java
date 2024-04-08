package Ereverse.bean.articles;

/**
 * Une gourde est un type d'article vendu sur le site E-Reverse
 * @author prune
 */
public class Gourde extends Article {

    private String couleur;
    private String taille;
    private String gamme;

    public Gourde(int reference, String nom_gourde,String gamme, String taille, String couleur, int prix) {
        super(reference, nom_gourde, prix);
        this.couleur=couleur;
        this.gamme=gamme;
        this.taille=taille;

    }

    public Gourde(int id_gourde,int reference,int id_type, String nom_gourde,String gamme,
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
