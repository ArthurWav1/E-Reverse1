package Ereverse.bean.articles;

/**
 *Un accessoire est un article permettant de personnaliser sa gourde ou son module
 * @author prune
 */

public class Accessoire extends Article {

    public Accessoire(String reference, String nom_accessoire,double prix) {
        super(reference, nom_accessoire, prix);
    }

    public Accessoire(int id_accessoire, String reference, String nom_Article,int id_type,double prix) {
        super(id_accessoire, reference, nom_Article, id_type, prix);
    }




}

