<%--
  Created by IntelliJ IDEA.
  User: KJ
  Date: 2020/6/19
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>发表图书评论</title>
    <link rel="stylesheet" href="css/publish.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-1.11.3/jquery-1.11.3.min.js"></script>
    <script src="css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            var publish = $("#btn-publish").click(function () {
                var content = $("#content").val().trim();
                if(content==null||content=="") {
                    alert("请输入内容！");
                    return false;
                }
                return true;
            });
        });
    </script>
</head>
<body style="background-color: skyblue">
<h3>评论图书</h3>
<div id="header">
    <c:if test="${sessionScope.username==null}">
        <div id="pleaseLogin">您好,请<a id="login" href="${pageContext.request.contextPath}/login.jsp">登录</a> </div>
    </c:if>
    <c:if test="${sessionScope.username!=null}">
        <div id="welcome" class="welcome">欢迎您,<span id="span">${sessionScope.username}</span>
            <form action="${pageContext.request.contextPath}/loginoutServlet" method="post">
                <input type="submit" id="loginUser" value="退出"/>
            </form>
        </div>
    </c:if>
</div>
<div class="container" id="center">
    <form action="${pageContext.request.contextPath}/publishComment" method="post">
        <div class="form-group">
            <label>书籍样式：</label>
            <br>
            <c:if test="${sessionScope.bookInfo.bookId==1}">
                <img class="bookImage" src="images/java.jpg" width="300px">
            </c:if>
            <c:if test="${sessionScope.bookInfo.bookId==2}">
                <img class="bookImage" src="images/biancheng.jpg" width="300px">
            </c:if>
            <c:if test="${sessionScope.bookInfo.bookId==3}">
                <img class="bookImage" src="images/xyj.jpg" width="300px">
            </c:if>
            <c:if test="${sessionScope.bookInfo.bookId==4}">
                <img class="bookImage" src="images/hlm.jpg" width="300px">
            </c:if>
            <c:if test="${sessionScope.bookInfo.bookId==5}">
                <img class="bookImage" src="images/boot.jpg" width="300px">
            </c:if>
            <c:if test="${sessionScope.bookInfo.bookId==6}">
                <img class="bookImage" src="images/cloud.jpg" width="300px">
            </c:if>
            <c:if test="${sessionScope.bookInfo.bookId==7}">
                <img class="bookImage" src="images/mzd.jpg" width="300px">
            </c:if>
            <c:if test="${sessionScope.bookInfo.bookId==8}">
                <img class="bookImage" src="images/jds.jpg" width="300px">
            </c:if>
            <c:if test="${sessionScope.bookInfo.bookId==9}">
                <img class="bookImage" src="images/gdsx.jpg" width="300px">
            </c:if>
            <c:if test="${sessionScope.bookInfo.bookId==10}">
                <img class="bookImage" src="images/python.jpg" width="300px">
            </c:if>
        </div>
        <div class="form-group">
            <label for="bookIsbn">书号：</label>
            <input type="text" id="bookIsbn" class="form-control" disabled value="${sessionScope.bookInfo.isbn}"/>
        </div>
        <div class="form-group">
            <label for="bookName">书籍名称：</label>
            <input type="text" id="bookName" class="form-control" disabled value="${sessionScope.bookInfo.bookName}"/>
        </div>
        <div class="form-group">
            <label for="bookAuthor">书籍作者：</label>
            <input type="text" id="bookAuthor" class="form-control" disabled value="${sessionScope.bookInfo.author}"/>
        </div>
        <div class="form-group">
            <label for="bookIntroduce">书籍简介：</label>
            <input type="text" id="bookIntroduce" class="form-control" disabled value="${sessionScope.bookInfo.introduce}"/>
        </div>
        <div class="form-group">
            <label for="content">我要评论：</label>
            <textarea id="content" name="content"></textarea>
        </div>
        <div class="form-group">
            <input class="btn-primary" id="btn-publish" type="submit" value="发表评论"/>
            <a id="back" href="${pageContext.request.contextPath}/bookListServlet">返回</a>
        </div>
    </form>
</div>
</body>
</html>
