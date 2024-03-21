<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:if test="${erreurChamp != null}">
    <div class = "alert alert-info" role="alert">
            ${erreurChamp}
    </div>
</c:if>
<c:if test ="${enregistrementReussi != null }">
    <div class = "alert alert-reussite" role="alert">
            ${enregistrementReussi}
    </div>
</c:if>