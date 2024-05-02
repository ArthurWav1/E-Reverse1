--Suppression des tables inutiles
DROP TABLE article CASCADE;
DROP TABLE module CASCADE;
DROP TABLE gourde CASCADE;
DROP TABLE image CASCADE;
DROP TABLE pastille CASCADE;

ALTER TABLE panier
    ADD CONSTRAINT fk_utilisateur
        FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id);

ALTER TABLE commande
    ADD CONSTRAINT fk_utilisateur
        FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id);

CREATE TABLE article (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    reference VARCHAR(30) NOT NULL UNIQUE,
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
    taille VARCHAR(30) NOT NULL UNIQUE,
    prix NUMERIC(7,2) NOT NULL
);

CREATE TABLE couleur(
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    libelle VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE type(
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    libelle VARCHAR(30) NOT NULL UNIQUE
);


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

ALTER TABLE gamme
    ADD COLUMN volume INT NOT NULL;

ALTER TABLE gamme
    ADD COLUMN gamme VARCHAR(30) NOT NULL;

ALTER TABLE article
    ADD COLUMN nom VARCHAR(50) NOT NULL;