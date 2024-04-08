<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Reverse </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="<c:url value='css/style.css'/>" rel="stylesheet">


</head>
<body>

<div class="enTete">

    <a href="<c:url value='/'/>">
        <img class="imageLogo" src="<c:url value='picture/logoSeul.png'/>" alt = "logo">
    </a>

    <h1> REVERSE  </h1>

    <a href="<c:url value='/Compte'/>" >
        <img class="icon" src="<c:url value='picture/log.png'/>" alt="Login" width="50">

    </a>
    <a href="<c:url value='/Panier'/>" >
        <img class="icon" src="<c:url value='picture/icon_panier-removebg-preview.png'/>" alt="Panier" width="50">
    </a>
</div>
<br>


