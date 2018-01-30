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
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="text" var="rb"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title><fmt:message key="user_info.title" bundle="${rb}"/> </title>

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
<c:if test="${ (empty userInfo) && (empty errorUserInfoIsEmpty) }">
    <script language="JavaScript" type="text/javascript">
        location="auction?command=user_info"
    </script>
</c:if>
<c:import url="../header.jsp"/>
<div class="container">
    <div class="row">

        <div class="col-md-offset-1 col-md-10 col-sm-offset-2 col-sm-8 col-xs-12 main">
            <c:import url="../navbar.jsp"/>
            <h2><fmt:message key="user_info.header" bundle="${rb}"/> </h2>
            <br>
            <c:if test="${ not empty errorUserInfoIsEmpty}">
                <div class="alert-danger alert">${errorUserInfoIsEmpty}</div>
            </c:if>
            <c:if test="${not empty userInfo}">

                <div class="form-group">
                    <label for="login"><fmt:message key="user_info.login" bundle="${rb}"/> </label>
                    <input type="text" class="form-control" id="login" name="login"  value="${userInfo.login}" readonly/>
                    <br>
                    <label for="email"><fmt:message key="user_info.email" bundle="${rb}"/></label>
                    <input type="email" class="form-control" id="email" name="email"  value="${userInfo.email}" readonly/>
                    <br>
                    <label for="fname"><fmt:message key="user_info.firstName" bundle="${rb}"/></label>
                    <input type="text" class="form-control" id="fname" name="fname" value="${userInfo.firstName}" readonly/>
                    <br>
                    <label for="lname"><fmt:message key="user_info.lastName" bundle="${rb}"/></label>
                    <input type="text" class="form-control" id="lname" name="lname" value="${userInfo.lastName}" readonly/>
                </div>
                <c:if test="${userInfo.id == userId}">
                    <div class="form-group">
                        <label for="money"><fmt:message key="user_info.money" bundle="${rb}"/> </label>
                        <input type="text" class="form-control" id="money" name="money" value="${userInfo.money}" readonly/>
                    </div>
                </c:if>
                <c:if test="${userInfo.id == userId}">
                    <div class="form-group">
                        <a href="auction?command=user_info_for_change" class="btn btn-primary pull-right" role="button"><fmt:message key="user_info.changeButton" bundle="${rb}"/></a>
                    </div>
                </c:if>
            </c:if>
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


