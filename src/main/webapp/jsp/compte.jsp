<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Reverse </title>
    <link href="<c:url value='css/style.css'/>" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
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
                        <a class="nav-link active" aria-current="page" href="<c:url value='/Compte'/>">Accueil</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/Compte/Parametre'/>">Paramètre du compte</a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="<c:url value='/Compte'/>" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Statistiques
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark">
                            <li><a class="dropdown-item" href="<c:url value='/Compte'/>">Action</a></li>
                            <li><a class="dropdown-item" href="<c:url value='/Compte'/>">Another action</a></li>
                        </ul>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="<c:url value='/Compte'/>" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Gerer les annonces
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark">
                            <li><a class="dropdown-item" href="<c:url value='/Compte'/>">Modifier un article</a></li>
                            <li><a class="dropdown-item" href="<c:url value='/Compte'/>">Déposer un article</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item" href="<c:url value='/Compte'/>">Ordres des articles</a></li>
                            <li><a class="dropdown-item" href="<c:url value='/Compte'/>">Nouvelle catégorie</a></li>
                        </ul>
                    </li>

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

<c:if test="${acces}"> <!-- test pour savoir si la partie vendeur est accessible à partir de l'attribut acces de l'utilisateur -->
<div>
    <ul class="nav nav-pills nav-fill">

     <br>
     <li class="nav-item">
         <a class="nav-link active" aria-current="page" href="#">Caractéristiques produit</a>
     </li>
     <li class="nav-item">
          <a class="nav-link" href="#">Images</a>
        </li>
        <li class="nav-item">
         <a class="nav-link" href="#">Apercu</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Finalisation</a>
        </li>

    </ul>
<br>
    <div>
     <select class="form-select" aria-label="Default select example">
         <option selected>Type de produit</option>
         <option value="1">Gourde</option>
         <option value="2">Module</option>
         <option value="3">Accessoire</option>
         <option value=4>Pastille</option>
    </select>

    <br>
       <div class="mb-3">

           <label for="exampleFormControlInput1" class="form-label">Nom du produit</label>
           <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Nom du produit">
     </div>
     <br>
       <div class="input-group mb-3">
         <label for="exampleFormControlInput1" class="form-label">Prix</label>
          <br>
          <span class="input-group-text">€</span>
         <input type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
      </div>
    <br>
     <div class="input-group">
        <span class="input-group-text"> Caractéristiques</span>
        <textarea class="form-control" aria-label="With textarea"></textarea>
     </div>
        <br>
     <div class="input-group mb-3">
         <input type="file" class="form-control" id="inputGroupFile02">
         <label class="input-group-text" for="inputGroupFile02">Upload</label>
     </div>
    </div>
    </div>
</c:if>

<br>
<jsp:include page="fin.jsp"/>
