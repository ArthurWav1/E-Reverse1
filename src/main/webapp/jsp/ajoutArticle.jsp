<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Création d'article </title>
    <link href="<c:url value='css/style.css'/>" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

<br>
<br>
<h1> Ajoutez votre article en précisant ses caractéristiques</h1>
<br>
<br>

<div>
    <form method="post" action="AjoutArticle">
        <!-- TypeProduit -->
        <select class="form-select" aria-label="Default select example" name="type">
            <option selected value="-1">Type de produit</option>
            <option value="1">Gourde</option>
            <option value="2">Module</option>
            <option value="3">Accessoire</option>
            <option value="4">Pastille</option>
        </select>

        <!--
        <c:if test="${gourde}">
            <select class="form-select" aria-label="Default select example" name="gamme">
                <option selected value="-1">Gamme de la gourde</option>
                <option value="1">Standard</option>
                <option value="2">Familiale</option>
                <option value="3">Sport</option>
            </select>
        </c:if>
        -->

        <br>

        <!-- Couleur> -->
        <select class="form-select" aria-label="Default select example" name="couleur">
            <option selected value="-1">Couleur du produit</option>
            <option value="0">Pas de couleur</option>
            <option value="1">Rouge</option>
            <option value="2">Vert</option>
            <option value="3">Bleu Fonce</option>
            <option value="4">Jaune</option>
            <option value="5">Noir</option>
            <option value="6">Blanc</option>
        </select>

        <br>

        <!-- Référence du produit -->
        <div class="mb-3">
            <input type="text" class="form-control" id="exampleFormControlInput1" name="reference" placeholder="Référence">
        </div>

        <br>

        <!--Volume -->
        <div class="input-group">
            <input type="text" class="form-control"  name="volume" placeholder="Volume">
        </div>

        <br>

        <!-- Prix -->
        <div class="input-group mb-3">
            <label for="exampleFormControlInput1" class="form-label"></label>
            <br>
            <span class="input-group-text">€</span>
            <input type="text" class="form-control" name="Prix" aria-label="Amount (to the nearest dollar)">
        </div>

        <br>

        <!-- Description -->
        <div class="input-group">
            <input type="text" class="form-control" name="description" placeholder="Description du produit">
        </div>

        <br>

        <!-- Saveur -->
        <div class="input-group">
            <input type="text" class="form-control"  name="saveur" placeholder="Saveur">
        </div>

        <br>

        <!-- Image -->
        <div class="input-group mb-3">
            <input type="file" class="form-control" id="inputGroupFile02" name="image">
            <label class="input-group-text" for="inputGroupFile02">Upload</label>
        </div>
        <input type="submit" value="Ajouter l'article">
    </form>

</div>


<jsp:include page="fin.jsp"/>