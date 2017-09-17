<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/4/7
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>交流会风采编辑</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/wangEditor/css/wangEditor.min.css'/> ">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>

    <div class="container">

        <div align="center"><h2>交流会风采编辑</h2></div>
        <div align="center"><h4></h4></div>

        <form class="form-horizontal" action="<c:url value='/createCommunicationShow'/> " method="post">

            <div class="form-group">
                <label for="title" class="col-md-2 control-label">标题</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="title" name="meetingTitle">
                </div>
            </div>

            <div class="form-group">
                <label for="mdate" class="col-md-2 control-label">开展时间</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="mdate" name="meetingDate">
                </div>
            </div>

            <div class="form-group">
                <label for="maddr" class="col-md-2 control-label">开展地点</label>
                <div class="col-md-10">
                    <input type="text" class="form-control" id="maddr" name="meetingAddress">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">交流会主题</label>
                <div class="col-md-10">
                    <textarea class="form-control" id="mtheme" name="meetingTheme" style="height: 300px;"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="col-md-5"><button class="btn btn-primary" type="submit">公布</button> </div>
                <div class="col-md-5"><button class="btn btn-primary" type="reset">重置</button> </div>
            </div>

        </form>

    </div>

</body>
<script type="text/javascript" src="<c:url value='/static/wangEditor/js/wangEditor.min.js'/> "></script>
<script type="text/javascript">
    var editor = new wangEditor("mtheme");
    editor.config.uploadImgUrl = "<c:url value='/uploadCommunicationShowImg'/>";
    editor.create();
</script>
</html>
