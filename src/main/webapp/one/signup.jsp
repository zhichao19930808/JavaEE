<%@
    page contentType="text/html; charset=utf-8"
%>
<html>
<head>
    <title>注册表</title>
</head>
<body>
<form action="user">
    <input type="hidden" name="action" value="register">
    <input type="text" name="nick" placeholder="昵称"><br>
    <input type="text" name="mobile" placeholder="手机号码"><br>
    <input type="password" name="password" placeholder="密码"><br>
    <input type="submit" value="注册">
</form>
<p>${requestScope.message}</p>
</body>
</html>