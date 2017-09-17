<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/3/27
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布公告</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/wangEditor/css/wangEditor.min.css'/> ">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
</head>
<body>
<div class="container">
    <div align="center"><h2>发布公告</h2></div>
    <div align="center"><h4></h4></div>

    <form class="form-horizontal" action="<c:url value='/createAffiche'/> " method="post" enctype="multipart/form-data">

        <div class="form-group">
            <label for="title" class="col-md-2 control-label">标题</label>
            <div class="col-md-10">
                <input type="text" class="form-control" id="title" name="afficheTitle">
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">内容</label>
            <div class="col-md-10">
                <textarea id="acontent" name="afficheContent" class="form-control" style="height: 300px;"></textarea>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label">附件</label>
            <div class="col-md-10">
                <input type="file" name="attachFileId" class="form-control">
            </div>
        </div>

        <%--<div class="form-group">--%>
            <%--<div class="col-md-6"><input class="btn btn-primary" type="submit" value="发布"></div>--%>
            <%--<div class="col-md-6"><input class="btn btn-primary" type="reset" value="重置"></div>--%>
        <%--</div>--%>
        <div class="form-group">
            <div class="col-md-5"><button type="submit" class="btn btn-primary">发布</button> </div>
            <div class="col-md-5"><button type="reset" class="btn btn-primary">重置</button> </div>
        </div>



    </form>
</div>

</body>
<script type="text/javascript" src="<c:url value='/static/wangEditor/js/wangEditor.min.js'/> "></script>
<script type="text/javascript">
    var editor = new wangEditor("acontent");
    editor.create();
</script>
</html>
