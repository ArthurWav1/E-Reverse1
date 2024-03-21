package Ereverse.bean.articles;

/**
 *Une pastille est un article complement permettant de donner du goût à l'eau (the, cafe, etc); elle est vendue en option
 * @author prune
 */
public class Pastille extends Article {

    public Pastille() {
        super(null, null, 0);
    }

    private String saveur;
    private String nom_Article;

    public Pastille(String type_Article, String saveur, String nom_pastille,int prix) {
        super(nom_pastille, type_Article, prix);
        this.saveur=saveur;
        nom_Article=type_Article;
    }

    public Pastille(int id_pastille,int reference,String type_Article, String nom_pastille, int prix) {
        super(id_pastille, reference, nom_pastille, type_Article,prix);
    }

}
