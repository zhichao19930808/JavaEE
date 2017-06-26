<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <title>ip查询</title>
        <style>
            #box {
                width: 1000px;
                margin: auto;
                background: wheat;
            }
            #head {
                width: 1000px;
                height: 100px;
            }
            #head h1 {
                text-align: center;
            }
            #left {
                width: 300px;
                float: left;
            }
            #right {
                width: 700px;
                float: right;
            }
        </style>
    </head>
<body>
<div id="box">
    <div id="head">
        <h1>ip查询系统</h1>
    </div>
    <div id="left">
        <form action="ip" method="post">
            <input type="hidden" name="getIp" value="selectAll">
            <input type="text" name="geo" placeholder="请输入您要查询的地址" style="width: 230px;height:50px">
            <input type="submit" value="查询" height="50px" style="width: 50px;height:50px">
        </form>
        <p>数据库信息来自于(纯真IP地址数据库）</p>
        <p><a href="../index.jsp">回到活人先生的主页</a></p>
</div>
    <div id="right">
        <table border="1px">
            <c:choose>
                <c:when test="${fn:length(sessionScope.ips) eq 0}">
                    当前没有记录
                </c:when>
                <c:otherwise>
                    <tr>
                        <th>序号</th>
                        <th>地址</th>
                        <th>起始id</th>
                        <th>终止id</th>
                    </tr>
                </c:otherwise>
            </c:choose>
            <c:forEach var="ip" items="${sessionScope.ips}" varStatus="vs" begin="0" end="30" step="1">
                <tr>
                    <td>${vs.count}</td>
                    <td>${ip.geo}</td>
                    <td>${ip.min}</td>
                    <td>${ip.max}</td>
                </tr>
            </c:forEach>
        </table>
        <p>${requestScope.message}</p>
    </div>
</div>
</body>
</html>