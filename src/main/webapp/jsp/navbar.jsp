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
<nav class="navbar navbar-color navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="auction?command=accepted_lot_list">Auction</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="auction?command=offer_info">Offer lot</a></li>
                <!--<li><a href="#">Link</a></li>-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Lots <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="auction?command=user_lot_list&isBuyer=true">Accepted lots</a></li>
                        <li><a href="auction?command=user_lot_list&state=sold&isBuyer=true">Bought lots</a></li>
                        <li><a href="auction?command=user_lot_list&state=unpaid&isBuyer=true">Unpaid lots</a></li>
                        <!--<li role="separator" class="divider"></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>-->
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${not empty isAdmin}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="auction?command=added_lots">Added lots</a></li>
                            <!--<li role="separator" class="divider"></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">One more separated link</a></li>-->
                        </ul>
                    </li>
                </c:if>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">My Lots <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="auction?command=user_lot_list">Accepted lots</a></li>
                        <li><a href="auction?command=user_lot_list&state=sold">Sold lots</a></li>
                        <li><a href="auction?command=user_lot_list&state=denied">Denied lots</a></li>
                        <li><a href="auction?command=user_lot_list&state=added">Added lots</a></li>
                        <li><a href="auction?command=user_lot_list&state=unpaid">Unpaid lots</a></li>
                        <!--<li role="separator" class="divider"></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>-->
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><c:out value="${user}"/> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="auction?command=user_info">Info</a></li>
                        <li><a href="auction?command=forward&page=change_password">Change password</a></li>
                    </ul>
                </li>
                <li><a href="auction?command=logout">Logout</a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
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