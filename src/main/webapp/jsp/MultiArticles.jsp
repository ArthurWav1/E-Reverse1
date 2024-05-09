<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<jsp:include page="début.jsp"/>
<br>
<link href="<c:url value='css/ArticleStyle.css'/>" rel="stylesheet">
<br>
<div class="container text-center">
    <div class="row">
        <div class="col">
            <div class="card" style="width: 18rem;">
                <img src="<c:url value='picture/ModèleNoir1.webp'/>" class="card-img-top" alt="image gourde">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <a href="#" class="btn btn-primary">Voir le modèle</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card" style="width: 18rem;">
                <img src="<c:url value='picture/ModèleNoir1.webp'/>" class="card-img-top" alt="image gourde">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <a href="#" class="btn btn-primary">Voir le modèle</a>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card" style="width: 18rem;">
                <img src="<c:url value='picture/ModèleNoir1.webp'/>" class="card-img-top" alt="image gourde">
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                    <a href="#" class="btn btn-primary">Voir le modèle</a>
                </div>
            </div>
        </div>
    </div>
</div>

<br>


<jsp:include page="fin.jsp"/>
