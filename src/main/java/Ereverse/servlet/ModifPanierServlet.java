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

@WebServlet({"/ModifArticlePanier"})

public class ModifPanierServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Client client = (Client) req.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);

        PanierDAO dao = new PanierDAO();

        String ref_article =  String.join(req.getParameter("ref_article"));
        Article article = ArticleDAO.TrouverArticle(ref_article);

        int nb = Integer.parseInt(req.getParameter("nb_article"));

        dao.modification_nb_articles(new Panier(client.getId()),article,nb);


        req.getServletContext().getRequestDispatcher("/jsp/panier.jsp").forward(req, resp);


    }




}
