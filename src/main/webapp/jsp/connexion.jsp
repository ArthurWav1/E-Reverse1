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
        <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
        <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
        <div class="login-form">
            <div class="sign-in-htm">
                <div class="group">
                    <label for="user" class="label">Username</label>
                    <input id="user" type="text" class="input">
                </div>
                <div class="group">
                    <label for="pass" class="label">Password</label>
                    <input id="pass" type="password" class="input" data-type="password">
                </div>
                <div class="group">
                    <input id="check" type="checkbox" class="check" checked>
                    <label for="check"><span class="icon"></span> Keep me Signed in</label>
                </div>
                <div class="group">
                    <input type="submit" class="button" value="Sign In">
                </div>
                <div class="hr"></div>
                <div class="foot-lnk">
                    <a href="<c:url value="/inscription.jsp"/>"> Pas encore inscrit ?</a>
                </div>
            </div>
            <!--
            <div class="sign-up-htm">
                <div class="group">
                    <label for="user" class="label">Prenom</label>
                    <input id="user" name="prenom" type="text" class="input">
                </div>
                <div class="group">
                    <label for="user" class="label">Nom</label>
                    <input id="user" name="nom" type="text" class="input">
                </div>
                <div class="group">
                    <label for="pass" class="label">Password</label>
                    <input id="pass" name="pass" type="password" class="input" data-type="password">
                </div>
                <div class="group">
                    <label for="pass" class="label">Repeat Password</label>
                    <input id="pass" type="password" class="input" data-type="password">
                </div>
                <div class="group">
                    <label for="user" class="label">Email Address</label>
                    <input id="user" name="mail" type="text" class="input">
                </div>
                <div class="group">
                    <label for="user" class="label">Adresse</label>
                    <input id="user" name="adresse" type="text" class="input">
                </div>
                <div class="group">
                    <input formmethod="Post" type="submit" class="button" value="Sign Up">
                </div>
                <div class="hr"></div>
                <div class="foot-lnk">
                    <label for="tab-1">Already Member?</label>
                </div>
            </div> -->
        </div>
    </div>
</div>
</body>
</html>