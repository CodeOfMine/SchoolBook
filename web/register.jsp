<%--
  Created by IntelliJ IDEA.
  User: KJ
  Date: 2020/6/19
  Time: 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册界面</title>
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="js/jquery-1.11.3/jquery-1.11.3.min.js"></script>
    <script src="css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $("#btn-register").click(function () {
                var $username = $("#username").val().trim();
                var $password = $("#password").val().trim();
                var $password2 = $("#password2").val().trim();
                var $name = $("#name").val().trim();
                if($username==null||$username=="") {
                    alert("请输入用户名！");
                    return false;
                }
                if($name==null||$name=="") {
                    alert("请输入真实姓名！");
                    return false;
                }
                if($password==null||$password=="") {
                    alert("请输入密码！");
                    return false;
                }
                if($password2==null||$password2=="") {
                    alert("清确认密码！");
                    return false;
                }
                if($password2!=null) {
                    alert("两次输入的密码不一致！");
                    return false;
                }
                return true;
            });
        });
        });
    </script>
</head>
<body>
<div class="container">
    <table>
        <form action="${pageContext.request.contextPath}/registerServlet" method="post">
            <div class="form-group">
                <label for="username">用户名：</label>
                <input type="text" id="username" name="username" placeholder="请输入用户名" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="name">真实姓名：</label>
                <input type="text" id="name" name="name" placeholder="请输入真实姓名" class="form-control"/>
            </div>
            <div class="form-group">
                <label>性别：</label>
                <input type="radio" name="gender" value="男" checked="checked"/>男
                <input type="radio" name="gender" value="女"/>女
            </div>
            <div class="form-group">
                <label for="password">密码：</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码"/>
            </div>
            <div class="form-group">
                <label for="password2">密码：</label>
                <input type="password" class="form-control" name="password" id="password2" placeholder="请确认密码"/>
            </div>
            <div id="register">
                <input type="submit" value="注册" id="btn-register"/>
            </div>
            <div class="alert alert-warning alert-dismissable" role="alert">
                <button type="button" class="close" data-dismiss="alert">
                    <span>x</span>
                </button>
                <strong>${sessionScope.registerMsg}</strong>
            </div>
        </form>
    </table>
</div>
</body>
</html>
