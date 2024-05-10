package Ereverse.servlet;
import Ereverse.bean.articles.Article;
import Ereverse.bean.articles.Gourde;
import Ereverse.dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
@WebServlet({"/MultiArticles"})
public class MultiArticlesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Gourde> listeGourdes = ArticleDAO.ListerGourde2();
        ArrayList<String> listeTypes = ArticleDAO.ListerType();

        // Ajouter la liste des types d'articles à l'attribut de la requête pour la passer à la JSP
        request.setAttribute("ListeGourdes", listeGourdes);
        request.setAttribute("ListeTypes", listeTypes);


        getServletContext().getRequestDispatcher("/jsp/MultiArticles.jsp").forward(request, response);
    }

}