<%--
  Created by IntelliJ IDEA.
  User: KJ
  Date: 2020/6/19
  Time: 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书列表界面</title>
    <link rel="stylesheet" href="css/comments.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-1.11.3/jquery-1.11.3.min.js"></script>
    <script src="css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
        function deleteComment(id) {
            if(confirm("确定删除吗？")) {
                location.href = "${pageContext.request.contextPath}/delCommentServlet?id="+id;
            }
            var status = ${sessionScope.username};
            if(status==="管理员") {
                alert("您是管理员");
            }
        }
    </script>
</head>
<body>

<div id="header">
    <img src="images/header.jpg"/>
    <h3>图书评论</h3>
    <c:if test="${sessionScope.username==null}">
        <div id="pleaseLogin">您好,请<a href="${pageContext.request.contextPath}/login.jsp">登录</a> </div>
    </c:if>
    <c:if test="${sessionScope.username!=null}">
        <div id="welcome" class="welcome">欢迎您,<span>${sessionScope.username}</span>
            <form action="${pageContext.request.contextPath}/loginoutServlet" method="post">
                <input type="submit" id="loginUser" value="退出"/>
            </form>
        </div>
    </c:if>
    <div id="hrefs">
        <c:if test="${sessionScope.username==null}">
            <a href="${pageContext.request.contextPath}/login.jsp">我的借阅记录</a>
        </c:if>
        <c:if test="${sessionScope.username!=null}">
            <a href="${pageContext.request.contextPath}/myBookServlet">我的借阅记录</a>
        </c:if>
        <a href="${pageContext.request.contextPath}/bookListServlet">查看所有图书</a>
    </div>
</div>
<div id="center" class="container">
    <h4>书籍信息</h4>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>书名</th>
            <th>评论人</th>
            <th>时间</th>
            <th>内容</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${sessionScope.allComments}" var="comment" varStatus="b">
            <tr>
                <td>${b.count}</td>
                <td>${comment.bookName}</td>
                <td>${comment.username}</td>
                <td>${comment.time}</td>
                <td>${comment.content}</td>
                <td>
                    <a href="javascript:deleteComment(${comment.commentId})">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="footer">
    <img src="images/foot.jpg">
</div>
</body>
</html>