<%--
  Created by IntelliJ IDEA.
  User: panda
  Date: 21.1.18
  Time: 21.40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="ct" uri="/WEB-INF/errorTag" %>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title><fmt:message key="change-password.title" bundle="${rb}"/> </title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="css/dopstyle.css" rel="stylesheet">
    <script src="js/main.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<c:import url="../header.jsp"/>
<div class="container">
    <div class="row">

        <div class="col-md-offset-1 col-md-10 col-sm-12 col-xs-12 main">
            <c:import url="../navbar.jsp"/>
            <h2><fmt:message key="change-password.header" bundle="${rb}"/> </h2>
            <br>
            <form action="auction" method="post">
                <input type="hidden" name="command" value="change_password">

                <div class="form-group">
                    <label for="password"><fmt:message key="change-password.password" bundle="${rb}"/> </label>
                    <input type="password" class="form-control" id="password" name="password" pattern="^\w+$" required>
                    <br>
                    <label for="passwordRepeat"><fmt:message key="change-password.passwordRepeat" bundle="${rb}"/></label>
                    <input type="password" class="form-control" id="passwordRepeat" name="passwordRepeat" pattern="^\w+$"  required/>
                </div>
                <ct:ctg errorMessage="${errorChangeMessage}"/>
                <c:if test="${ not empty successChangeMessage }">
                    <div class="alert-success alert"><c:out value="${successChangeMessage}"/></div>

                </c:if>
                <button class="btn btn-primary btn-block" type="submit"><fmt:message key="change-password.submitButton"
                                                                                     bundle="${rb}"/></button>
            </form>
        </div>
    </div>
</div>
<c:import url="../footer.jsp"/>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>


