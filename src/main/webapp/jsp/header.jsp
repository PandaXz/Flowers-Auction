<%--
  Created by IntelliJ IDEA.
  User: panda
  Date: 6.12.17
  Time: 20.23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="text" var="rb"/>
<div class="header">
    <div class="row">
        <div class="btn-group-xs pull-right" role="group">
            <a href="auction?command=English_language" class="btn btn-xs btn-default" role="button">Eng</a>
            <a href="auction?command=Russian_language" class="btn btn-xs btn-default" role="button">Рус</a>

        </div>
        <h1 class>Flowers Auctions</h1>

    </div>
</div>

<!--<header class="bg-dark">
    <div class="card-body ">
        <div class="btn-group-sm row">
            <form action="controller">
                <input type="hidden" name="command" value="English_language">
                <button class="btn" type="submit">Eng</button>
            </form>
            <form action="controller">
                <input type="hidden" name="command" value="Russian_language">
                <button class="btn" type="submit">Рус</button>
            </form>
            <c:if test="${not empty iduser && empty isLogin}">
                <form action="controller">
                    <input type="hidden" name="command" value="LOGOUT">
                    <button class="btn" type="submit"><fmt:message key="header.logout" bundle="${rb}"/></button>
                </form>
            </c:if>
        </div>
    </div>
    <nav class="navbar navbar-dark">
        <div class="container-fluid">
            <div class="header-content">

            </div>
        </div>
    </nav>
</header>
-->