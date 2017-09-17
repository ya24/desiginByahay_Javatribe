<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/4/7
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>交流会风采</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>

    <div class="container">

         <shiro:hasPermission name="communicationShow:create">
             <a href="<c:url value='/createCommunicationShow'/> ">交流会风采编辑</a>
         </shiro:hasPermission>
        
        <shiro:hasPermission name="communicationShow:query">
            <a href="<c:url value='/queryCommunicationShow/1'/> ">交流会风采展览</a>
        </shiro:hasPermission>

    </div>

</body>
</html>
