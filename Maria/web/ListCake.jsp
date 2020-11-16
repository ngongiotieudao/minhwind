<%-- 
    Document   : ListCake
    Created on : Feb 10, 2019, 11:22:38 PM
    Author     : kynhanht
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Cake</title>
        <link rel="stylesheet" href="css/layout.css"/>
        <link rel="stylesheet" href="css/listCake.css"/>
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <ul class="list-item">
                            <c:forEach var="x" items="${cakes}">
                                <c:url value="CakeDetailController" var="cakeDetail">
                                    <c:param name="id" value="${x.id}"/>
                                </c:url>
                                <li class="each-item">
                                    <div class="content">
                                        <div class="img">
                                            <a href="${cakeDetail}"><img src="${x.picture}"></a>
                                        </div>
                                        <p class="content-title">${x.name}</p>
                                        ${x.shortDescription}
                                    </div>                                                               
                                </li>
                            </c:forEach>
                        </ul>
                        <div class="page" id="page">
                            <c:forEach var="i" begin="1" end="${pages}">
                                <c:url var="listCake" value="ListCakeController">
                                    <c:param name="page" value="${i}"/>
                                </c:url>
                                <c:choose>
                                    <c:when test="${page==i}">
                                        <a href="${listCake}" class="disabled-link">${i}</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="${listCake}">${i}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>
                    </div>
                    <jsp:include page="Share.jsp"/>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
