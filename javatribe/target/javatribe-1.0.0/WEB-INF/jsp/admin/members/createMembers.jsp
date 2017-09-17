<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/3/24
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加成员</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>
    <div class="container">
        <div align="center"><h2>添加成员</h2></div>
        <div align="center"><h4>${createMessage}</h4></div>
        <form class="form-horizontal" action="<c:url value='/createMembers'/> " method="post">

            <div class="form-group">
                <label for="username" class="col-md-2 control-label">姓名</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="username" name="memberName">
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="col-md-2 control-label">密码</label>
                <div class="col-md-10">
                    <input type="password" class="form-control" id="password" name="memberPassword">
                </div>
            </div>


            <div class="form-group">
                <label class="col-md-2 control-label">年级</label>
                <div class="col-md-10">
                    <select class="form-control" name="gradeId">
                        <option value="(NULL)">=== 请选择 ===</option>
                        <c:forEach items="${grades}" var="grade">
                        <option value="${grade.gradeId}" >${grade.gradeName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="phone" class="col-md-2 control-label">手机</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="phone" name="phoneNumber">
                </div>
            </div>

            <div class="form-group">
                <label for="shortphone" class="col-md-2 control-label">短号</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="shortphone" name="shortPhoneNumber">
                </div>
            </div>

            <div class="form-group">
                <label for="wct" class="col-md-2 control-label">微信</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="wct" name="wechat">
                </div>
            </div>

            <div class="form-group">
                <label for="q" class="col-md-2 control-label">QQ</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="q" name="qq">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">组别</label>
                <div class="col-md-10">
                    <select class="form-control" name="groupId">
                        <option value="(NULL)">=== 请选择 ===</option>
                        <c:forEach items="${teamGroups}" var="teamGroup">
                            <option value="${teamGroup.groupId}" >${teamGroup.groupName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">角色</label>
                <div class="col-md-10">
                    <select class="form-control" name="roleId">
                        <option value="(NULL)">=== 请选择 ===</option>
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.roleId}" >${role.roleName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">职务</label>
                <div class="col-md-10">
                    <select class="form-control" name="dutyId">
                        <option value="(NULL)">=== 请选择 ===</option>
                        <c:forEach items="${duties}" var="duty">
                            <option value="${duty.dutyId}" >${duty.dutyName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
            <div class="col-md-6"><input class="btn btn-default" type="submit" value="添加"></div>
            <div class="col-md-6"><input class="btn btn-default" type="reset" value="重置"></div>
            </div>

        </form>
    </div>
</body>
</html>
