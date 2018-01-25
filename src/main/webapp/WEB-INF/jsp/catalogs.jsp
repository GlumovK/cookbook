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
    <title>Catalog</title>
</head>
<body>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>

    </tr>
    </thead>
    <c:forEach items="${catalogs}" var="catalog">
        <jsp:useBean id="catalog" scope="page" type="ru.dartIt.model.Catalog"/>
        <tr>
            <td>${catalog.name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
