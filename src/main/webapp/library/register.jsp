<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/28
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>注册</h1>
<form action="libraryUser" method="post">
    <input type="hidden" name="action" value="register"><br>
    <input type="text" name="userName" placeholder="请输入账户名"><br>
    <input type="password" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="注册">
</form>
<hr>
${requestScope.message}
</body>
</html>
