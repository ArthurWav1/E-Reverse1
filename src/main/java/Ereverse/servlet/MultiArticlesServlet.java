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


        // Récupérer l'identifiant de l'article à partir des paramètres de la requête
        //int id_type =  Integer.parseInt(request.getParameter("id_type"));


        getServletContext().getRequestDispatcher("/jsp/MultiArticles.jsp").forward(request, response);
    }
}