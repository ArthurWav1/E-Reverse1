package Ereverse.servlet;

import Ereverse.bean.articles.Gourde;
import Ereverse.dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({""})
public class HomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'identifiant de l'article à partir des paramètres de la requête
        int id_gamme =  Integer.parseInt(request.getParameter("id_gamme"));

        // Utiliser cet identifiant pour charger les informations de l'article depuis la base de données
        // (vous pouvez utiliser votre DAO pour cela)
        ArrayList<Gourde> ListeGourde = ArticleDAO.ListerGourde(id_gamme);

        // Mettre l'objet ListeGourde en tant qu'attribut de la requête pour l'affichage dans la JSP
        request.setAttribute("ListeGourde", ListeGourde);

        // Rediriger vers la page JSP de l'article avec les informations chargées
        request.getRequestDispatcher("/jsp/PageArticle.jsp").forward(request, response);
    }
}