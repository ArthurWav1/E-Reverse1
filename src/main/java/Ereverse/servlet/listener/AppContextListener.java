package Ereverse.servlet.listener;

import Ereverse.ConnexionBDD.ServiceConnexionBDD;
import Ereverse.servlet.ConnexionServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Listener déclencher lors de l'initialisation deu contexte de l'application : configure le logger et initialise le
 * pool de connexions
 */
@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Initialisation du context");
        ServletContext ctx = servletContextEvent.getServletContext();

        String webAppPath = ctx.getRealPath("/");

        // Initialisation du pool de connexion
        try {
            ServiceConnexionBDD.setupDriver(webAppPath + "WEB-INF/db.properties");
            ServiceConnexionBDD.getConnection();
            System.out.println("Test connexion base de données : OK");
        } catch (Exception e) {
            System.err.println("Connexion base de données : KO. " + e.getMessage());
        }

        // initialisation de log4j2
        try {
            ServiceConnexionBDD.setupLogger(webAppPath + "WEB-INF/log4j2.xml");
            Logger logger = LogManager.getLogger(ConnexionServlet.class);
            logger.info("Logger initialisé");
            System.out.println("Configuration log4j : OK");
        } catch (Exception e) {
            System.err.println("Connection log4j : KO. " + e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            ServiceConnexionBDD.destroyDriver();
        } catch (Exception ignored) {
        }
    }



}
