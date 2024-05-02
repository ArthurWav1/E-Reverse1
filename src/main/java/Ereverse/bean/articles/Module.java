package Ereverse.bean.articles;

/**
 *Un module est un type d'article vendu avec une gourde et permettant de chauffer, refroidrir une boisson
 * ou de faire les deux
 * @author prune
 */
public class Module extends Article {

    private String type_module;

    public Module(String reference, String type_module, String nom_module,int prix) {
        super(reference, nom_module, prix);
        this.type_module=type_module;
    }

    public Module(int id_module,String reference,int id_type, String nom_module, int prix) {
        super(id_module, reference, nom_module, id_type,prix);
    }

}
