<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="fr">
    <head>
      <meta charset="UTF-8">
      <title>REVERSE - Connexion</title>
      <link href="<c:url value='css/style.css'/>" rel="stylesheet">
    </head>

    <body>
        <%@ include file="Template/alerte.jsp"%>
        <h1> Connexion </h1>

        <p> <input type="text" name="user" placeholder="Utilisateur" required>
            <input type="password" name="pass" required> </p>

        <p> <a href="<c:url value="Inscription"/>"> Inscription </a>  </p>
    </body>
</html>