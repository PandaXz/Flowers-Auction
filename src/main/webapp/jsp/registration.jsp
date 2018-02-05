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
<c:set var="isLogin" value="true"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title><fmt:message key="registration.title" bundle="${rb}"/> </title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="css/dopstyle.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<c:import url="header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12 main">
            <h2><fmt:message key="registration.header" bundle="${rb}"/> </h2>
            <br>
            <form action="auction" method="post" onsubmit="return validatePasswordRepeat()">
                <input type="hidden" name="command" value="signUp">
                <div class="form-group">
                    <label for="login"><fmt:message key="registration.login" bundle="${rb}"/> </label>
                    <input type="text" class="form-control" id="login" name="login" pattern="^[A-Za-z][A-Za-z_]*$" required>
                    <br>
                    <label for="password"><fmt:message key="registration.password" bundle="${rb}"/> </label>
                    <input type="password" class="form-control" id="password" name="password" pattern="^\w+$" required>
                    <br>
                    <label for="passwordRepeat"><fmt:message key="registration.passwordRepeat" bundle="${rb}"/></label>
                    <input type="password" class="form-control" id="passwordRepeat" name="passwordRepeat" pattern="^\w+$"  required/>
                    <br>
                    <label for="email"><fmt:message key="registration.email" bundle="${rb}"/></label>
                    <input type="email" class="form-control" id="email" name="email"  pattern="^[\w\.]+@\w+\.\w+$" required/>
                    <br>
                    <label for="fname"><fmt:message key="registration.firstName" bundle="${rb}"/></label>
                    <input type="text" class="form-control" id="fname" name="fname" pattern="^[A-Za-zА-Яа-я]*$" required/>
                    <br>
                    <label for="lname"><fmt:message key="registration.lastName" bundle="${rb}"/></label>
                    <input type="text" class="form-control" id="lname" name="lname" pattern="^[A-Za-zА-Яа-я]*$" required />
                </div>
                <a href="auction?command=forward&page=login" class="label-notification" role="button"><fmt:message key="registration.hasAccount" bundle="${rb}"/></a>
                <ct:ctg errorMessage="${errorRegistrationMessage}"/>
                <button class="btn btn-primary btn-block" type="submit"><fmt:message key="registration.submitButton"
                                                                                      bundle="${rb}"/></button>
            </form>
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>


