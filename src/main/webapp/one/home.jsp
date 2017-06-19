<%@ page import="java.util.List" %>
<%@ page import="one.Students" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if (session.getAttribute("nick") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<h1><%=session.getAttribute("nick")%>的主页</h1>
<hr/>
<form action="student" method="post">
    <h3>添加学生</h3>
    <input type="hidden" name="action" value="add">
    <input type="text" name="name" placeholder="学生姓名"><br>
    <p>性别</p>
    <input type="radio" name="gender" value="nan">男
    <input type="radio" name="gender" value="nv">女 <br>
    <input type="date" name="date" ><br>
    <input type="submit" value="添加">
</form>
<hr/>
<%
    String message =(String) request.getAttribute("message");
    if (message != null) {
        out.print(message);
    }
%>
<hr/>
<table border="1">
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>性别</th>
        <th>出生日期</th>
        <th colspan="2">操作</th>
    </tr>
    <%
        List<Students>students = (List<Students>) session.getAttribute("students");
        for (Students student : students) {
            out.print("<tr>" + "<td>" + student.getId() + "</td>" + "<td>" + student.getName() + "</td>" + "<td>" + student.getGender() + "</td>" + "<td>" + student.getDate() + "</td>"+ "<td><a href='student?action=queryById&id="+student.getId()+"'>编辑</td>" + "</td>"+ "<td><a href='#'>删除</td>"+  "</tr>");
        }
    %>

</table>
<a href="second.jsp">下一页</a>
<a href="user?action=logout">注销</a>
</body>
</html>