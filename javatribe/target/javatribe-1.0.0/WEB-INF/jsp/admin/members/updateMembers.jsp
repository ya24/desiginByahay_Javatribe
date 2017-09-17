<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/3/24
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成员更新</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>

<div class="container">
    <div align="center"><h2>成员更新</h2></div>
    <div align="center"><h4>${updateMessage}</h4></div>
    <form class="form-horizontal" action="<c:url value='/updateMembers'/> " method="post">
        <!-- 成员编号 -->
        <input type="hidden" name="memberId" value="${teamMembers.memberId}">

        <div class="form-group">
            <label for="username" class="col-md-2 control-label">姓名</label>
            <div class="col-md-10">
                <input type="text" class="form-control" id="username" name="memberName" value="${teamMembers.memberName}">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">年级</label>
            <div class="col-md-10">
                <select class="form-control" name="gradeId">
                    <option value="null">=== 请选择 ===</option>
                    <c:forEach items="${grades}" var="grade">
                        <option value="${grade.gradeId}" <c:if test="${grade.gradeId eq teamMembers.gradeId}">selected</c:if> >
                            ${grade.gradeName}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="form-group">
            <label for="phone" class="col-md-2 control-label">手机</label>
            <div class="col-md-10">
                <input type="text" class="form-control" id="phone" name="phoneNumber" value="${teamMembers.phoneNumber}">
            </div>
        </div>

        <div class="form-group">
            <label for="shortphone" class="col-md-2 control-label">短号</label>
            <div class="col-md-10">
                <input type="text" class="form-control" id="shortphone" name="shortPhoneNumber" value="${teamMembers.shortPhoneNumber}">
            </div>
        </div>

        <div class="form-group">
            <label for="wct" class="col-md-2 control-label">微信</label>
            <div class="col-md-10">
                <input type="text" class="form-control" id="wct" name="wechat" value="${teamMembers.wechat}">
            </div>
        </div>

        <div class="form-group">
            <label for="q" class="col-md-2 control-label">QQ</label>
            <div class="col-md-10">
                <input type="text" class="form-control" id="q" name="qq" value="${teamMembers.qq}">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">组别</label>
            <div class="col-md-10">
                <select class="form-control" name="groupId">
                    <option value="null">=== 请选择 ===</option>
                    <c:forEach items="${teamGroups}" var="teamGroup">
                        <option value="${teamGroup.groupId}" <c:if test="${teamGroup.groupId eq teamMembers.groupId}">selected</c:if>>
                            ${teamGroup.groupName}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">角色</label>
            <div class="col-md-10">
                <select class="form-control" name="roleId">
                    <option value="null">=== 请选择 ===</option>
                    <c:forEach items="${roles}" var="role">
                        <option value="${role.roleId}" <c:if test="${role.roleId eq teamMembers.roleId}">selected</c:if> >
                            ${role.roleName}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">职务</label>
            <div class="col-md-10">
                <select class="form-control" name="dutyId">
                    <option value="null">=== 请选择 ===</option>
                    <c:forEach items="${duties}" var="duty">
                        <option value="${duty.dutyId}" <c:if test="${duty.dutyId eq teamMembers.dutyId}">selected</c:if> >
                            ${duty.dutyName}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group">
            <div class="col-md-6"><input class="btn btn-default" type="submit" value="修改"></div>
            <div class="col-md-6"><input class="btn btn-default" type="reset" value="重置"></div>
        </div>

    </form>
</div>

</body>
</html>
