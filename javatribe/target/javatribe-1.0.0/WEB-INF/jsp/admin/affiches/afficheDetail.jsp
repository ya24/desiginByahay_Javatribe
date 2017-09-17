<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/4/1
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>公告详情</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>

<div class="container">
    <h2 align="center">${affiche.afficheTitle}</h2><br>
    <h6 align="center">
        <fmt:formatDate value="${affiche.publicTime}" pattern="yyyy-MM-dd HH:mm:ss" var="publicTime"/>
        ${publicTime}
    </h6><br>
    <div align="center">${affiche.afficheContent}</div><br>
    <div align="right">发布者：${affiche.memberName}</div><br>
    <c:choose>
        <c:when test="${affiche.attachfileId ne null}">
            附件：<a href="<c:url value='/loadAttachFile/${attachfile.attachfileId}'/> ">${attachfile.attachfileName}</a>
        </c:when>
    </c:choose>
</div>

</body>
</html>
