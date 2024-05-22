package Ereverse.bean.articles;

/**
 * Gamme de gourde ayant un volume et un prix défini
 * @author prune
 */
public class Gamme{

    private int id_gamme;
    private String gamme;
    private double prix;
    private int volume;

    public Gamme(int id_gamme, String gamme, double prix, int volume) {
        this.id_gamme = id_gamme;
        this.gamme = gamme;
        this.prix = prix;
        this.volume = volume;
    }

    public int getId_gamme() {
        return id_gamme;
    }

    public String getGamme() {
        return gamme;
    }

    public double getPrix() {
        return prix;
    }

    public int getVolume() {
        return volume;
    }
}
