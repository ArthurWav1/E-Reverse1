-- Création de la table des utilisateurs

CREATE TABLE utilisateur
(
    id       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom      VARCHAR(20) NOT NULL,
    prenom   VARCHAR(20) NOT NULL,
    mail     VARCHAR(100) NOT NULL UNIQUE,
    adresse  VARCHAR(1000) NOT NULL,
    login    VARCHAR(20) NOT NULL UNIQUE, --Ne sert absolument à rien, n'est jamais utilisé dans le code ou dans les recherches dans la table
    salt     BYTEA NOT NULL,
    password BYTEA NOT NULL
);

--Création de la table panier qui représente le panier actuel d'un utilisateur avant commande
CREATE TABLE panier
(
    id_Utilisateur INT NOT NULL,
    id_Article INT NOT NULL,
    nbArticle INT NOT NULL
);

--Création de la table commande qui représente la liste des commandes faites par les utilisateurs
CREATE TABLE Commande
(
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_Utilisateur INT NOT NULL,
    prix NUMERIC(7,2) NOT NULL
);

--Création de la table image qui regroupe toutes les images des produits à afficher
CREATE TABLE Image
(
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    refArticle INT NOT NULL,
    lien VARCHAR(200) NOT NULL
);

CREATE TABLE Article
(
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom VARCHAR(20) NOT NULL,
    prix NUMERIC(7,2) NOT NULL,
    type VARCHAR(20) NOT NULL,
    reference INT NOT NULL UNIQUE,
    description VARCHAR(1000) NOT NULL
);

CREATE UNIQUE INDEX ux_panier ON panier (id_Utilisateur,id_Article);


CREATE TABLE Gourde
(
    id_gourde INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    couleur VARCHAR (20) NOT NULL,
    taille VARCHAR (20) NOT NULL,
    id_article INT NOT NULL UNIQUE,
    gamme VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE Module
(   id_module INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    type_module VARCHAR(20) NOT NULL,
    id_article INT NOT NULL UNIQUE
);

CREATE TABLE Pastille
(   id_pastille INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    saveur VARCHAR(20) NOT NULL,
    id_article INT NOT NULL UNIQUE
);
