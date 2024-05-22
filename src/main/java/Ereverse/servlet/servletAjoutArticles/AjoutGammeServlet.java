package Ereverse.servlet.servletAjoutArticles;

import Ereverse.dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/AjoutGamme"})
public class AjoutGammeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("ajoutReussi") != null){
            session.removeAttribute("ajoutReussi");
        }
        getServletContext().getRequestDispatcher("/jsp/ajoutArticles/ajoutGamme.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gamme = request.getParameter("gamme");
        double prix = Double.parseDouble(request.getParameter("prix"));
        int volume = Integer.parseInt(request.getParameter("volume"));

        ArticleDAO.ajoutGamme(gamme,prix,volume);
        request.setAttribute("enregistrementReussi","Gamme ajoutée à la base de données avec succès");
        getServletContext().getRequestDispatcher("/jsp/ajoutArticles/ajoutGamme.jsp").forward(request, response);

    }
}