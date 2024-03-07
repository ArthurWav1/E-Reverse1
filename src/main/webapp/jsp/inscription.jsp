<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>REVERSE - Inscription</title>
    <link href="<c:url value='css/style.css'/>" rel="stylesheet">

</head>
<body>
<h1> Inscription </h1> <br>

<div>

    <form method = "post" id="idInscription" action="">
        <fieldset form="idInscription">
            <legend> Inscription </legend>
            Prénom : <input type="text" name="prenom" placeholder="Prénom" required> <br>
            Nom : <input type="text" name="nom" placeholder="Nom" required> <br>
            Adresse mail : <input type="text" name="mail" placeholder="Mail" required> <br>
            Mot de passe : <input type="password" name="pass" placeholder="Mot de passe" required>  <br>
            Confirmer mot de passe : <input type="password" name="pass" placeholder="Mot de passe" required> <br>
            <input type="submit" value="S'inscrire">
        </fieldset>

    </form>
</div>

</body>
</html>