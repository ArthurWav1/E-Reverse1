package Ereverse.servlet;

import Ereverse.dao.ClientDAO;
import Ereverse.bean.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


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
        String mail = request.getParameter("mail");
        String mdp = request.getParameter("mdp");

        String erreurConnexion = null;
        //Tests si le mail et le mdp sont valides d'un point de vue format pour la bdd
        if (mail.length()>100){
            erreurConnexion = "Le mail entré est trop long, et n'appartient à aucun utilisateur";
        }
        if (mdp.length()>100){
            erreurConnexion = "Le mot de passe entré est trop long, et n'appartient à aucun utilisateur";
        }

        if (erreurConnexion != null){
            request.setAttribute("erreurConnexion",erreurConnexion);
            getServletContext().getRequestDispatcher("/jsp/connexion.jsp").forward(request,response);
        }
        else { //Cas où aucune erreur de format n'est détectée
            Client client = new ClientDAO().login(mail,mdp);
            if (client != null){
                System.out.println("Client trouvé : " + client);
                HttpSession session =request.getSession();
                session.setAttribute(FiltreAuthentification.SESSION_USER_KEY,client);
                response.sendRedirect("Compte");
            }
            else{
                request.setAttribute("erreurUtilisateurIntrouvable","L'utilisateur demandé est introuvable, veuillez vérifier votre mail ou votre mot de passe");
                getServletContext().getRequestDispatcher("/jsp/connexion.jsp").forward(request,response);
            }
        }
    }
}