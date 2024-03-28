package Ereverse.bean.articles;

/**
 * Une gourde est un type d'article vendu sur le site E-Reverse
 * @author prune
 */
public class Gourde extends Article {

    private String couleur;
    private String taille;
    private String gamme;

    public Gourde(String type_Article,String nom_gourde,String gamme, String taille, String couleur, int prix) {
        super(nom_gourde, type_Article, prix);
        this.couleur=couleur;
        this.gamme=gamme;
        this.taille=taille;

    }

    public Gourde(int id_gourde,int reference,String type_Article, String nom_gourde,String gamme,
                  String taille, String couleur, int prix) {
        super(id_gourde, reference, nom_gourde, type_Article,prix);
    }

}
