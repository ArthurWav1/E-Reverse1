package Ereverse.servlet;

import Ereverse.bean.Panier;
import Ereverse.bean.articles.Article;
import Ereverse.dao.PanierDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/Panier"})
public class PanierServlet extends HttpServlet {


    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/panier.jsp").forward(req,resp);
    }*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Panier panier = (Panier) req.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);
               // Article article = (Article);

        if (panier != null) {
            req.setAttribute("liste_articles_panier", panier.get_nb_article());
            req.setAttribute("nb_articles_panier",panier.get_nb_article());
            //req.setAttribute("prix_articles_panier",panier.Prix_article_Panier(panier, article));
        }
        getServletContext().getRequestDispatcher("/jsp/panier.jsp").forward(req, resp);
    }
}