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
    业余爱好：
    <input type="checkbox" name="hobbies" value="TV">TV
    <input type="checkbox" name="hobbies" value="Movie">Movie
    <input type="checkbox" name="hobbies" value="Game">Game<br>
    所在城市：
    <select name="cities" multiple>
        <option value="Beijing">Beijing</option>
        <option value="Shanghai">Shanghai</option>
        <option value="Shenzhen">Shenzhen</option>
    </select><br>
    <input type="submit" value="注册">
</form>
<p><%
    String message = (String) request.getAttribute("message");
    if (message != null) {
        out.print(message);
    }
%></p>
</body>
</html>