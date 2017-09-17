<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/3/30
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>公告列表</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>

<div class="container">
    <br>

    <div id="aform">
        <%--<form action="<c:url value='/queryAffiche'/> " method="post" class="form-inline">--%>
        <form action="#" method="post" class="form-inline">

            <div class="form-group">
                <label for="atitle">标题</label>
                <input type="text" name="afficheTitle" class="form-control" id="atitle" style="width: 200px;">
            </div>
            <div class="form-group">
                <label for="amember">发布者</label>
                <input type="text" name="memberName" class="form-control" id="amember" style="width: 80px;" >
            </div>
            <div class="form-group">
                <label for="atime">发布时间</label>
                <input type="text" name="publicTime" class="form-control" id="atime" style="width: 120px">
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="status" value="1" checked>
                    发布
                </label>
            </div>
            <div class="radio">
                <label>
                    <input type="radio" name="status" value="0">
                    删除
                </label>
            </div>
            <button type="submit" class="btn btn-primary">查询</button>
        </form>
    </div>

    <div id="alist">
        <table class="table table-bordered table-hover">

            <tr>
                <td>标题</td>
                <td>发布时间</td>
                <td>发布人</td>
                <td>附件</td>
                <td>操作</td>
            </tr>
<c:forEach items="${affichePage.datas}" var="affiche">
            <tr>
                <fmt:formatDate value="${affiche.publicTime}" pattern="yyyy-MM-dd HH:mm:ss" var="publicTime"/>
                <td><a href="<c:url value='/queryAfficheContent/${affiche.afficheId}'/> ">${affiche.afficheTitle}</a> </td>
                <td>${publicTime}</td>
                <td style="width: 65px;">${affiche.memberName}</td>
                <td style="width: 50px;">
                    <c:choose>
                        <c:when test="${affiche.attachfileId eq null}">
                            无
                        </c:when>
                        <c:otherwise>
                            有
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="<c:url value='/updateAffiche/${affiche.afficheId}'/> " class="btn btn-info active" role="button" style="width: 40%;">修改</a>
                    <a href="<c:url value='/deleteAffiche/${affiche.afficheId}'/> " onclick="return confirm('确定删除该公告？')" class="btn btn-danger active" role="button" style="width: 40%;">删除</a>
                        <%--<a href="#">修改</a>--%>
                        <%--<a href="#">删除</a>--%>
                </td>
            </tr>
</c:forEach>
        </table>
    </div>
</div>

<div><%@include file="page.jsp"%></div>

</body>
</html>
