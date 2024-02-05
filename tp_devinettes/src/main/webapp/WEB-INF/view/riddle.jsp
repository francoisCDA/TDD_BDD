<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Devinettes</title>
    <jsp:include page="../../includes/head.jsp" />

</head>
<body>

<h1>Listes des devinettes</h1>

<div class="container align-self-center">
    <div class="row">
        <div class="col-8 ">
            <table class="table table-dark">
                <thead>
                    <tr>
                        <th scope="col">Devinettes</th>
                        <th scope="col">Proposer une réponse</th>
                        <th scope="col">Historique des réponses</th>
                    </tr>
                </thead>
                <body>
                <c:choose>
                    <c:when test="${not empty riddles}">
                        <c:forEach items="${riddles}" var="riddle">
                            <tr>
                                <td>${riddle.getRiddle()}</td>
                                <td>
                                    <a class="btn btn-primary" href="answer?id=${riddle.getId()}" >Répondre</a>
                                </td>
                                <td>
                                    <a class="btn btn-info" href="answer?id=${riddle.getId()}" >Ouvrir</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr><td colspan="3">Aucune devinette enregristrée</td></tr>
                    </c:otherwise>
                </c:choose>
                </body>
            </table>
        </div>
    </div>
    <h2>Proposer une devinette</h2>
        <form action="riddle" method="post">
            <div class="form-row">
                <div class="form-group col-md-12">
                    <textarea  class="form-control" id="question" name="question" rows="5" placeholder="Ecrivez votre devinette ici..."></textarea>
                </div>
                <div class="form-group col-md-12">
                    <label for="answer">Réponse</label>
                    <input type="text" class="form-control" id="answer" name="answer" >
                </div>
             </div>
            <button type="submit" class="btn btn-primary">Envoyer</button>
        </form>

    </div>

</div>



</body>
</html>
