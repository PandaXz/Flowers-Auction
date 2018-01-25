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
    <title><fmt:message key="main.title" bundle="${rb}"/> </title>

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
<c:if test="${ (empty auctionList) && (empty errorAuctionListIsEmpty) }">
    <script language="JavaScript" type="text/javascript">
        location="auction?command=actual_auction_list"
    </script>
</c:if>
<c:import url="../header.jsp"/>
<div class="container">
    <div class="row">

        <div class="col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12 main">
            <h2><fmt:message key="main.header" bundle="${rb}"/> </h2>
            <br>
            <c:if test="${ not empty errorAuctionListIsEmpty}">
                <div class="alert-danger alert">${errorAuctionListIsEmpty}</div>
            </c:if>
            <c:if test="${not empty auctionList}">
                <table class="table table-hover table-style">
                    <thead>
                        <tr>
                            <th><fmt:message key="main.start" bundle="${rb}"/></th>
                            <th><fmt:message key="main.end" bundle="${rb}"/></th>
                            <th><fmt:message key="main.description" bundle="${rb}"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${auctionList}" var="auction" varStatus="status">

                            <tr onclick="relocate('auction?command=auction_full&id=${auction.id}')">
                                <td><c:out value="${ auction.start }" /></td>
                                <td><c:out value="${ auction.end }" /></td>
                                <td><c:out value="${ auction.description }" /></td>

                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
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


