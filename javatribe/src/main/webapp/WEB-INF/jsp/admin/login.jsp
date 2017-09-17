<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/3/18
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页</title>
    <script type="text/javascript">
        function refresh_code() {
            document.getElementById('code').src = "/javatribe/verify?" + new Date().getTime();
        }
    </script>
</head>
<body>
<h3>${error}</h3>
<form action="<c:url value='/login'/>"  method="post">
    用户名：<input name="username" type="text"><br>
    密&nbsp;码：<input name="password" type="password"><br>
    验证码：<input name="vcode"><span onclick="refresh_code()">
            <img id="code" src="<c:url value='/verify'/>">
            </span>
            <br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
</body>
</html>
