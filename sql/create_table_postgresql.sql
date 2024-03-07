-- Création de la table des utilisateurs
CREATE TABLE utilisateur
(
    id       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom      VARCHAR(20) NOT NULL,
    prenom   VARCHAR(20) NOT NULL,
    mail     VARCHAR(100) NOT NULL UNIQUE,
    adresse  VARCHAR(1000) NOT NULL,
    login    VARCHAR(20) NOT NULL UNIQUE,
    salt     BYTEA NOT NULL,
    password BYTEA NOT NULL,
    id_Panier INT
);

GRANT ALL ON ALL TABLES IN SCHEMA public TO Admin;
grant all privileges on all sequences in schema public to Admin;

--Création de la table panier qui représente le panier actuel d'un utilisateur avant commande
CREATE TABLE panier
(
    id_Utilisateur INT NOT NULL,
    id_Article INT NOT NULL
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
    id_Kit_appartenance INT,
    nom_Article VARCHAR(20),
    prix NUMERIC(7,2) NOT NULL,
    Type_Article VARCHAR(20) NOT NULL,
    ref_Article INT NOT NULL
);

CREATE TABLE Kit
(   id_Kit INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom_Kit VARCHAR(20) NOT NULL,
    reference INT NOT NULL
);

CREATE TABLE Gourde
(
    id_gourde INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom_gourde VARCHAR(20) NOT NULL,
    reference INT NOT NULL,
    couleur VARCHAR (20),
    taille VARCHAR (20) NOT NULL,
    gamme VARCHAR(20)
);

CREATE TABLE Module
(   id_module INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom_module VARCHAR(20) NOT NULL,
    type_module VARCHAR(20) NOT NULL,
    reference INT NOT NULL
);

CREATE TABLE Pastille
(   id_pastille INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom_pastille VARCHAR(20),
    saveur VARCHAR(20),
    reference INT
);

