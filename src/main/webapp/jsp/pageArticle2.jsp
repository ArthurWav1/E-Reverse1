<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<jsp:include page="début.jsp"/>
<link href="<c:url value='css/ArticleStyle2.css'/>" rel="stylesheet">
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
                    <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537302064/codepen/delicious-apples/green-apple2.png" alt="green apple"></li>
                    <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537303532/codepen/delicious-apples/half-apple.png" alt="half apple"></li>
                    <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537303160/codepen/delicious-apples/green-apple-flipped.png" alt="green apple"></li>
                    <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537303708/codepen/delicious-apples/apple-top.png" alt="apple top"></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="product__info">
        <div class="title">
            <h1>GOURDE DU BRAVE</h1>
        </div>
        <div class="price">
         <span>119,99€</span>
        </div>
        <div class="variant">
            <h3>COULEURS</h3>
            <ul>
                <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537302064/codepen/delicious-apples/green-apple2.png" alt="green apple"></li>
                <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537302752/codepen/delicious-apples/yellow-apple.png" alt="yellow apple"></li>
                <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537302427/codepen/delicious-apples/orange-apple.png" alt="orange apple"></li>
                <li><img src="https://res.cloudinary.com/john-mantas/image/upload/v1537302285/codepen/delicious-apples/red-apple.png" alt="red apple"></li>
            </ul>
        </div>
        <div class="description">
            <h3>CARACTERISTIQUES</h3>
            <ul>
                <li>Remet full shield</li>
                <li>5O cl</li>
                <li>Chauffe ou Refroidis</li>
            </ul>
        </div>
        <button class="buy--btn">AJOUTER AU PANIER</button>
    </div>
</section>
<jsp:include page="fin.jsp"/>