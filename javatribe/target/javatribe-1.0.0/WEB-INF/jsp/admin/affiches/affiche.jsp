<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/3/27
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>公告管理页</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>
<div class="container">
    <shiro:hasPermission name="affiche:create">
        <a href="<c:url value='/createAffiche'/> ">发布公告</a>
    </shiro:hasPermission>

    <shiro:hasPermission name="affiche:query">
        <a href="<c:url value='/queryAffiche/1'/> ">公告查询</a>
    </shiro:hasPermission>

    <%--<shiro:hasPermission name="affiche:query">--%>
        <%--<a href="<c:url value='/showFormForqueryAfficheBy'/> ">公告条件查询</a>--%>
    <%--</shiro:hasPermission>--%>


    <%--<ul class="nav nav-tabs">--%>
        <%--<li role="presentation" >--%>
            <%--<a href="#">公告列表</a>--%>
        <%--</li>--%>
        <%--<li role="presentation" class="active">--%>
            <%--<a href="#">发布公告</a>--%>
        <%--</li>--%>
    <%--</ul>--%>

    <%--<div id="affiche_list">--%>

    <%--</div>--%>

    <%--<div id="affiche_create">--%>

    <%--</div>--%>



</div>

</body>
</html>
