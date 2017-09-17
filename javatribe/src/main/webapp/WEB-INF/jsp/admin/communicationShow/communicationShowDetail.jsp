<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/4/8
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>交流会风采详情</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>

    <div class="container">
        <br>
        <h4 align="center" style="color: #337ab7;">${communicationMeeting.meetingTitle}</h4>
        <hr>
        <div align="left" style="color: #dd1144;">时间：${communicationMeeting.meetingDate}</div>
        <div align="left" style="color: #dd1144;">地点：${communicationMeeting.meetingAddress}</div>
        <br>
        <div align="center">${communicationMeeting.meetingTheme}</div>
        <br><br>
        <div align="right" style="color: #337ab7;">编辑者：${communicationMeeting.memberName}</div>
        <fmt:formatDate value="${communicationMeeting.edittime}" pattern="yyyy-MM-dd HH:mm:ss" var="edittime"></fmt:formatDate>
        <div align="right" style="color: #337ab7;">编辑时间：${edittime}</div>
    </div>

</body>
</html>
