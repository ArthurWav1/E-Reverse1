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
    <form method="post" action="Suppression">
        <div class="mb-3">
            <input type="text" class="form-control" name="motdepasse" placeholder="Mot de passe du compte">
        </div>
        <input type="submit" value="Supprimer le compte">
        <a href="<c:url value="/Modification"/>" class="btn btn-primary">Annuler</a><br>
    </form>

<jsp:include page="fin.jsp"/>