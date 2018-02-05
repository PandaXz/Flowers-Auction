<%--
  Created by IntelliJ IDEA.
  User: panda
  Date: 31.1.18
  Time: 23.28
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
    <title><fmt:message key="added-lots.title" bundle="${rb}"/></title>

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
<c:if test="${ (empty lotList) && (empty errorLotListIsEmpty) }">
    <script language="JavaScript" type="text/javascript">
        location = "auction?command=added_lots"
    </script>
</c:if>
<c:import url="../header.jsp"/>
<div class="container">
    <div class="row">

        <div class="col-md-offset-1 col-md-10 col-sm-12 col-xs-12 main">
            <c:import url="../navbar.jsp"/>
            <h2><fmt:message key="added-lots.header" bundle="${rb}"/></h2>
            <br>
            <ct:ctg errorMessage="${errorLotListIsEmpty}"/>
            <c:if test="${not empty lotList}">
                <div class="table-responsive">
                    <table class="table table-hover table-style">
                        <thead>
                        <tr>
                            <th><fmt:message key="added-lots.owner" bundle="${rb}"/></th>
                            <th><fmt:message key="added-lots.flowerName" bundle="${rb}"/></th>
                            <th><fmt:message key="added-lots.end" bundle="${rb}"/></th>
                            <th><fmt:message key="added-lots.count" bundle="${rb}"/></th>
                            <th><fmt:message key="added-lots.price" bundle="${rb}"/></th>
                            <th><fmt:message key="added-lots.state" bundle="${rb}"/></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${lotList}" var="lot" varStatus="status">

                            <tr onclick="relocate('auction?command=lot_full&id=${lot.id}')">
                                <td><a href="auction?command=user_info&id=${lot.ownerId}"><c:out value="${lot.owner}"/></a></td>
                                <td><c:out value="${ lot.flowerName }"/></td>
                                <td><c:out value="${lot.end.toLocalDate()} ${lot.end.toLocalTime()}"/></td>
                                <td><c:out value="${ lot.count }"/></td>
                                <td><c:out value="${ lot.currentPrice }"/></td>
                                <td>
                                    <label class="label label-info"><c:out value="${lot.state}"/></label>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
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



