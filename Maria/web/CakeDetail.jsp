<%-- 
    Document   : CakeDetail
    Created on : Jan 24, 2019, 12:27:53 AM
    Author     : kynhanht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cake Detail</title>
        <link rel="stylesheet" href="css/layout.css"/>
        <link rel="stylesheet" href="css/cakeDetail.css"/>
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="section">
                            <div class="content">
                                <div class="introduction-title">${cake.name}</div>
                                <div class="introduction-img">
                                    <img src="${cake.picture}">
                                </div>
                                ${cake.detailDescription}
                            </div>
                            <div class="cake-price">
                                Price: <span>${cake.price}$</span>
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
