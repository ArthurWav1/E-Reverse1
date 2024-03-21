ALTER TABLE panier
    ADD CONSTRAINT fk_utilisateur
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id);

ALTER TABLE panier
    ADD CONSTRAINT fk_article
    FOREIGN KEY (id_article) REFERENCES article(id);

ALTER TABLE commande
    ADD CONSTRAINT fk_utilisateur
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateur(id);

ALTER TABLE article
    ADD CONSTRAINT fk_kits
        FOREIGN KEY (id_kit_appartenance) REFERENCES kit(id_kit);

ALTER TABLE image
    ADD CONSTRAINT fk_lien_article
        FOREIGN KEY (refarticle) REFERENCES article(ref_article);
