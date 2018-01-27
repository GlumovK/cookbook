<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>




<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Catalog name</th>

    </tr>
    </thead>
    <c:forEach items="${catalogs}" var="catalog">
        <jsp:useBean id="catalog" scope="page" type="ru.dartIt.model.Catalog"/>
        <tr>
            <td> <a href="catalogs/getByRecipe" >${catalog.name}</a></td>
        </tr>
    </c:forEach>
</table>

<%----%>
</body>
</html>
