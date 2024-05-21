package Ereverse.servlet;

import Ereverse.bean.Client;
import Ereverse.bean.Panier;
import Ereverse.bean.articles.Article;
import Ereverse.dao.ArticleDAO;
import Ereverse.dao.PanierDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/SuppArticlePanier"})

public class SuppArticlePanier {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Identification utilisateur du panier

        PanierDAO dao = new PanierDAO();

        String ref_article =  String.join(req.getParameter("ref_article"));
        Article article = ArticleDAO.TrouverArticle(ref_article);

        dao.supression_d_article(article);

        req.getServletContext().getRequestDispatcher("/jsp/panier.jsp").forward(req, resp);


    }


}
