<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!--


-->
<jsp:include page="début.jsp"/>
<link href="<c:url value='css/homeStyle.css'/>" rel="stylesheet">
<br>

<!--<div class="recherche"> <input type="search" id="site-search" name="q" />
<input type="button" value="Recherche" />
</div>-->

<button type="button" class="btn btn-light"> <a href="<c:url value='/Compte'/>">Compte </a> </button>
<div>
    <nav class="menu">
        <ul class="niveau1">
            <li><a href="<c:url value='/'/>">Accueil</a></li>
            <li class="sousmenu"><a href="<c:url value='/MultiArticles'/>">Les gourdes</a>
                <ul class="niveau2">
                    <c:if test="${empty ListeGourde}">
                        <!-- Afficher un message indiquant que la liste de gourdes est vide -->
                        <p>Aucune gourde disponible pour le moment.</p>
                    </c:if>
                    <c:forEach var="gourde" items="${ListeGourde}">
                        <li><a href="<c:url value='/gourdes?id_gamme=${gourde.id_gamme}'/>"><c:out value="${gourde.gamme}" /></a></li>
                    </c:forEach>
                </ul>
            </li>
            <li class="sousmenu"><a href="<c:url value='/'/>">Les Modules</a>
                <ul class="niveau2">
                    <li><a href="<c:url value='/Article'/>">Module Chauffant</a></li>
                    <li><a href="<c:url value='/Article'/>">Module Réfrégirant</a></li>
                    <li><a href="<c:url value='/Article'/>">Module Mixte</a></li>
                </ul>
            </li>
            <li class="sousmenu">
                <a href="<c:url value='/'/>">Accessoires</a>
                <ul class="niveau2">
                    <li><a href="<c:url value='/Article'/>">Chargeurs</a></li>
                    <li><a href="<c:url value='/Article'/>">Acc 1</a></li>
                    <li><a href="<c:url value='/Article'/>">Acc 2</a></li>
                </ul>
            </li>
            <li class="sousmenu">
                <a href="<c:url value='/'/>">Les Pastilles</a>
                <ul class="niveau2">
                    <li><a href="<c:url value='/Article'/>">Boissons chaudes</a></li>
                    <li><a href="<c:url value='/Article'/>">Boissons froide</a></li>
                </ul>
            </li>
            <li><a href="<c:url value='/'/>">SAV</a></li>
        </ul>
    </nav>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<div>
    <div class="carousel">
        <ul class="slides">
            <input type="radio" name="radio-buttons" id="img-1" checked/>
            <li class="slide-container">
                <div class="slide-image">
                    <img src="<c:url value='picture/car1.png'/>">
                </div>
                <div class="carousel-controls">
                    <label for="img-3" class="prev-slide">
                        <span>&lsaquo;</span>
                    </label>
                    <label for="img-2" class="next-slide">
                        <span>&rsaquo;</span>
                    </label>
                </div>
            </li>
            <input type="radio" name="radio-buttons" id="img-2"/>
            <li class="slide-container">
                <div class="slide-image">
                    <img src="<c:url value='picture/car2.jpeg'/>">
                </div>
                <div class="carousel-controls">
                    <label for="img-1" class="prev-slide">
                        <span>&lsaquo;</span>
                    </label>
                    <label for="img-3" class="next-slide">
                        <span>&rsaquo;</span>
                    </label>
                </div>
            </li>
            <input type="radio" name="radio-buttons" id="img-3"/>
            <li class="slide-container">
                <div class="slide-image">
                    <img src="<c:url value='picture/car3.jpeg'/>">
                </div>
                <div class="carousel-controls">
                    <label for="img-2" class="prev-slide">
                        <span>&lsaquo;</span>
                    </label>
                    <label for="img-1" class="next-slide">
                        <span>&rsaquo;</span>
                    </label>
                </div>
            </li>
            <div class="carousel-dots">
                <label for="img-1" class="carousel-dot" id="img-dot-1"></label>
                <label for="img-2" class="carousel-dot" id="img-dot-2"></label>
                <label for="img-3" class="carousel-dot" id="img-dot-3"></label>
            </div>
        </ul>
    </div>
</div>
<div class="carousel">
    <div class="carousel-inner">
        <input class="carousel-open" type="radio" id="carousel-1" name="carousel" aria-hidden="true" hidden=""
               checked="checked">
        <div class="carousel-item">
            <img src="http://fakeimg.pl/2000x800/0079D8/fff/?text=Without">
        </div>
        <input class="carousel-open" type="radio" id="carousel-2" name="carousel" aria-hidden="true" hidden="">
        <div class="carousel-item">
            <img src="http://fakeimg.pl/2000x800/DA5930/fff/?text=JavaScript">
        </div>
        <input class="carousel-open" type="radio" id="carousel-3" name="carousel" aria-hidden="true" hidden="">
        <div class="carousel-item">
            <img src="http://fakeimg.pl/2000x800/F90/fff/?text=Carousel">
        </div>
        <label for="carousel-3" class="carousel-control prev control-1">‹</label>
        <label for="carousel-2" class="carousel-control next control-1">›</label>
        <label for="carousel-1" class="carousel-control prev control-2">‹</label>
        <label for="carousel-3" class="carousel-control next control-2">›</label>
        <label for="carousel-2" class="carousel-control prev control-3">‹</label>
        <label for="carousel-1" class="carousel-control next control-3">›</label>
        <ol class="carousel-indicators">
            <li>
                <label for="carousel-1" class="carousel-bullet">•</label>
            </li>
            <li>
                <label for="carousel-2" class="carousel-bullet">•</label>
            </li>
            <li>
                <label for="carousel-3" class="carousel-bullet">•</label>
            </li>
        </ol>
    </div>
</div>
<div id="mz-gallery-container">

    <div id="mz-gallery">

        <figure>
            <img src="<c:url value='picture/gourde1.jpg'/>" alt="Gourde 1" width="700" height="700">
            <figcaption>Gourde 1</figcaption>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
        </figure>

        <figure>
            <img src="<c:url value='picture/gourde2.jpg'/>" alt="Gourde 2" width="700" height="700">
            <figcaption>Gourde 2</figcaption>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
        </figure>

        <figure>
            <img src="<c:url value='picture/gourde4.jpg'/>" alt="Gourde 3" width="700" height="700">
            <figcaption>Gourde 3</figcaption>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
        </figure>

        <figure>
            <img src="<c:url value='picture/gourde3.jpg'/>" alt="Gourde 4" width="700" height="700">
            <figcaption>Gourde 4</figcaption>
            <div></div>
            <div></div>
            <div></div>
            <div></div>
        </figure>


    </div>

</div>
<jsp:include page="fin.jsp"/>