package Ereverse.servlet;
import Ereverse.bean.articles.Article;
import Ereverse.dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/Article"})
public class PageArticleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'identifiant de l'article à partir des paramètres de la requête
        String ref_article =  String.join(request.getParameter("ref_article"));

        // Utiliser cet identifiant pour charger les informations de l'article depuis la base de données
        // (vous pouvez utiliser votre DAO pour cela)
        Article article = ArticleDAO.TrouverArticle(ref_article);

        // Mettre l'objet Article en tant qu'attribut de la requête pour l'affichage dans la JSP
        request.setAttribute("Article", article);

        // Rediriger vers la page JSP de l'article avec les informations chargées
        request.getRequestDispatcher("/pageArticle.jsp").forward(request, response);

        getServletContext().getRequestDispatcher("/jsp/PageArticle.jsp").forward(request,response);
    }
}

