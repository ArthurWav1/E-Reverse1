package Ereverse.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet({"/Deconnexion"})
public class DeconnexionServlet extends HttpServlet{

    static Logger logger = LogManager.getLogger(DeconnexionServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    logger.info("JSESSIONID=" + cookie.getValue());
                    break;
                }
            }
        }
        HttpSession session = request.getSession(false);
        if (session != null) {
            logger.info("Logout de l'utilisateur " + session.getAttribute(FiltreAuthentification.SESSION_USER_KEY));
            session.invalidate();
        }

        // redirection vers la page d'accueil
        try {
            response.sendRedirect("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
