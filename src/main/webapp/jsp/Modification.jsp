<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier son compte </title>
    <link href="<c:url value='css/style.css'/>" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<%@ include file="alerte.jsp"%>

<body>

    <h3 name="Instructions" class="text-white">Veuillez remplir les champs que vous souhaitez modifier</h3>

    <br>

    <h4 name="Instructions2" class="text-danger">Remplissez uniquement les informations à changer</h4>

    <br><br><br>

    <!-- Vers la page du compte-->
    <a href="<c:url value="/Compte"/>" class="btn btn-primary">Retour</a><br><br>

    <!-- Formulaire pour changer les informations -->
    <form method="post" action="Modification" id="formulaireModification">

        <br>

        <div class="mb-3">
            <input type="text" class="form-control" name="nom" placeholder="Nom">
        </div><br>

        <div class="mb-3">
            <input type="text" class="form-control" name="prenom" placeholder="Prénom">
        </div><br>

        <div class="mb-3">
            <input type="text" class="form-control" name="adresse" placeholder="Adresse postale">
        </div><br>

        <div class="mb-3">
            <input type="text" class="form-control" name="ancienmdp" placeholder="Ancien mot de passe">
        </div><br>

        <div class="mb-3">
            <input type="text" class="form-control" name="nouveaumdp" placeholder="Nouveau mot de passe">
        </div><br><br>

        <input type="submit" value="Modifier les informations">
    </form>

    <!-- Vers la suppression du compte -->
    <a href="<c:url value="/Suppression"/>" class="btn btn-danger">Supprimer le compte</a><br><br>

    <jsp:include page="fin.jsp"/>