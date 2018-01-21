<%--
  Created by IntelliJ IDEA.
  User: panda
  Date: 5.12.17
  Time: 23.38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="text" var="rb"/>
<c:set var="isLogin" value="true"/>
<html>
<head>
    <link rel="stylesheet" href="bootstrap/bootstrap.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title><fmt:message key="title.login" bundle="${rb}"/></title>

</head>
<body>
<c:import url="header.jsp"/>
<main class="card-body bg-info w-50 offset-3">
    <div class="container ">
        <form action="controller" method="post">
            <input type="hidden" name="command" value="login">
            <div class="form-group">
                <label for="login"><fmt:message key="login.login" bundle="${rb}"/> </label>
                <input type="text" class="form-control" id="login" name="login">
            </div>
            <div class="form-group">
                <label for="password"><fmt:message key="login.password" bundle="${rb}"/> </label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <c:choose>
                <c:when test="${ not empty errorLoginPassMessage }">
                    <br/>
                    <span style="color: #ff0000;">${errorLoginPassMessage}</span>
                    <br/>
                    <br/>
                </c:when>
                <c:otherwise>
                    <br/>
                </c:otherwise>
            </c:choose>
            <button class="btn btn-primary" type="submit"><fmt:message key="login.submitButton"
                                                                       bundle="${rb}"/></button>
        </form>
    </div>
</main>
<c:import url="footer.jsp"/>
</body>
</html>
