<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/4/10
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>交流会风采修改</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/wangEditor/css/wangEditor.min.css'/> ">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>
    <div class="container">
        <div align="center"><h2>交流会风采修改</h2></div>

        <form action="<c:url value='/updateCommunicationShow'/> " method="post" class="form-horizontal">
            <input type="hidden" name="meetingId" value="${communicationMeeting.meetingId}">
            <div class="form-group">
                <label for="mtitle" class="col-md-2 control-label">标题</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="mtitle" name="meetingTitle" value="${communicationMeeting.meetingTitle}">
                </div>
            </div>

            <div class="form-group">
                <label for="mtime" class="col-md-2 control-label">开展时间</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="mtime" name="meetingDate" value="${communicationMeeting.meetingDate}">
                </div>
            </div>

            <div class="form-group">
                <label for="maddr" class="col-md-2 control-label">开展地点</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="maddr" name="meetingAddress" value="${communicationMeeting.meetingAddress}">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">交流会主题</label>
                <div class="col-md-10">
                    <textarea class="form-control" name="meetingTheme" id="mtheme" style="height: 300px">
                        ${communicationMeeting.meetingTheme}
                    </textarea>
                </div>
            </div>

            <div class="form-group">
                <label for="meditor" class="control-label col-md-2">编辑者</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="meditor" name="memberName" value="${communicationMeeting.memberName}">
                </div>
            </div>

            <div>
                <div class="col-md-5"><button class="btn btn-primary" type="submit">修改</button> </div>
                <div class="col-md-5"><button class="btn btn-primary" type="reset">重置</button> </div>
            </div>

        </form>
    </div>
</body>
<script type="text/javascript" src="<c:url value='/static/wangEditor/js/wangEditor.min.js'/> "></script>
<script type="text/javascript">
    var editor = new wangEditor("mtheme");
    editor.config.uploadImgUrl = "<c:url value='/uploadCommunicationShowImg'/> ";
    editor.create();
</script>
</html>
