<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Devinette</title>
    <jsp:include page="../../includes/head.jsp" />
</head>
<body>
<h1>${riddle.getRiddle()}</h1>
<form action="answer" method="post">
    <div class="form-row">
       <div class="form-group col-md-12">
            <label for="useranswer">Réponse</label>
            <input type="text" class="form-control" id="useranswer" name="useranswer" >
        </div>
    </div>
    <button type="submit" class="btn btn-primary" name="id" value="${riddle.getId()}">Proposer</button>
</form>

</body>
</html>
