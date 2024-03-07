package classe;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private List<Produit> produits;

    public Panier() {
        this.produits = new ArrayList<>();
    }

    // Méthode pour ajouter un produit au panier
    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    // Méthode pour supprimer un produit du panier
    public void supprimerProduit(Produit produit) {
        produits.remove(produit);
    }

    // Méthode pour récupérer tous les produits du panier
    public List<Produit> getProduits() {
        return produits;
    }

    public double TotalPanier(){
        double somme = 0;
        for(Produit produit : produits){
            somme += produit.getPrix();
        }
        return somme;
    }

}
