<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 25.01.2018
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recipies</title>
</head>
<body>
<h3>Recipies</h3>
<hr>
<form method="post" action="recipies/getByName">
    <dl>
        <dt>Искать рецепт по названию</dt>
        <dd><input type="text" name="name" value="${param.name}"></dd>
    </dl>
    <button type="submit">Искать</button>
</form>
<hr>
<form method="post" action="recipies/getByUser">
    <dl>
        <dt>Искать рецепт по автору</dt>
        <dd><input type="text" name="user" value="${param.user}"></dd>
    </dl>
    <button type="submit">Искать</button>
</form>
<hr>
<form method="post" action="recipies/getByIngredient">
    <dl>
        <dt>Искать рецепт по ингредиентам</dt>
        <dd><input type="text" name="ingredient" value="${param.ingredient}"></dd>
    </dl>
    <button type="submit">Искать</button>
</form>

<hr>
<a href="recipies/create">Добавить рецепт</a>
<hr>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>name</th>
        <th>description</th>
        <th>cookAlgorithm</th>
        <th>ingredients</th>
        <th>user.name</th>
        <th>rating</th>

    </tr>
    </thead>
    <c:forEach items="${recipies}" var="recipe">
        <jsp:useBean id="recipe" scope="page" type="ru.dartIt.model.Recipe"/>
        <tr>
            <td>${recipe.name}</td>
            <td>${recipe.description}</td>
            <td>${recipe.cookAlgorithm}</td>
            <td>
                <c:forEach items="${recipe.ingredients}" var="ingredient">
                    ${ingredient.name}
                </c:forEach>
            </td>
            <td>${recipe.user.name}</td>
            <td>${recipe.rating}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
