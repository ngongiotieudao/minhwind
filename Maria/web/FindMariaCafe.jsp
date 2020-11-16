<%-- 
    Document   : FindMariaCafe
    Created on : Jan 24, 2019, 12:37:53 AM
    Author     : kynhanht
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Find Maria Cafe</title>
        <link rel="stylesheet" href="css/layout.css"/>
        <link rel="stylesheet" href="css/findMariaCafe.css"/>
    </head>
    <body>
        <div class="site-wrapper">
            <jsp:include page="Header.jsp"/>
            <div class="content-wrapper">
                <div class="container">
                    <div class="content-left">
                        <div class="section">
                            <div class="content">
                                <div class="introduction-title">Find Maria's Cafe</div>
                                <ul>
                                    <li class="item">
                                        <div class="content-title">Address and contact:</div>
                                        <div>${information.address}</div>
                                        <br>
                                        <div><span>Tel:</span><a href="#" class="keepHightLight-link">${information.tel}</a></div>
                                        <br>
                                        <div><span>Email:</span><a href="#" class="keepHightLight-link">${information.email}</a></div>                                     
                                    </li>
                                    <li class="item">
                                        <div class="content-title">Opening hours:</div>
                                        <div>
                                            ${information.openingHours}
                                        </div>
                                    </li>
                                </ul>
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
