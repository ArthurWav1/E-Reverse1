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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client = (Client) request.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");
        String ancienmdp = request.getParameter("ancienmdp");
        String nouveaumdp = request.getParameter("nouveaumdp");

        if ( (nouveaumdp != null && ancienmdp == null) || (ancienmdp != null && nouveaumdp == null) ){
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
                    ClientDAO.modificationAvecMDP(client, nom, prenom, adresse, nouveaumdp);
                    request.setAttribute("enregistrementReussi","Modifications effectuées avec succès");
                    getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("erreurChamp","Le mot de passe renseigné n'appartient pas à ce compte, veuillez préciser l'ancien mot de passe du compte pour pouvoir le modifier");
                    getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);

                }
            }
        }
        else{
            if (nom != null || prenom != null || adresse != null){
            ClientDAO.modificationSansMDP(client, nom, prenom, adresse);
            request.setAttribute("enregistrementReussi","Modifications effectuées avec succès");
            getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);
            }
            else{
                request.setAttribute("erreurChamp","Veuillez remplir au moins un champ pour modifier vos informations");
                getServletContext().getRequestDispatcher("/jsp/Modification.jsp").forward(request, response);
            }
        }
    }
}
