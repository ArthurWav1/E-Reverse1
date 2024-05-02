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

CREATE UNIQUE INDEX ux_panier ON panier (id_Utilisateur,id_Article);

--Création de la table image qui regroupe toutes les images des produits à afficher
CREATE TABLE article (
     id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
     reference VARCHAR(30) NOT NULL UNIQUE,
     nom VARCHAR(50) NOT NULL,
     saveur VARCHAR(30),
     description VARCHAR(1000) NOT NULL,
     prix NUMERIC(7,2) NOT NULL,
     image BYTEA NOT NULL,
     id_type INT NOT NULL UNIQUE,
     id_gamme INT NOT NULL UNIQUE,
     id_couleur INT NOT NULL UNIQUE
);

CREATE TABLE gamme(
     id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
     prix NUMERIC(7,2) NOT NULL,
     volume INT NOT NULL,
     gamme VARCHAR(30) NOT NULL
);

CREATE TABLE couleur(
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    libelle VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE type(
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    libelle VARCHAR(30) NOT NULL UNIQUE
);

-- Clés secondaires
ALTER TABLE article
    ADD CONSTRAINT fk_type
        FOREIGN KEY (id_type) REFERENCES type(id);
ALTER TABLE article
    ADD CONSTRAINT fk_gamme
        FOREIGN KEY (id_gamme) REFERENCES gamme(id);
ALTER TABLE article
    ADD CONSTRAINT fk_couleur
        FOREIGN KEY (id_couleur) REFERENCES couleur(id);
ALTER TABLE panier
    ADD CONSTRAINT fk_article
        FOREIGN KEY (id_article) REFERENCES article(id);
ALTER TABLE panier
    ADD CONSTRAINT fk_utilisateur
        FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id);
ALTER TABLE commande
    ADD CONSTRAINT fk_utilisateur
        FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id);