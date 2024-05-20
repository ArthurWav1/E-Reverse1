package Ereverse.servlet;

import Ereverse.bean.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/AjoutArticle"})
public class AjoutArticleServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = (Client) req.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);
        if (client != null) {
            req.setAttribute("nomEtPrenom", client.getPrenom() + " " + client.getNom());
        }
        getServletContext().getRequestDispatcher("/jsp/ajoutArticle.jsp").forward(req, resp);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des valeurs des champs du formulaire

        //1 = Gourde, 2 = Module, 3 = Accessoire, 4 = Pastille
        int id_type = Integer.parseInt(request.getParameter("type"));
        String reference = request.getParameter("reference");
        String nomProduit = request.getParameter("nomProduit");
        String description = request.getParameter("description");
        double prix = Double.parseDouble(request.getParameter("prix"));
        String image = request.getParameter("image");

        if (id_type == 1){
            //1 = Rouge, 2 = Vert, 3 = Bleu foncé, 4 = Jaune, 5 = Noir, 6 = Blanc
            int id_couleur = Integer.parseInt(request.getParameter("couleur"));
            int id_gamme = Integer.parseInt(request.getParameter("gamme"));
            int volume = Integer.parseInt(request.getParameter("volume"));
        }

        if (id_type == 4){
            String saveur = request.getParameter("saveur");
        }


        //Vérification de la validité des champs.
        String erreur = null;

        if (id_type == -1){
            erreur = "Veuillez sélectionner un type d'article valide, ";
        }

        if (nomProduit.length() > 20) {
            erreur = erreur + "Nom du produit incorrect (>20 caractères), ";
        }

        if (description.length() > 1000) {
            erreur = erreur + "Description trop longue (>1000 caractères), ";
        }

        if (prix < 0) {
            erreur = erreur + "Prix négatif.";
        }


        //Affichage d'une erreur éventuelle.
        if (erreur != null) {
            request.setAttribute("erreurChamp", erreur);
            getServletContext().getRequestDispatcher("/jsp/compte.jsp").forward(request, response);
        }
        //Si aucune erreur n'est détectée, ajout de l'utilisateur à la BDD et renvoie à la page de connexion.
        else{

            request.setAttribute("Entre Article en base de donné","enregristrement terminé,");
            getServletContext().getRequestDispatcher("/jsp/Compte.jsp").forward(request,response);
        }

    }


}