package Ereverse.servlet;

import Ereverse.bean.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet({"/Compte"})
public class CompteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = (Client) req.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);
        if (client != null) {
            System.out.println(client);
            req.setAttribute("nomEtPrenom", client.getPrenom() + " " + client.getNom());
            req.setAttribute("acces",client.getAccess());
            req.setAttribute("prenom",client.getPrenom());
            req.setAttribute("nom",client.getNom());
            req.setAttribute("mail",client.getMail());
            req.setAttribute("adresse",client.getAdresse());
        }
        getServletContext().getRequestDispatcher("/jsp/compte.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}