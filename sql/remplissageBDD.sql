INSERT INTO couleur(libelle)
VALUES
    ( 'Rouge'),
    ( 'Vert'),
    ('Bleu Fonce'),
    ('Jaune'),
    ('Noir'),
    ('Blanc')
;

INSERT INTO type(libelle)
VALUES
    ('gourde'),
    ('pastille'),
    ('Accessoire'),
    ('Module');

-- Gourdes
INSERT INTO article(reference,description,prix,id_couleur,id_type,nom)
VALUES
    ('GOST001BE','Gourde Standard : autonomie 5 boissons, taille 26cm',109,3,1,'Gourde Standard'),
    ('GOST002R','Gourde Standard : autonomie 5 boissons, taille 26cm',109,1,1,'Gourde Standard'),
    ('GOST003N','Gourde Standard : autonomie 5 boissons, taille 26cm',109,5,1,'Gourde Standard'),
    ('GOST004BA','Gourde Standard : autonomie 5 boissons, taille 26cm',109,6,1,'Gourde Standard'),

    ('GOFA001BE','Gourde Familiale : autonomie 10 boissons, taille 32cm',129,3,1,'Gourde Familiale'),
    ('GOFA002J','Gourde Familiale: autonomie 10 boissons, taille 32cm',129,4,1,'Gourde Familiale'),
    ('GOFA003N','Gourde Familiale : autonomie 10 boissons, taille 32cm',129,5,1,'Gourde Familiale'),
    ('GOFA004V','Gourde Familiale : autonomie 10 boissons, taille 32cm',129,2,1,'Gourde Familiale'),

    ('GOSP001BE','Gourde Sport : ergonomique, autonomie 3 boissons, taille 18cm',99,3,1,'Gourde Sport'),
    ('GOSP0002R','Gourde Sport : ergonomique, autonomie 3 boissons, taille 18cm',99,1,1,'Gourde Sport');


-- Pastille
INSERT INTO article(reference,saveur,description,prix,id_type,nom)
VALUES
    ('PAC001CA','Café','10 pastilles café noir',4,3,'Café'),
    ('PAC002TH','Thé','10 pastilles thé vert',5,2,'Thé'),
    ('PAC003CH','ChocolatChaud','10 pastilles chocolat chaud',5,2,'Chocolat'),
    ('PAF004FR','Fraise','10 pastilles fraise',4,2,'Fraise'),
    ('PAF005PO','Pomme','10 pastilles pomme',4,2,'Pomme');


