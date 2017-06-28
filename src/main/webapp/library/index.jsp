<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/27
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>首页</h1>
<form action="libraryUser" method="post">
    <input type="hidden" name="action" value="login"><br>
    <input type="text" name="userName" placeholder="账户名" value="admin"><br>
    <input type="password" name="password" placeholder="密码" value="aaa"><br>
    <input type="submit" value="登录">
    <a href="register.jsp">注册</a>
</form>
${requestScope.message}
</body>
</html>
