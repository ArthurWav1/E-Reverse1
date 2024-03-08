<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<jsp:include page="début.jsp"/>
<br>
      <div class="recherche"> <input type="search" id="site-search" name="q" />
        <input type="button" value="Recherche" />
      </div>
<br>
      <nav class="menu">
        <ul class="niveau1">
          <li><a href="<c:url value='/'/>">Accueil</a></li>
          <li class="sousmenu"><a href="">Les gourdes</a>
            <ul class="niveau2">
              <li><a href="<c:url value='/Article'/>">Modèle 1</a></li>
              <li><a href="<c:url value='/Article'/>">Modèle 2</a></li>
              <li><a href="<c:url value='/Article'/>">Modèle 3</a></li>
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
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <img class="imageFond" src="<c:url value='picture/fondCamp2.jpeg'/>" alt = "logo" width ="1000">


<jsp:include page="fin.jsp"/>