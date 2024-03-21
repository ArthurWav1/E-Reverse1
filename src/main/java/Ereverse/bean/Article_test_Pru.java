package Ereverse.bean;

import java.io.Serializable;

/**
 * Classe représentant un article du site web
 */

public class Article_test_Pru implements Serializable {

//CREATE TABLE Article
//(
//    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
//    id_Kit_appartenance INT,
//    nom_Article VARCHAR(20) NOT NULL,
//    prix NUMERIC(7,2) NOT NULL,
//    Type_Article VARCHAR(20) NOT NULL,
//    ref_Article INT NOT NULL UNIQUE
//);

    private int id;
    private int id_Kit_appartenance;
    private String nom_Article;
    private double prix;
    private String Type_Article;
    private int ref_Article;










    @Override
    public String toString() {
        return super.toString();
    }
}
