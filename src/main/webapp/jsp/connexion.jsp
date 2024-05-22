<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>REVERSE - Connexion</title>
    <link href="<c:url value='css/style.css'/>" rel="stylesheet">
    <link href="<c:url value='css/connexionStyle.css'/>" rel="stylesheet">
</head>

    <body>
        <%@ include file="alerte.jsp"%>
    </body>
<div class="login-wrap">
    <div class="login-html">
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked>
            <label for="tab-1" class="tab">Sign In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up">
            <label for="tab-2" class="tab"></label>
        <div class="login-form">
            <!-- Form pour tout envoyer dans le doPost de ConnexionServlet -->
            <form method ="post" id="idConnexion" action="Connexion">
            <div class="sign-in-htm">
                <div class="group">
                    <label for="user" class="label"> Mail</label>
                    <input id="user" type="text" class="input" name="mail">
                </div>
                <div class="group">
                    <label for="pass" class="label"> Mot de Passe</label>
                    <input id="pass" type="password" class="input" data-type="password" name="mdp">
                </div>
                <div class="group">
                    <input type="submit" class="button" value="Connexion">
                </div>
                <div class="hr"></div>
                <div class="foot-lnk">
                    <a href="<c:url value="/Inscription"/>"> Pas encore inscrit ?</a>
                </div>
            </div>
            </form>
        </div>
    </div>
</div>
</html>