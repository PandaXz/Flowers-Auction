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
            <a class="navbar-brand" href="auction?command=accepted_lot_list"><fmt:message key="navbar.auction" bundle="${rb}"/></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <!--<li><a href="#">Link</a></li>-->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><fmt:message key="navbar.lots" bundle="${rb}"/> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="auction?command=user_lot_list&isBuyer=true"><fmt:message key="navbar.accepted" bundle="${rb}"/></a></li>
                        <li><a href="auction?command=user_lot_list&state=sold&isBuyer=true"><fmt:message key="navbar.bought" bundle="${rb}"/></a></li>
                        <li><a href="auction?command=user_lot_list&state=unpaid&isBuyer=true"><fmt:message key="navbar.unpaid" bundle="${rb}"/></a></li>

                        <!--<li role="separator" class="divider"></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>-->
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${not empty isAdmin}">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><fmt:message key="navbar.admin" bundle="${rb}"/> <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="auction?command=added_lots"><fmt:message key="navbar.added" bundle="${rb}"/></a></li>
                            <li><a href="auction?command=user_list"><fmt:message key="navbar.usedList" bundle="${rb}"/></a></li>
                            <li><a href="auction?command=add_flower"><fmt:message key="navbar.addFlower" bundle="${rb}"/></a></li>
                            <li><a href="auction?command=add_city"><fmt:message key="navbar.addCity" bundle="${rb}"/></a></li>

                            <!--<li role="separator" class="divider"></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">One more separated link</a></li>-->
                        </ul>
                    </li>
                </c:if>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><fmt:message key="navbar.userLots" bundle="${rb}"/><span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="auction?command=user_lot_list"><fmt:message key="navbar.accepted" bundle="${rb}"/></a></li>
                        <li><a href="auction?command=user_lot_list&state=sold"><fmt:message key="navbar.sold" bundle="${rb}"/></a></li>
                        <li><a href="auction?command=user_lot_list&state=denied"><fmt:message key="navbar.denied" bundle="${rb}"/></a></li>
                        <li><a href="auction?command=user_lot_list&state=added"><fmt:message key="navbar.added" bundle="${rb}"/></a></li>
                        <li><a href="auction?command=user_lot_list&state=unpaid"><fmt:message key="navbar.unpaid" bundle="${rb}"/></a></li>
                        <li><a href="auction?command=offer_info"><fmt:message key="navbar.offer" bundle="${rb}"/></a></li>
                        <!--<li role="separator" class="divider"></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>-->
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><c:out value="${user}"/> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="auction?command=user_info"><fmt:message key="navbar.info" bundle="${rb}"/></a></li>
                        <li><a href="auction?command=change_password"><fmt:message key="navbar.changePassword" bundle="${rb}"/></a></li>
                    </ul>
                </li>
                <li><a href="auction?command=logout">Logout</a></li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
