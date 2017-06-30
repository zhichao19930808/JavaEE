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
    <title>编辑</title>
</head>
<body>
<c:if test="${sessionScope.role ne '管理员'}">
    <c:redirect url="index.jsp"/>
</c:if>

<h1>编辑</h1>
<hr>
${sessionScope.userName}
<hr>
<form action="libraryBooks">
    <input type="hidden" name="action" value="${sessionScope.book.id}">
    <input type="text" name="title" placeholder="书名" value="${sessionScope.book.title}"><br>
    <input type="text" name="author" placeholder="作者" value="${sessionScope.book.author}"><br>
    <input type="text" name="pub" placeholder="出版社" value="${sessionScope.book.pub}"><br>
    <input type="date" name="time" placeholder="出版时间" value="${sessionScope.book.time}">出版时间<br>
    <input type="text" name="price" placeholder="价格" value="${sessionScope.book.price}"><br>
    <input type="text" name="amount" placeholder="数量" value="${sessionScope.book.amount}"><br>
    <input type="submit" value="添加">
</form>
<hr>
${sessionScope.message}
<hr>
<a href="libraryUser?action=logout">注销</a>
<a href="admin.jsp">返回管理员页面</a>
</body>
</html>
