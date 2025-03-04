<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Mon compte </title>
    <link href="<c:url value='css/style.css'/>" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>

<body>

<!-- Barre de navigation entre les onglets sur le côté droit de la page -->

<nav class="navbar navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="<c:url value='/'/>"> Reverse </a>
        <a class="navbar-brand"> Votre Compte </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar" aria-controls="offcanvasDarkNavbar" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
            <div class="offcanvas-header">
                <h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel" name = "nomPrenomAffichage"> ${nomEtPrenom} </h5> <!-- Affichage nom et prénom du client dynamique -->
                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
            </div>
            <div class="offcanvas-body">
                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="<c:url value='/'/>">Accueil</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/Modification'/>">Paramètre du compte</a>
                    </li>

                    <c:if test="${acces}">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/AjoutArticle'/>">Modifier un article</a>
                    </li>
                    </c:if>

                    <li class="nav-item">
                        <a href="<c:url value="Deconnexion"/>">Se déconnecter</a> <!-- Déconnexion du compte et renvoie vers home -->
                    </li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<br>
<br>

<!-- Affichage des informations du compte -->
<div>
    <%@ include file="alerte.jsp"%>
    <h1>Informations du compte : </h1>
    <br><br><br><br>
    <h5 name="prenom" class="text-white">Prénom: ${prenom}</h5>
    <h5 name="nom" class="text-white">Nom de famille: ${nom}</h5>
    <h5 name="mail" class="text-white">Mail associé au compte: ${mail}</h5>
    <h5 name="adresse" class="text-white">Adresse de livraison: ${adresse}</h5>
    <br><br>

    <a href="<c:url value="/Modification"/>" class="btn btn-primary">Modifier ses informations personnelles</a><br>
</div>

<br><br>
<c:if test="${acces}"> <!-- test pour savoir si la partie vendeur est accessible à partir de l'attribut acces de l'utilisateur -->
<a href="<c:url value="/AjoutArticle"/>" class="btn btn-primary">Ajouter un article</a>
</c:if>

<jsp:include page="fin.jsp"/>
