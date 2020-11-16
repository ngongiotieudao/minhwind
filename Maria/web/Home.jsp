<%-- 
    Document   : Home1
    Created on : Jan 20, 2019, 9:52:00 PM
    Author     : kynhanht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/layout.css"/>
        <link rel="stylesheet" href="css/home.css"/>
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="section intro">
                            <div class="content">
                                <div class="img">
                                    <a href="IntroductionController"><img src="${introduction.picture}"></a>
                                </div>
                                <div class="content-title">
                                    <a href="IntroductionController">${introduction.title}</a>
                                </div>
                                <p>${introduction.shortDescription}</p>
                            </div>
                        </div>
                        <div class="section">
                            <div class="content">
                                <ul>
                                    <c:forEach var="x" items="${cakes}">
                                        <c:url var="cakeDetail" value="CakeDetailController">
                                            <c:param name="id" value="${x.id}"/>
                                        </c:url>
                                        <li>
                                            <div class="img">
                                                <a href="${cakeDetail}"><img src="${x.picture}"></a>
                                            </div>
                                            <div class="content-title">
                                                <a href="${cakeDetail}">${x.name}</a>
                                            </div>
                                            <p>${x.shortDescription}</p>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <div class="section">
                            <div class="content">
                                <div class="content-title">Visit my cafe</div>
                                <p>${information.shortDescription}</p>
                                <p>${information.address}</p>
                                <p>${information.tel}</p>
                            </div>
                        </div>
                        <div class="section">
                            <div class="content">
                                Kind regards<br/>
                                <div class="signature">Maria Bagnarelli</div>
                            </div>
                        </div>
                    </div>
                    <jsp:include page="Share.jsp"/>
                </div>
            </div>
            <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
