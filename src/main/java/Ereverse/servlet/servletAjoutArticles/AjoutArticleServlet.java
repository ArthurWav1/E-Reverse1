package Ereverse.servlet.servletAjoutArticles;

import Ereverse.bean.Client;
import Ereverse.bean.articles.Gamme;
import Ereverse.dao.ArticleDAO;
import Ereverse.servlet.FiltreAuthentification;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({"/AjoutArticle"})
public class AjoutArticleServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("ajoutReussi") != null){
            session.removeAttribute("ajoutReussi");
        }

        ArrayList<Gamme> listeGammes = ArticleDAO.listerGamme();
        for(Gamme g : listeGammes){
            System.out.println(g.getId_gamme());
        }
        session.setAttribute("listeGammes",listeGammes);

        getServletContext().getRequestDispatcher("/jsp/ajoutArticles/ajoutArticle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Initialisation des variables
        String erreur = "";
        double prix = 0.;
        int id_gamme = 0;
        int id_couleur = 0;
        String saveur = "";


        // Récupération des valeurs des champs du formulaire
        //1 = Gourde, 2 = Gamme, 3 = Accessoire, 4 = Pastille
        int id_type = Integer.parseInt(request.getParameter("type"));

        String reference = request.getParameter("reference");
        String nomProduit = request.getParameter("nomProduit");
        String description = request.getParameter("description");

        if (!request.getParameter("prix").isEmpty() && id_type != 1){
            try{
                prix = Double.parseDouble(request.getParameter("prix"));
            }
            catch (NumberFormatException e){
                erreur = erreur + "Le format du prix n'est pas valide (format correct: XXXXX.YY). ";
            }
        }
        else{
            erreur = erreur + "Veuillez préciser un prix. ";
        }

        String image = request.getParameter("image");

        if (id_type == 1){ //Gourde
            //1 = Rouge, 2 = Vert, 3 = Bleu foncé, 4 = Jaune, 5 = Noir, 6 = Blanc, -1 = erreur
            id_couleur = Integer.parseInt(request.getParameter("couleur"));
            id_gamme = Integer.parseInt(request.getParameter("gamme"));
            //Vérification de la validité des champs pour la couleur, la gamme et le volume
            if (id_couleur == -1){
                erreur = "Veuillez sélectionner une couleur valide. ";
            }
            if (id_gamme == -1){
                erreur = "Veuillez sélectionner une gamme valide. ";
            }
            else{ //Le prix est obligatoirement celui de la gamme
                Gamme gamme = ArticleDAO.chercherGamme(id_gamme);
                prix = gamme.getPrix();
            }
        }

        if (id_type == 2){ //Saveur
            saveur = request.getParameter("saveur");
        }

        //Vérification de la validité des champs.

        if (id_type == -1){
            erreur = "Veuillez sélectionner un type d'article valide. ";
        }

        if (nomProduit.length() > 50 || nomProduit.isEmpty()) {
            erreur = erreur + "Nom du produit manquant ou trop long (>50 caractères).  ";
        }

        if (description.length() > 1000 || description.isEmpty() ) {
            erreur = erreur + "Description manquante ou trop longue (>1000 caractères).  ";
        }

        if (reference.length() > 30 || reference.isEmpty()){
            erreur = erreur + "Référence manquante ou trop longue  (>30 caractères). ";
        }

        //Affichage d'une erreur éventuelle.
        if (!erreur.isEmpty()) {
            request.setAttribute("erreurChamp", erreur);
            getServletContext().getRequestDispatcher("/jsp/ajoutArticles/ajoutArticle.jsp").forward(request, response);
        }

        //Si aucune erreur n'est détectée, ajout de l'article à la BDD et retour à la page du compte.
        else{
            //Ajout de l'article à la BDD
            ArticleDAO.AjoutArticle(reference, saveur, description, prix, image, id_type, id_gamme, id_couleur, nomProduit);
            Client client = (Client) request.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);
            HttpSession session = request.getSession();
            //Attributs pour la page compte, infos utilisateur + notif de réussite
            session.setAttribute(FiltreAuthentification.SESSION_USER_KEY,client);
            session.setAttribute("ajoutReussi","Ajout de l'article effectué avec succès !");
            //Redirige vers la page compte lorsque l'article est rajouté
            response.sendRedirect("Compte");
        }
    }
}