<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<jsp:include page="début.jsp"/>
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
    <button>AJOUTER LA PANIER</button>

</body>

</html>