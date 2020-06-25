<%--
  Created by IntelliJ IDEA.
  User: KJ
  Date: 2020/6/19
  Time: 4:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/mybook.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-1.11.3/jquery-1.11.3.min.js"></script>
    <script src="css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div id="header">
    <img src="images/header.jpg"/>
    <h3>欢迎来到校园图书借阅系统</h3>
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
        <a href="${pageContext.request.contextPath}/bookListServlet">查看所有图书</a>
        <a href="${pageContext.request.contextPath}/showComments">查看图书评论</a>
    </div>
</div>
<div id="center" class="container">
    <h4>我的借阅记录</h4>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>书号</th>
            <th>书名</th>
            <th>作者</th>
            <th>借阅日期</th>
            <th>返还日期</th>
        </tr>
        <c:forEach items="${sessionScope.borrowInfo}" var="book" varStatus="b">
            <tr>
                <td>${b.count}</td>
                <td>${book.isbn}</td>
                <td>${book.bookName}</td>
                <td>${book.author}</td>
                <td>${book.borrowTime}</td>
                <c:if test="${book.backTime==null}">
                    <td>待还</td>
                </c:if>
                <c:if test="${book.backTime!=null}">
                    <td>${book.backTime}</td>
                </c:if>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="footer">
    <img src="images/foot.jpg">
</div>
</body>
</html>
