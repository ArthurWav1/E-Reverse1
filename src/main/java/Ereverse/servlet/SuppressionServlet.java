package Ereverse.servlet;

import Ereverse.bean.Client;
import Ereverse.dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/Suppression"})
public class SuppressionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/Suppression.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mdp = request.getParameter("motdepasse");
        Client client = (Client) request.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);

        if (!mdp.isEmpty()){ //Vérification qu'un mdp a bien été entré
            if (ClientDAO.compareMDP(client.getMail(), mdp)){ // Vérification que les mdp sont identiques
                //Supprime le client de la BDD et déconnecte le client en le renvoyant à la page d'accueil
                ClientDAO.suppressionClient(client);
                response.sendRedirect("Deconnexion");
            }
            else{ //Dans le cas où les mdp ne sont pas identiques, renvoie une alerte
                request.setAttribute("mdpDifferent","Le mot de passe entré est différent du mot de passe enregistré pour ce compte");
                getServletContext().getRequestDispatcher("/jsp/Suppression.jsp").forward(request, response);
            }
        }
        else{
            request.setAttribute("erreurChamp","Veuillez entrer un mot de passe pour supprimer le compte");
            getServletContext().getRequestDispatcher("/jsp/Suppression.jsp").forward(request, response);
        }
    }
}