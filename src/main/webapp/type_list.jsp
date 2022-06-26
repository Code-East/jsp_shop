<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/4/13 0013
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <select name="type_id">
        <c:forEach items="${list}" var = "t">
            <option value="${t.id}">${t.name}</option>
        </c:forEach>
    </select>
</body>
</html>
