<%-- 
    Document   : Share
    Created on : Jan 21, 2019, 12:49:13 AM
    Author     : kynhanht
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/share.css"/>

<div class="content-right">
    <div class="share-header">Share this page</div>
    <div class="share-content">
        <c:forEach var="x" items="${share}">
            <div>
                <a href="${x.url}"><img src="${x.icon}">Share on ${x.socialNetwork}</a>
            </div>
        </c:forEach>
    </div>
</div>

