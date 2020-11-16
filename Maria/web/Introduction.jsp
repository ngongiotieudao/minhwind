<%-- 
    Document   : Introduction
    Created on : Jan 20, 2019, 7:01:37 PM
    Author     : kynhanht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Introduction</title>
        <link rel="stylesheet" href="css/layout.css"/>
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="section">
                            <div class="content">
                                <div class="introduction-title">${introduction.title}</div>
                                <div class="introduction-img">
                                    <img src="${introduction.picture}">
                                </div>
                                ${introduction.detailDescription}
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
