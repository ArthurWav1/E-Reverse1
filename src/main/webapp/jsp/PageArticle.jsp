<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<jsp:include page="début.jsp"/>
<link href="<c:url value='css/ArticleStyle.css'/>" rel="stylesheet">
<section class="product">
    <div class="product__photo">
        <div class="photo-container">
            <div class="photo-main">
                <div class="controls">
                </div>
                <img src="<c:url value='picture/ModèleNoir1.webp'/>">
            </div>
            <div class="photo-album">
                <ul>
                    <li><img src="<c:url value='picture/ModèleNoir2.webp'/>">
                    <li><img src="<c:url value='picture/ModèleNoir3.webp'/>">
                </ul>
            </div>
        </div>
    </div>
    <div class="product__info">
        <div class="title">
            <h1>GOURDE FAMILIALE</h1>
        </div>
        <div class="price">
         <span>109,99€</span>
        </div>
        <div class="variant">
            <h3>COULEURS</h3>
            <ul>
                <li><img src="<c:url value='picture/ModèleOrange.webp'/>"></li>
                <li><img src="<c:url value='picture/ModèleRose.webp'/>"></li>
                <li><img src="<c:url value='picture/ModèleTurquoise.webp'/>"></li>
                <li><img src="<c:url value='picture/ModèleViolet.webp'/>"></li>
            </ul>
        </div>
        <div class="description">
            <h3>CARACTERISTIQUES</h3>
            <ul>
                <li>Remet full shield</li>
                <li>400 ml</li>
                <li>Chauffe ou Refroidis</li>
            </ul>
        </div>
        <button class="buy--btn">AJOUTER AU PANIER</button>
    </div>
</section>
<jsp:include page="fin.jsp"/>