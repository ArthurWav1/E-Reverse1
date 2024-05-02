package Ereverse.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Filtre qui permet de savoir si l'utilisateur est connecté où non, ce qui permet d'accéder à sa page utilisateur et sa page panier
 */

@WebFilter("/*")
public class FiltreAuthentification implements Filter {

    public static final String SESSION_USER_KEY = "utilisateur";

    private final Logger logger = LogManager.getLogger(FiltreAuthentification.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Initialisation du filtre d'Authentification");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req =(HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        //Extraction du path sans le / final
        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("/+$", "");

        // OK pour fichiers du réperotire css
        if (path.startsWith("/css/") || path.startsWith("/picture/")) {
            // poursuit par le prochain filtre
            filterChain.doFilter(request, response);
            return;
        }

        //Test si l'utilisateur est authentifié, session et SESSION_USER_KEY non nulles.
        boolean isAuthenticated = session != null && session.getAttribute(SESSION_USER_KEY) != null;

        //Listes des servlets autorisées sans connexion. La page d'accueil, des articles, de connexion et d'enregistrement.
        List<String> authorizedServlets = List.of("", "/manifest.json", "/Connexion", "/Inscription","/Article","/gourdes","/Compte");

        // Redirection vers la page de login s'il n'est pas authentifié et devrait l'être pour accéder à la page demandée.
        // Check si c'est une servlet autorisée et si on est connecté.
        if (!authorizedServlets.contains(path) && !isAuthenticated) {
            System.out.println("Session null");
            // Affichage de la page de connexion
            req.getServletContext().getRequestDispatcher("/jsp/connexion.jsp").forward(request, response);
        } else {
            // poursuit par le prochain filtre.
            filterChain.doFilter(request, response);
        }
    }
}
