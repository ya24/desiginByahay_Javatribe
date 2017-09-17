<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/4/8
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>交流会风采展览</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>

    <div class="container">
        <h2 align="center">交流会风采展览</h2>
        <br>

        <table class="table table-bordered table-hover" align="center">
            <tr>
                <td>交流会标题</td>
                <td>交流会时间</td>
                <td>交流会地点</td>
                <td style="width: 65px;">编辑者</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${communicationMeetingPage.datas}" var="communicationMeeting">
            <tr>
                <td><a href="<c:url value='/communicationShowDetail/${communicationMeeting.meetingId}'/> ">${communicationMeeting.meetingTitle}</a> </td>
                <td>${communicationMeeting.meetingDate}</td>
                <td>${communicationMeeting.meetingAddress}</td>
                <td style="width: 65px;">${communicationMeeting.memberName}</td>
                <td>
                    <a href="<c:url value='/updateCommunicationShow/${communicationMeeting.meetingId}'/> " class="btn btn-info active" role="button">修改</a>
                    <a href="<c:url value='/deleteCommunicationShow/${communicationMeeting.meetingId}'/> " class="btn btn-danger active" role="button" onclick="return confirm('确定要删除吗？');">删除</a>
                </td>
            </tr>
            </c:forEach>
        </table>

    </div>
    <div><%@include file="page.jsp"%></div>

</body>
</html>
