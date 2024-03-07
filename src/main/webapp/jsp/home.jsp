<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="UTF-8">
    <title>Reverse </title>
    <link href="<c:url value='css/style.css'/>" rel="stylesheet">

  </head>

  <body>

    <div class="enTete">
      <img class="imageLogo" src="<c:url value='picture/log.png'/>" alt = "logo">
      <h1> REVERSE </h1>
      <a href="../html/connexion.html" >
        <img class="icon" src="../picture/log.png" alt="Login" width="50">
      </a>
      <a href="" >
        <img class="icon" src="../picture/icon_panier-removebg-preview.png" alt="Panier" width="50">
      </a>

      <div class="recherche"> <input type="search" id="site-search" name="q" />
        <input type="button" value="Recherche" />
      </div>

      <nav class="menu">
        <ul class="niveau1">
          <li><a href="">Accueil</a></li>
          <li class="sousmenu"><a href="">Les gourdes</a>
            <ul class="niveau2">
              <li><a href="">Modèle 1</a></li>
              <li><a href="">Modèle 2</a></li>
              <li><a href="">Modèle 3</a></li>
            </ul>
          </li>
          <li class="sousmenu"><a href="">Les Modules</a>
            <ul class="niveau2">
              <li><a href="">Module Chauffant</a></li>
              <li><a href="">Module Réfrégirant</a></li>
              <li><a href="">Module Mixte</a></li>
            </ul>
          </li>
          <li class="sousmenu">
            <a href="">Accessoires</a>
            <ul class="niveau2">
              <li><a href="">Chargeurs</a></li>
              <li><a href="">Acc 1</a></li>
              <li><a href="">Acc 2</a></li>
              <li><a href="">Acc 3</a></li>
            </ul>
          </li>
          <li class="sousmenu">
            <a href="">Les Pastilles</a>
            <ul class="niveau2">
              <li><a href="">Boissons chaudes</a></li>
              <li><a href="">Boissons froide</a></li>
            </ul>
          </li>
          <li><a href="">SAV</a></li>
        </ul>
      </nav>

    </div>



  </body>
</html>