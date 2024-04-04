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
            req.setAttribute("nomEtPrenom", client.getPrenom() + " " + client.getNom());
            req.setAttribute("acces",client.getAccess());
        }
        getServletContext().getRequestDispatcher("/jsp/compte.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try {
            getServletContext().getRequestDispatcher("/jsp/compte.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}