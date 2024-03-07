<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Produit 1</title>
    <link href="<c:url value='css/style.css'/>" rel="stylesheet">
</head>

<body>

<div class="product-details">
    <h1>Nom du Produit</h1>
    <img class="Article1" src="<c:url value='picture/Gourde.jpg'/>" alt = "Gourde">
    <p>Description article</p>
    <p>Prix</p>
    <p>Quantité :
        <select name ="Quantité">
            <option>  1 </option>
            <option>  2 </option>
            <option>  3 </option>
            <option>  4 </option>
            <option>  5 </option>
        </select></p>
    <button type="submit">AJOUTER AU PANIER</button>
</div>

<div classe = "panier">
    <h3>Panier</h3>
    <form action = "PagePanier.html">
        <button> Panier</button>
    </form>
</div>

</body>

</html>