<%--
  Created by IntelliJ IDEA.
  User: panda
  Date: 30.1.18
  Time: 0.38
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
    <title><fmt:message key="offer-lot.title" bundle="${rb}"/></title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link href="css/dopstyle.css" rel="stylesheet">
    <script src="../../js/main.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<c:if test="${ (empty flowerList)||(empty cityList)}">
    <script language="JavaScript" type="text/javascript">
        location = "auction?command=offer_info"
    </script>
</c:if>
<c:import url="../header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-offset-2 col-md-8 col-sm-12 col-xs-12 main">
            <c:import url="../navbar.jsp"/>
            <h2><fmt:message key="offer-lot.header" bundle="${rb}"/></h2>
            <br>
            <form action="auction" method="post" enctype="multipart/form-data" accept-charset="utf-8">
                <input type="hidden" name="command" value="offer_lot">


                <div class="form-group">
                    <label for="flowerId"><fmt:message key="offer-lot.flower" bundle="${rb}"/></label>
                    <select class="form-control" id="flowerId" name="flowerId" required>
                        <c:forEach items="${flowerList}" var="flower">
                            <option value="${flower.id}"><c:out value="${flower.name}"/></option>
                        </c:forEach>
                    </select>
                    <br>
                    <div class="row">
                        <div class="col-md-5 col-xs-12">
                            <label for="cityId"><fmt:message key="offer-lot.city" bundle="${rb}"/></label>
                            <select class="form-control" id="cityId" name="cityId" required>
                                <c:forEach items="${cityList}" var="city">
                                    <option value="${city.id}"><c:out value="${city.name}"/></option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-5 col-xs-8">
                            <label for="street"><fmt:message key="offer-lot.street" bundle="${rb}"/> </label>
                            <input type="text"  class="form-control" id="street" name="street" pattern="^[\wА-Яа-я-]+$" required>
                        </div>
                        <div class="col-md-2 col-xs-4">
                            <label for="number"><fmt:message key="offer-lot.number" bundle="${rb}"/> </label>
                            <input onload="now(this)" type="number" min="0" class="form-control" id="number" name="houseNumber" required>
                        </div>
                    </div>
                    <label for="img"><fmt:message key="offer-lot.image" bundle="${ rb }" /></label>
                    <input type="file" class="form-control" id="img" accept="image/jpeg" name="img" required>
                    <br>
                    <label for="price"><fmt:message key="offer-lot.price" bundle="${rb}"/> </label>
                    <input type="number" step="0.01" min="0" class="form-control" id="price" name="price" required>
                    <br>
                    <label for="count"><fmt:message key="offer-lot.count" bundle="${rb}"/> </label>
                    <input type="number" min="0" class="form-control" id="count" name="count" required>
                    <br>
                    <label for="end"><fmt:message key="offer-lot.end" bundle="${rb}"/></label>
                    <input type="datetime-local" class="form-control" id="end" name="end" required/>
                    <br>
                    <label for="description"><fmt:message key="offer-lot.description" bundle="${rb}"/></label>
                    <textarea class="form-control" rows="3" name="description" id="description" required></textarea>
                </div>
                <ct:ctg errorMessage="${errorOfferLotMessage}"/>
                <button class="btn btn-primary btn-block" type="submit"><fmt:message key="offer-lot.submitButton"
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


