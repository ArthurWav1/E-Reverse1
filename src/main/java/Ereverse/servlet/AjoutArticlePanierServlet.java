package Ereverse.servlet;

import Ereverse.bean.articles.Article;
import Ereverse.bean.Client;
import Ereverse.bean.Panier;
import Ereverse.dao.ArticleDAO;
import Ereverse.dao.PanierDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/AjoutArticlePanier"})

public class AjoutArticlePanierServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getServletContext().getRequestDispatcher("/jsp/panier.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Identification utilisateur du panier

        Client client = (Client) req.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);


        String ref_article =  String.join(req.getParameter("ref_article"));

        Article article = ArticleDAO.TrouverArticle(ref_article);

        PanierDAO.ajout_d_article(new Panier(client.getId()),article,1);


        req.getServletContext().getRequestDispatcher("/jsp/panier.jsp").forward(req, resp);

    }

}
