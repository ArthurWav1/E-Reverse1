package Ereverse.bean.articles;

/**
 *Un accessoire est un article permettant de personnaliser sa gourde ou son module
 * @author prune
 */

public class Accessoire extends Article {

    public Accessoire(int reference, String nom_accessoire,double prix) {
        super(reference, nom_accessoire, prix);
    }

    public Accessoire(int id_accessoire, int reference, String nom_Article,String type_Article,double prix) {
        super(id_accessoire, reference, nom_Article, type_Article, prix);
    }




}

