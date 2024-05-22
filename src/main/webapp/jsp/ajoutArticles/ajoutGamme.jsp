<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Création d'article </title>
    <link href="<c:url value='css/style.css'/>" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>

<%@ include file="../alerte.jsp"%>

<body>

<a href="<c:url value="/Compte"/>" class="btn btn-primary">Retour</a>
<a href="<c:url value="/AjoutArticle"/>" class="btn btn-primary">Nouvel article</a>


<br>
<br>
<h1> Ajoutez votre article en précisant ses caractéristiques</h1>
<br>
<br>

<form method="post" action="AjoutGamme">

    <div class="mb-3">
        <input type="text" class="form-control" name="gamme" placeholder="Nom de la nouvelle gamme" required>
    </div>

    <br>

    <div class="mb-3">
        <input type="text" class="form-control" name="volume" placeholder="Volume" required>
    </div>

    <br>

    <div class="input-group mb-3">
        <br>
        <span class="input-group-text">€</span>
        <input type="number" class="form-control" name="prix" aria-label="Amount (to the nearest dollar)" placeholder="Prix de la nouvelle gamme" required>
    </div>

    <br>

    <input type="submit" value="Ajouter la gamme">

</form>

</body>

</html>
