package classe;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private List<Article> produits;
    private int id;
    public Panier() {
        this.produits = new ArrayList<>();
    }

    // Méthode pour ajouter un produit au panier
    public void ajouterProduit(Article article) {
        produits.add(article);
    }

    // Méthode pour supprimer un produit du panier
    public void supprimerProduit(Article article) {
        produits.remove(article);
    }

    // Méthode pour récupérer tous les produits du panier
    public List<Article> getProduits() {
        return produits;
    }

    public double TotalPanier(){
        double somme = 0;
        for(Article article : produits){
            somme += article.getPrix();
        }
        return somme;
    }

}
