<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/6
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index page</title>
  </head>
  <body>
  <form action="user" method="post">
      <input type="hidden" name="action" value="login">
    <input type="text" name="mobile" placeholder="邮箱"><br>
    <input type="password" name="password" placeholder="密码"><br>
    <input type="submit" value = "登陆">
  </form>
  <hr/>
  <p>${requestScope.message}</p>
  <p>为了使用方便，此处管理员使用注册的方式</p>

  <a href="signup.jsp">注册</a>
  <hr/>
  <a href="../index.jsp">回到活人先生的主页</a>
  </body>
</html>
