<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<jsp:include page="début.jsp"/>
      <div class="recherche"> <input type="search" id="site-search" name="q" />
        <input type="button" value="Recherche" />
      </div>

      <nav class="menu">
        <ul class="niveau1">
          <li><a href="">Accueil</a></li>
          <li class="sousmenu"><a href="">Les gourdes</a>
            <ul class="niveau2">
              <li><a href="">Modèle 1</a></li>
              <li><a href="">Modèle 2</a></li>
              <li><a href="">Modèle 3</a></li>
            </ul>
          </li>
          <li class="sousmenu"><a href="">Les Modules</a>
            <ul class="niveau2">
              <li><a href="">Module Chauffant</a></li>
              <li><a href="">Module Réfrégirant</a></li>
              <li><a href="">Module Mixte</a></li>
            </ul>
          </li>
          <li class="sousmenu">
            <a href="">Accessoires</a>
            <ul class="niveau2">
              <li><a href="">Chargeurs</a></li>
              <li><a href="">Acc 1</a></li>
              <li><a href="">Acc 2</a></li>
              <li><a href="">Acc 3</a></li>
            </ul>
          </li>
          <li class="sousmenu">
            <a href="">Les Pastilles</a>
            <ul class="niveau2">
              <li><a href="">Boissons chaudes</a></li>
              <li><a href="">Boissons froide</a></li>
            </ul>
          </li>
          <li><a href="">SAV</a></li>
        </ul>
      </nav>




  </body>
</html>