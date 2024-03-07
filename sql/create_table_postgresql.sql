-- Création de la table des utilisateurs : à faire sur la base tst
CREATE TABLE utilisateur
(
    id       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    nom      VARCHAR(20) NOT NULL,
    prenom   VARCHAR(20) NOT NULL,
    mail     VARCHAR(40) NOT NULL UNIQUE,
    adresse  VARCHAR(1000) NOT NULL,
    login    VARCHAR(20) NOT NULL UNIQUE,
    salt     BYTEA NOT NULL,
    password BYTEA NOT NULL,
    id_Panier INT
);

GRANT ALL ON ALL TABLES IN SCHEMA public TO bddreverse;
grant all privileges on all sequences in schema public to bddreverse;

CREATE TABLE panier
(
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    id_Article INT,
    Prix NUMERIC(7,2) NOT NULL
)

