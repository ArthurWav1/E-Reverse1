package Ereverse.servlet;

import Ereverse.bean.articles.Gourde;
import Ereverse.dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet({""})
public class HomeServlet extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Appeler la méthode DAO pour récupérer la liste des types d'articles depuis la base de données
            ArrayList<Gourde> listeGourdes = ArticleDAO.ListerGourde2();
            ArrayList<String> listeTypes = ArticleDAO.ListerType();

            // Ajouter la liste des types d'articles à l'attribut de la requête pour la passer à la JSP
            request.setAttribute("ListeGourdes", listeGourdes);
            request.setAttribute("ListeTypes", listeTypes);

            //Gère pour le vendeur l'annonce de la mise en ligne d'un nouvel article
            HttpSession session = request.getSession();
            if (session.getAttribute("ajoutReussi") != null){
                session.removeAttribute("ajoutReussi");
            }

            // Rediriger vers votre page JSP
            request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);
        }
    }
