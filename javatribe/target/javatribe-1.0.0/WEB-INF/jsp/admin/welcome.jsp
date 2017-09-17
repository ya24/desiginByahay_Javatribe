<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/3/20
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>后台首页</title>
    <base target="body">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
    <style>
        #main-nav {
            margin-left: 1px;
        }

        #main-nav.nav-tabs.nav-stacked > li > a {
            padding: 10px 8px;
            font-size: 12px;
            font-weight: 600;
            color: #4A515B;
            background: #E9E9E9;
            background: -moz-linear-gradient(top, #FAFAFA 0%, #E9E9E9 100%);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FAFAFA), color-stop(100%,#E9E9E9));
            background: -webkit-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
            background: -o-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
            background: -ms-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
            background: linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9');
            -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9')";
            border: 1px solid #D5D5D5;
            border-radius: 4px;
        }
        #main-nav.nav-tabs.nav-stacked > li.active > a, #main-nav.nav-tabs.nav-stacked > li > a:hover {
            color: #FFF;
            background: #3C4049;
            background: -moz-linear-gradient(top, #4A515B 0%, #3C4049 100%);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#4A515B), color-stop(100%,#3C4049));
            background: -webkit-linear-gradient(top, #4A515B 0%,#3C4049 100%);
            background: -o-linear-gradient(top, #4A515B 0%,#3C4049 100%);
            background: -ms-linear-gradient(top, #4A515B 0%,#3C4049 100%);
            background: linear-gradient(top, #4A515B 0%,#3C4049 100%);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049');
            -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049')";
            border-color: #2B2E33;
        }

        #main-nav.nav-tabs.nav-stacked > li.active > a, #main-nav.nav-tabs.nav-stacked > li > a:hover > span {
            color: #FFF;
        }

        #main-nav.nav-tabs.nav-stacked > li {
            margin-bottom: 4px;
        }

        /*定义二级菜单样式*/
        .secondmenu a {
            font-size: 12px;
            color: #4A515B;
            text-align: left;
        }

        .navbar-static-top {
            background-color: #212121;
            margin-bottom: 5px;
        }
    </style>
    <script type="text/javascript">
         function logout() {
            location.href = "${pageContext.request.contextPath}/logout";
        }
    </script>
</head>
<body style="padding-top: 70px;">
    <div class="container" id="navbar">
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <h1>爪哇部落后台管理系统</h1>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li style="line-height: 50px;">当前用户：${user.userName}</li>
                        <%--<li><a href="${pageContext.request.contextPath}/logout">退出系统</a></li>--%>
                        <li style="line-height: 50px; padding-left: 25px;" onclick="javascript:logout();">退出系统</li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>

    <div class="container" id="menu" style="width: 20%; float: left;">
        <!-- 菜单栏-->
        <ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
            <c:forEach items="${user.menusList}" var="menu">
                <li>
                    <a href="#${menu.permissionId}" class="nav-header collapsed" data-toggle="collapse">
                            ${menu.permissionName}
                        <span class="pull-right glyphicon glyphicon-chevron-down"></span>
                    </a>

                    <ul id="${menu.permissionId}" class="nav nav-list collapse secondmenu" style="height: 0px;">
                        <c:forEach items="${menu.childMenus}" var="childMenu">
                            <c:choose>
                                <c:when test="${childMenu.url eq '/queryExamineMembers' or childMenu.url eq '/queryMembers'}">
                                    <c:set var="url" value="${childMenu.url}/1"></c:set>
                                </c:when>
                                <c:otherwise>
                                    <c:set var="url" value="${childMenu.url}"></c:set>
                                </c:otherwise>
                            </c:choose>

                            <li><a href="<c:url value='${url}'/> ">${childMenu.permissionName}</a></li>

                        </c:forEach>
                            <%--<li><a href="#">考核人员查询</a></li>--%>
                            <%--<li><a href="#">成员添加</a></li>--%>
                            <%--<li><a href="#">成员更新</a></li>--%>
                            <%--<li><a href="#">成员移除</a></li>--%>
                    </ul>

                </li>
            </c:forEach>
            <%--<li>--%>
            <%--<a href="#systemSetting2" class="nav-header collapsed" data-toggle="collapse">--%>
            <%--活动管理--%>
            <%--<span class="pull-right glyphicon glyphicon-chevron-down"></span>--%>
            <%--</a>--%>
            <%--<ul id="systemSetting2" class="nav nav-list collapse secondmenu" style="height: 0px;">--%>
            <%--<li><a href="#">公告发布</a></li>--%>
            <%--<li><a href="#">考核平台</a></li>--%>
            <%--<li><a href="#">交流风采</a></li>--%>
            <%--<li><a href="#">软件风采</a></li>--%>
            <%--<li><a href="#">大创风采</a></li>--%>
            <%--<li><a href="#">蓝桥风采</a></li>--%>
            <%--</ul>--%>
            <%--</li>--%>
        </ul>
    </div>

    </div>
    <div class="container" id="content" style="width: 80%;height:560px; float: right;">
        <iframe name="body" src="${pageContext.request.contextPath}/body" scrolling="auto" frameborder="0" width="80%" height="560px;"></iframe>
    </div>

</body>
</html>
