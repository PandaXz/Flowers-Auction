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
        <h1 class>Flowers Auction</h1>

    </div>
</div>
