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
<p><%=session.getAttribute("nick")%></p>
<h1>欢迎你回来</h1>
<a href="home.jsp">回到主页</a>
<a href="user?acton=logout">注销</a>
</body>
</html>