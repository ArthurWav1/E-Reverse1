package Ereverse.servlet;

import Ereverse.dao.ClientDAO;
import Ereverse.bean.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

@WebServlet({"/Connexion"})
public class ConnexionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/connexion.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupération des valeurs des champs du formulaire
        String prenom = request.getParameter("user");
        String nom = request.getParameter("nom");
        String mail = request.getParameter("mail");
        String adresse = request.getParameter("adresse");
        String mdp = request.getParameter("pass");

        String erreur = null;

        //Vérification de la validité des champs.
        //Uniquement pour vérifier que les champs conviennent à la BDD, aucune vérification que l'adresse ou l'adresse mail soient valides.
        if (prenom.length() > 20) {
            erreur = "Prénom incorrect (>20 caractères)";
        }
        if (nom.length() > 20) {
            erreur = "Nom incorrect (>20 caractères)";
        }
        if (mail.length() > 100) {
            erreur = "Mail trop long (>100 caractères)";
        }
        if (adresse.length() > 1000) {
            erreur = "Adresse trop longue (>1000 caractères)";
        }
        if (mdp.length() < 5 || mdp.length() > 20) {
            erreur = "Mot de passe trop court (<5 caractères) ou trop long (>20 caractères)"; //On exclut les mdp trop simples.
        }

        //Affichage d'une erreur éventuelle.
        if (erreur != null) {
            request.setAttribute("erreurChamp", erreur);
            getServletContext().getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
        }
        //Si aucune erreur n'est détectée, ajout de l'utilisateur à la BDD et renvoie à la page de connexion.
        else{
            Client client = new Client(prenom,nom,mail,adresse);
            new ClientDAO().Enregistrement(client,mdp);
            request.setAttribute("enregistrementReussi","enregristrement terminé, vous pouvez désormais vous identifier");
            getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request,response);
        }
    }
}