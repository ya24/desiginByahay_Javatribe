<%--
  Created by IntelliJ IDEA.
  User: 叶雅芳
  Date: 2017/3/23
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页码列表</title>
</head>
<body>
<%--我们需要计算页码列表的开始和结束位置，即两个变量begin和end
计算它们需要通过当前页码！
1. 总页数不足6页--> begin=1, end=最大页
2. 通过公式设置begin和end，begin=当前页-5, end=当前页 + 4
3. 如果begin<1，那么让begin=1，end=6
4. 如果end>tp, 让begin=tp-5, end=tp
 --%>

<c:choose>
    <c:when test="${memberInfoPage.currentPage <= 6}">
        <c:set var="begin" value="1"/>
        <c:set var="end" value="${memberInfoPage.totalPage}"/>
    </c:when>
    <c:otherwise>
        <c:set var="begin" value="${memberInfoPage.currentPage - 5}"/>
        <c:set var="end" value="${memberInfoPage.currentPage + 4}"/>
        <c:if test="${begin < 1}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="6"/>
        </c:if>
        <c:if test="${end > memberInfoPage.totalPage}">
            <c:set var="begin" value="${memberInfoPage.totalPage - 5}"/>
            <c:set var="end" value="${memberInfoPage.totalPage}"/>
        </c:if>
    </c:otherwise>
</c:choose>

<div class="container">
    <ul class="pagination">
        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <c:forEach begin="${begin}" end="${end}" var="i">
        <li class="<c:if test='${i eq memberInfoPage.currentPage}'>active</c:if>">
            <a href="<c:url value='${memberInfoPage.url}/${i}'/> ">${i}</a>
        </li>
        </c:forEach>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</div>
</body>
</html>
