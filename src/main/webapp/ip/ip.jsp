<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>ip查询</title>
    </head>
<body>
<h1>ip查询系统</h1>
<form action="ip" method="post">
<input type="text" name="ip" placeholder="请输入您要查询的地址">
    <input type="submit" value="查询">
</form>
<table>
    <tr>
        <th>地理位置</th>
        <th>起始IP地址</th>
        <th>终止IP地址</th>
    </tr>
    <tr>
        <td>    <%
            String geo = String.valueOf(request.getAttribute("geo"));
                out.print(geo);
        %></td>
        <td>    <%
            String min = String.valueOf(request.getAttribute("min"));
                out.print(min);
        %></td>
        <td>    <%
            String max = String.valueOf(request.getAttribute("max"));
                out.print(max);
        %></td>
    </tr>
</table>
<p>
    <%
        String message = String.valueOf(request.getAttribute("message"));
        if (message == null) {
            out.print(message);
        }
    %>
</p>
</body>
</html>