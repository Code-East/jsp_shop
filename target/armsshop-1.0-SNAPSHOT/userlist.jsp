<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>枪械商城后台管理</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<jsp:include page="header.jsp"></jsp:include>
<!--时间-->
<section class="publicTime">
    <span id="time">2022年02月21日 08:31  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="userList.jsp">用户管理</a></li>
                <li><a href="/goods_list">商品管理</a></li>
                <li><a href="#">订单管理</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面</span>
        </div>
        <div class="search">
            <span>用户名：</span>
            <input type="text" placeholder="请输入用户名"/>
            <input type="button" value="查询"/>
            <a href="userAdd.jsp">添加用户</a>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">用户名</th>
                <th width="10%">密码</th>
                <th width="10%">真实姓名</th>
                <th width="10%">邮箱</th>
                <th width="20%">地址</th>
                <th width="10%">用户类型</th>
                <th width="30%">操作</th>
            </tr>

            <c:forEach items="${list}" var = "u">
                <tr>
                    <td>${u.username}</td>
                    <td>${u.passwrod}</td>
                    <td>${u.rname}</td>
                    <td>${u.age}</td>
                    <td>${u.phone}</td>
                    <td>${u.usertype}</td>
                    <td>
                        <a href="userUpdata.jsp?${u.username}"><img src="img/uqdata.png" alt="修改" title="修改"/></a>
                        <a href="deleteuser?username=${u.username}" class="removeUser"><img src="img/delete.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="7">
                    当前第1页，${list.size()}条数据&nbsp;&nbsp;&nbsp;&nbsp;共1页
                    首页
                    尾页
                    上一页
                    下一页
                </td>
            </tr>
        </table>

    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
</footer>
</body>
</html>