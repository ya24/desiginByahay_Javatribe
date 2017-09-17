<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/3/24
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>考核人员列表</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>
<div class="container">
    <h2 align="center">爪哇部落考核人员</h2>
    <table class="table table-bordered table-hover text-center" style="width:770px;">
        <tr>
            <td>编号</td>
            <td>年级</td>
            <td>姓名</td>
            <td>手机</td>
            <td>短号</td>
            <td>微信</td>
            <td>QQ</td>
            <td>角色</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${memberInfoPage.datas}" var="memberInfo">
            <tr>
                <td>${memberInfo.memberId}</td>
                <td>${memberInfo.gradeName}</td>
                <td>${memberInfo.memberName}</td>
                <td>${memberInfo.phoneNumber}</td>
                <td>${memberInfo.shortPhoneNumber}</td>
                <td>${memberInfo.wechat}</td>
                <td>${memberInfo.qq}</td>
                <td>${memberInfo.roleName}</td>
                <td>
                    <a href="<c:url value='/updateMembers/${memberInfo.memberId}'/> " class="btn btn-info active" role="button">修改</a>
                    <a href="<c:url value='/removeMembers/${memberInfo.memberId}'/> " class="btn btn-danger active" role="button" onclick="return confirm('确定删除该成员？')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <%@include file="page.jsp"%>
</div>

</body>
</html>
