<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link href="<c:url value='css/style.css'/>" rel="stylesheet">

<!-- Erreur de remplissage d'un champ -->

<c:if test="${erreurChamp != null}">
    <br>
    <div class = "text-danger" role="alert">
            ${erreurChamp}
    </div>
    <br>
</c:if>

<c:if test ="${indicationChamp != null }">
    <br>
    <div class = "text-danger" role="alert">
            ${indicationChamp}
    </div>
    <br>
</c:if>

<!-- Inscription de l'utilisateur réussie -->

<c:if test ="${enregistrementReussi != null }">
    <br>
    <div class = "text-success" role="alert">
            ${enregistrementReussi}
    </div>
    <br>
</c:if>

<!-- Ajout réussi dans la base de données -->
<c:if test ="${ajoutReussi != null }">
    <br>
    <div class = "text-success" role="alert">
            ${ajoutReussi}
    </div>
    <br>
</c:if>

<!-- Utilisateur introuvable -->

<c:if test ="${erreurUtilisateurIntrouvable != null }">
    <br>
    <div class = "text-danger" role="alert">
            ${erreurUtilisateurIntrouvable}
    </div>
    <br>
</c:if>

<!-- Erreur de mdp lors de la suppression du compte -->

<c:if test ="${mdpDifferent != null }">
    <br>
    <div class = "text-danger" role="alert">
            ${mdpDifferent}
    </div>
    <br>
</c:if>