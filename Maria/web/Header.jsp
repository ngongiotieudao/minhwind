<%-- 
    Document   : Header1
    Created on : Jan 20, 2019, 9:31:20 PM
    Author     : kynhanht
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/header.css"/>
        <link rel="stylesheet" href="css/layout.css">
        <%--<script type="text/javascript" src="js/script.js"></script>--%>
    </head>
    <body>
        <div class="header-wrapper">
            <div class="container">
                <div class="title-wrapper">
                    <div class="header-title">
                        Maria Bagnarelli's Cafe
                    </div>
                    <div class="sub-subtitle">
                        Welcome to my website
                    </div>
                </div>
                <div class="navbar">
                    <ul class="nav">
                         <c:choose>
                            <c:when test="${currentPage==0}">
                                <li><a href="HomeController" class="keepHightLight-link">Home</a></li>
                                <li><a href="ListCakeController">About my Cakes</a></li>
                                <li><a href="FindMariaCafeController">Find us</a></li>
                            </c:when>
                            <c:when test="${currentPage==1}">
                                <li><a href="HomeController">Home</a></li>
                                <li><a href="ListCakeController" class="keepHightLight-link">About my Cakes</a></li>
                                <li><a href="FindMariaCafeController">Find Maria's Cafe</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="HomeController">Home</a></li>
                                <li><a href="ListCakeController">About my Cakes</a></li>
                                <li><a href="FindMariaCafeController" class="keepHightLight-link">Find Maria's Cafe</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
    </body>
</html>

