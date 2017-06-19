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
 <p> <%=(request.getAttribute("message")!=null)? request.getAttribute("message"):""%></p>
  <%--<p>--%>
    <%--<%--%>
      <%--String message = (String) request.getAttribute("message");--%>
      <%--if (message != null) {--%>
        <%--out.print(message);--%>
      <%--}--%>
    <%--%>--%>
  <%--</p>--%>
  <a href="signup.jsp">注册</a>
  </body>
</html>
