package Ereverse.servlet;

import Ereverse.bean.Client;
import Ereverse.dao.ArticleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet({"/AjoutArticle"})
public class AjoutArticleServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = (Client) req.getSession().getAttribute(FiltreAuthentification.SESSION_USER_KEY);
        if (client != null) {
            req.setAttribute("nomEtPrenom", client.getPrenom() + " " + client.getNom());
        }
        getServletContext().getRequestDispatcher("/jsp/ajoutArticle.jsp").forward(req, resp);
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String erreur = null;
        double prix = 0.;
        int id_gamme = 0;
        int id_couleur = 0;
        String saveur = "";

        System.out.println(request.getParameter("type") + " " + request.getParameter("reference") + " " + request.getParameter("nomProduit") + " " + request.getParameter("description") + " " + request.getParameter("prix") + " " + request.getParameter("image") + " " + request.getParameter("couleur") + " " + request.getParameter("gamme") + " " + request.getParameter("volume") + " " + request.getParameter("saveur"));


        // Récupération des valeurs des champs du formulaire
        //1 = Gourde, 2 = Module, 3 = Accessoire, 4 = Pastille
        int id_type = Integer.parseInt(request.getParameter("type"));
        String reference = request.getParameter("reference");
        String nomProduit = request.getParameter("nomProduit");
        String description = request.getParameter("description");

        if (request.getParameter("prix") != null){
            prix = Double.parseDouble(request.getParameter("prix"));
        }
        else{
            erreur = erreur + "Veuillez préciser un prix. ";
        }

        String image = request.getParameter("image");

        if (id_type == 1){
            //1 = Rouge, 2 = Vert, 3 = Bleu foncé, 4 = Jaune, 5 = Noir, 6 = Blanc
            id_couleur = Integer.parseInt(request.getParameter("couleur"));
            id_gamme = Integer.parseInt(request.getParameter("gamme"));
            int volume = Integer.parseInt(request.getParameter("volume"));
        }

        if (id_type == 4){
            saveur = request.getParameter("saveur");
        }

        //Vérification de la validité des champs.

        if (id_type == -1){
            erreur = "Veuillez sélectionner un type d'article valide. ";
        }

        if (nomProduit.length() > 50 || nomProduit == null) {
            erreur = erreur + "Nom du produit manquant ou trop long (>50 caractères).  ";
        }

        if (description.length() > 1000 || description == null ) {
            erreur = erreur + "Description manquante ou trop longue (>1000 caractères).  ";
        }

        if (reference.length() > 30 || reference == null){
            erreur = erreur + "Référence manquante ou trop longue  (>30 caractères). ";
        }

        //Affichage d'une erreur éventuelle.
        if (erreur != null) {
            request.setAttribute("erreurChamp", erreur);
            getServletContext().getRequestDispatcher("/jsp/ajoutArticle.jsp").forward(request, response);
        }

        //Si aucune erreur n'est détectée, ajout de l'article à la BDD et retour à la page du compte.
        else{
            ArticleDAO.AjoutArticle(reference, saveur, description, prix, image, id_type, id_gamme, id_couleur, nomProduit);
            request.setAttribute("ajoutReussi","Ajout de l'article effectué avec succès !");
            getServletContext().getRequestDispatcher("/jsp/compte.jsp").forward(request,response);
        }
    }
}