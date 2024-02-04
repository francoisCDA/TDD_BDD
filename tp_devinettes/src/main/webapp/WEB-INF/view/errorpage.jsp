<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Erreur</title>
    <jsp:include page="../../includes/head.jsp" />
</head>
<body>
<h1>Erreur</h1>
<p>Message : ${error}</p>

<a href="riddle" class="btn btn-primary">Retour à l'accueil</a>

</body>
</html>
