<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>


<section>
    <jsp:useBean id="recipe" type="ru.dartIt.model.Recipe" scope="request"/>
    <h3>Добавить рецепт</h3>
    <hr>
    <form method="post" action="recipies">
        <input type="hidden" name="id" value="${recipe.id}">
        <dl>
            <dt>Название</dt>
            <dd><input type="text" value="${recipe.name}" name="name" required></dd>
        </dl>
        <dl>
            <dt>Описание</dt>
            <dd><input type="text" value="${recipe.description}" name="description" required></dd>
        </dl>
        <dl>
            <dt>Алгоритм приготовления</dt>
            <dd><input type="text" value="${recipe.cookAlgorithm}" name="cookAlgorithm" required></dd>
        </dl>
        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()" type="button">Отмена</button>
    </form>
</section>
</body>
</html>
