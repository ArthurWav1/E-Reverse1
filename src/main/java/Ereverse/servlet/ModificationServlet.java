package Ereverse.servlet;

import Ereverse.bean.Client;
import Ereverse.dao.ClientDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/Modification"})
public class ModificationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(req, resp);
    }

    /**
     * Méthode doPost du formulaire de modification/suppression du compte
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = (Client) request.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");
        String ancienmdp = request.getParameter("ancienmdp");
        String nouveaumdp = request.getParameter("nouveaumdp");
        String suppression = request.getParameter("suppression");
        String validAncienMDP = request.getParameter("validAncienMDP");

        if (suppression.equals("suppression")){
            //Actualisation du formulaire pour pouvoir valider la suppression du compte
            String validationSuppr =
                    "<div class=\"mb-3\">\n" +
                    "        <input type=\"password\" class=\"form-control\" name=\"validAncienMDP\" placeholder=\"Ancien mot de passe\">\n" +
                    "    </div>" +
                    "<input type=\"submit\" value=\"Supprimer le compte\" >\n";

            request.setAttribute("validationSuppression",validationSuppr);
            request.setAttribute("indicationChamp","Veuillez entrer le mot de passe du compte pour le supprimer");
            getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);
        }
        if (validAncienMDP != null){ //Vérification qu'un mdp a bien été entré
            if (ClientDAO.compareMDP(client.getMail(), validAncienMDP)){ // Vérification que les mdp sont identiques
                //Supprime le client de la BDD et déconnecte le client en le renvoyant à la page d'accueil
                ClientDAO.suppressionClient(client);
                response.sendRedirect("Deconnexion");
            }
            else{ //Dans le cas où les mdp ne sont pas identiques, renvoie une alerte
                request.setAttribute("mdpDifferent","Le mot de passe entré est différent du mot de passe enregistré pour ce compte");
                String validationSuppr =
                        "<div class=\"mb-3\">\n" +
                                "        <input type=\"password\" for=\"formulaireSuppression\" class=\"form-control\" name=\"validAncienMDP\" placeholder=\"Ancien mot de passe\">\n" +
                                "    </div>\n"+
                        "<input type=\"submit\" value=\"Supprimer le compte\" >\n";
                request.setAttribute("validationSuppression",validationSuppr);
                getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);
            }
        }
        if (nouveaumdp != null && ancienmdp == null){
            request.setAttribute("erreurChamp","Veuillez préciser l'ancien et le nouveau mot de passe pour le modifier (entre 6 et 20 caractères)");
            getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);

        }
        if (ancienmdp != null && nouveaumdp == null){
            request.setAttribute("erreurChamp","Veuillez préciser l'ancien et le nouveau mot de passe pour le modifier (entre 6 et 20 caractères)");
            getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);
        }
        if (nouveaumdp != null){
            if (nouveaumdp.length() > 20 || nouveaumdp.length() <5){
                 request.setAttribute("erreurChamp","Veuillez choisir un mot de passe contenant entre 6 et 20 caractères");
                 getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);
            }
            else{
                if (ClientDAO.compareMDP(client.getMail(),ancienmdp)){
                    ClientDAO.modification(client, nom, prenom, adresse, ancienmdp, nouveaumdp);
                    request.setAttribute("enregistrementReussi","Modifications effectuées avec succès");
                    getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("erreurChamp","Le mot de passe renseigné n'appartient pas à ce compte, veuillez préciser l'ancien mot de passe du compte pour pouvoir le modifier");
                    getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);

                }
            }
        }
        ClientDAO.modification(client, nom, prenom, adresse, ancienmdp, nouveaumdp);
        request.setAttribute("enregistrementReussi","Modifications effectuées avec succès");
        getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);
    }
}
