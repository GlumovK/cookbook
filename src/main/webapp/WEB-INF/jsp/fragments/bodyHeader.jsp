<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--<header><a href="${pageContext.request.contextPath}/">Home</a>&nbsp;|&nbsp;<a href="recipies">Cookbook</a></header>--%>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <a href="meals" class="navbar-brand">Cookbook</a>

        <div class="collapse navbar-collapse">
            <form class="navbar-form navbar-right">
                <%--<a class="btn btn-info" href="recipies">Recipies</a>--%>

                <a class="btn btn-primary" href="logout">
                    <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                </a>
            </form>
        </div>
    </div>
</div>