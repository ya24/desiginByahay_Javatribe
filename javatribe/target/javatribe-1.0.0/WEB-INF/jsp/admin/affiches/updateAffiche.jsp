<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/4/3
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>修改公告</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    <link rel="stylesheet" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/wangEditor/css/wangEditor.min.css'/> ">
    <script src="<c:url value='/static/bootstrap/js/jquery.min.js'/>"></script>
    <script src="<c:url value='/static/bootstrap/js/bootstrap.min.js'/>"></script>
    <script>

        function delAttach() {
            location.href = "${pageContext.request.contextPath}/deleteAttachFile/${affiche.attachfileId}";
        }

    </script>
</head>
<body>

    <div class="container">

        <div align="center"><h2>修改公告</h2></div>
        <div align="center"><h4></h4></div>

        <form action="<c:url value='/updateAffiche'/> " method="post" class="form-horizontal" enctype="multipart/form-data">

            <input type="hidden" name="afficheId">

            <div class="form-group">
                <label for="atitle" class="col-md-2 control-label">标题</label>
                <div class="col-md-10">
                    <input type="text" name="afficheTitle" class="form-control" id="atitle" value="${affiche.afficheTitle}">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label">内容</label>
                <div class="col-md-10">
                    <textarea id="acontent" name="afficheContent" class="form-control" style="height: 300px;">
                        ${affiche.afficheContent}
                    </textarea>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-2 control-label" for="aname">发布者</label>
                <div class="col-md-10">
                    <input type="text" name="memberName" class="form-control" id="aname" value="${affiche.memberName}">
                </div>
            </div>

            <c:choose>
                <c:when test="${affiche.attachfileId ne null}">
                    <div class="form-group">
                        <label class="col-md-2 control-label">附件</label>
                        <div class="col-md-10">
                            <a href="<c:url value='/loadAttachFile/${attachfile.attachfileId}'/> ">${attachfile.attachfileName}</a>
                            <button type="button" class="close" aria-label="Close">
                                <span aria-hidden="true" onclick="delAttach()">&times;</span>
                            </button>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="form-group" id="attach">
                        <label class="col-md-2 control-label">附件</label>
                        <div class="col-md-10">
                            <input type="file" name="attachFileId" class="form-control">
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>

            <div class="form-group">
                <div class="col-md-5"><button type="submit" class="btn btn-primary">修改</button> </div>
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
