package Ereverse.servlet;

import Ereverse.bean.articles.Article;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Identification utilisateur du panier
        Client client = (Client) req.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);

        //Récupéreration des article du panier et de leur nombres respectifs
        ArrayList articles_panier = PanierDAO.recup_articles_panier(new Panier(client.getId()));
        ArrayList nb_des_articles = PanierDAO.recup_nb_articles_panier(new Panier(client.getId()));

        // Mise des attributs nécessaires en tant qu'attributs de la requête pour l'affichage dans la JSP
        for (int i=0;i<articles_panier.size();i++){
            Article art_i = (Article) articles_panier.get(i);
            int nb_i = (int) nb_des_articles.get(i);
            req.setAttribute("ref_article_panier_i", art_i.get_ref());
            req.setAttribute("nom_article_panier_i", art_i.getNom_Article());
            req.setAttribute("prix_article_panier_i", art_i.getPrix());
            req.setAttribute("nb_article_panier_i", nb_i);

        }

        // Redirection vers la page JSP du panier avec les informations chargées
        getServletContext().getRequestDispatcher("/jsp/panier.jsp").forward(req, resp);
    }
}