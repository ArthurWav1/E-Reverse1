--Suppression des tables inutiles
DROP TABLE accessoire;
DROP TABLE kit;

--Suppression des exemples UNIQUEMENT S'ILS ONT ETE CREES EN AMONT
--DELETE FROM article WHERE nom_article = 'GourdeTest';
--DELETE FROM gourde WHERE nom_gourde = 'GourdeTest';
--DELETE FROM pastille WHERE nom_pastille = 'PastilleTest';
--DELETE FROM module WHERE nom_module = 'ModuleTest';

--Suppression des colonnes inutiles dans des tables
ALTER TABLE article DROP COLUMN id_Kit_appartenance;
ALTER TABLE article DROP COLUMN caracteristique;
ALTER TABLE gourde DROP COLUMN nom_gourde;
ALTER TABLE gourde DROP COLUMN reference;
ALTER TABLE module DROP COLUMN nom_module;
ALTER TABLE module DROP COLUMN reference;
ALTER TABLE pastille DROP COLUMN nom_pastille;
ALTER TABLE pastille DROP COLUMN reference;

--Ajout de l'id de l'article dans les tables des articles plus précises
ALTER TABLE gourde ADD id_article INT NOT NULL UNIQUE;
ALTER TABLE module ADD id_article INT NOT NULL UNIQUE;
ALTER TABLE pastille ADD id_article INT NOT NULL UNIQUE;

--Changement des noms des tables et ajout de la description pour les articles
ALTER TABLE article RENAME COLUMN nom_Article TO nom;
ALTER TABLE article RENAME COLUMN Type_Article TO type;
ALTER TABLE article RENAME COLUMN ref_article TO reference;
ALTER TABLE article ADD COLUMN description VARCHAR(1000) NOT NULL;

--Ajout des clés secondaire dans les tables des articles
ALTER TABLE gourde
    ADD CONSTRAINT fk_gourde
        FOREIGN KEY (id_article) REFERENCES article(id);
ALTER TABLE module
    ADD CONSTRAINT fk_module
        FOREIGN KEY (id_article) REFERENCES article(id);
ALTER TABLE pastille
    ADD CONSTRAINT fk_pastille
        FOREIGN KEY (id_article) REFERENCES article(id);

--Création de la table gamme
CREATE TABLE gamme
(
    id_gamme INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    libelle VARCHAR(30) NOT NULL
);

--Changement de la colonne gamme dans gourde
ALTER TABLE gourde DROP COLUMN gamme;
ALTER TABLE gourde ADD COLUMN gamme INT NOT NULL UNIQUE;

--Ajout clé secondaire dans la table gamme
ALTER TABLE gamme
    ADD CONSTRAINT fk_gamme
        FOREIGN KEY (id_gamme) REFERENCES gourde(gamme);