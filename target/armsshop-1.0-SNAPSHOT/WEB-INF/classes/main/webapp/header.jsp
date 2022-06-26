<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/13 0013
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <header class="publicHeader">
        <h1>枪械商城后台管理</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"><%=request.getSession().getAttribute("username") %></span> , 欢迎你！</p>
            <a href="login.jsp">退出</a>
        </div>
    </header>
<!--时间-->
</body>
</html>
