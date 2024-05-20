package Ereverse.servlet;

import Ereverse.bean.Client;
import Ereverse.bean.Panier;
import Ereverse.bean.articles.Article;
import Ereverse.dao.PanierDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/Panier"})
public class PanierServlet extends HttpServlet {


    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/panier.jsp").forward(req,resp);
    }*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/Panier.jsp").forward(req, resp);

        Client client = (Client) req.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);

        List<Object[]> panier = PanierDAO.recup_articles_panier(new Panier(client.getId()));

        if (panier != null) {
            req.setAttribute("article_panier", panier.get(0));
            req.setAttribute("nb_articles_panier",panier.get(1));
            //req.setAttribute("prix_articles_panier",panier.Prix_article_Panier(panier, article));
        }

        getServletContext().getRequestDispatcher("/jsp/panier.jsp").forward(req, resp);
    }
}