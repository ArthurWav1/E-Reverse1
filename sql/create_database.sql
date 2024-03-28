-- Création de la base de données
CREATE DATABASE BDDReverse ;
CREATE USER Admin WITH PASSWORD 'Reverse';
GRANT ALL ON ALL TABLES IN SCHEMA public TO Admin;
grant all privileges on all sequences in schema public to Admin;

