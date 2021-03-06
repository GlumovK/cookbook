<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="dartIt" tagdir="/WEB-INF/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<div class="jumbotron">
    <div class="container">
        <%--@elvariable id="userTo" type="ru.javawebinar.topjava.to.UserTo"--%>
        <h2>${userTo.name}${register ? 'register' : 'profile'}</h2>
        <form:form modelAttribute="userTo" class="form-horizontal" method="post"
                   action="${register ? 'register' : 'profile'}"
                   charset="utf-8" accept-charset="UTF-8">
            Name
            <Name var="userName"/>
            <dartIt:inputField label='${userName}' name="name"/>
            Email
            <Email var="userEmail"/>
            <dartIt:inputField label='${userEmail}' name="email"/>
            Password
            <Password var="userPassword"/>
            <dartIt:inputField label='${userPassword}' name="password" inputType="password"/>
            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                    <button type="submit" class="btn btn-primary">
                        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                    </button>
                </div>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>