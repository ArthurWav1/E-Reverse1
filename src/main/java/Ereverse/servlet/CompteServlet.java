package Ereverse.servlet;

import Ereverse.bean.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/Compte"})
public class CompteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = (Client) req.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);
        if (client != null) {
            req.setAttribute("nomEtPrenom", client.getPrenom() + " " + client.getNom());
            req.setAttribute("acces",client.getAccess());
        }
        getServletContext().getRequestDispatcher("/jsp/compte.jsp").forward(req, resp);
    }


    /*
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupération des valeurs des champs du formulaire
        String reference = request.getParameter("reference");
        String saveur = request.getParameter("saveur");
        String description = request.getParameter("description");
        double prix = Double.parseDouble(request.getParameter("prix"));
        int volume = Integer.parseInt(request.getParameter("volume"));
        String image = request.getParameter("image");
        int id_type = Integer.parseInt(request.getParameter("type"));
        int id_couleur = Integer.parseInt(request.getParameter("couleur"));


        String erreur = null;

        //Vérification de la validité des champs.
        //Uniquement pour vérifier que les champs conviennent à la BDD, aucune vérification que l'adresse ou l'adresse mail soient valides.

        if (nomProduit.length() > 20) {
            erreur = "Nom du produit incorrect (>20 caractères)";
        }
        if (caracteristique.length() > 1000) {
            erreur = "Caracteristique trop long (>1000 caractères)";
        }
        if (prix < 0) {
            erreur = "Prix négatif";
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
    */
}