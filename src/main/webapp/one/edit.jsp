<%@ page import="one.Students" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/13
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑</title>
</head>
<body>
<h1>编辑</h1>
<hr/>
<form action="student" method="post">
    <h3>添加学生</h3>
    <input type="hidden" name="action" value="modify">
    <input type="hidden" name="id" value="<%=((Students)session.getAttribute("student")).getId()%>">
    <input type="text" name="name" placeholder="学生姓名" value="<%=((Students)session.getAttribute("student")).getName()%>"><br>
    <p>性别</p>
    <input type="text" name="gender"  value="<%=((Students)session.getAttribute("student")).getGender()%>">
    <input type="date" name="date" value="<%=((Students)session.getAttribute("student")).getDate()%>"><br>
    <input type="submit" value="保存">
</form>
<hr/>
</body>
</html>
