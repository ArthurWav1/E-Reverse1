package Ereverse.bean.articles;

/**
 *Une pastille est un article complement permettant de donner du goût à l'eau (the, cafe, etc);
 *  elle est vendue en option
 * @author prune
 */
public class Pastille extends Article {

    private String saveur;

    public Pastille(int reference, String saveur, String nom_pastille,int prix,String caracteristique) {
        super(reference, nom_pastille, prix,caracteristique);
        this.saveur=saveur;
    }

    public Pastille(int id_pastille,int reference,String type_Article, String nom_pastille, int prix,String caracteristique) {
        super(id_pastille, reference, nom_pastille, type_Article,prix,caracteristique);
    }

}
