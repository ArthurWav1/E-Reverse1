package Ereverse.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({""})
public class HomeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Gère pour le vendeur l'annonce de la mise en ligne d'un nouvel article
        HttpSession session = request.getSession();
        if (session.getAttribute("ajoutReussi") != null){
            session.removeAttribute("ajoutReussi");
        }
        getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request,response);
    }


}