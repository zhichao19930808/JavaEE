<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/6/27
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<c:if test="${sessionScope.userName eq null}">
    <c:redirect url="index.jsp"/>
</c:if>

<h1>${sessionScope.userName}主页</h1>
</body>
</html>
