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
            <span>商品管理页面</span>
        </div>
        <div class="search">
            <span style="float: left;font-size: 14px"> 商品名：</span>
            <form action="/search_goods" method="get">
                <input type="text" placeholder="请输入商品名" name="goodsName"/>
                <input type="submit" value="查询"/>
            </form>
            <a href="/get_type_list">添加商品</a>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">商品编号</th>
                <th width="10%">商品名</th>
                <th width="10%">价格</th>
                <th width="20%">简介</th>
                <th width="10%">库存</th>
                <th width="20%">操作</th>
            </tr>

            <c:forEach items="${p.list}" var = "g">
                <tr>
                    <td>${g.id}</td>
                    <td>${g.name}</td>
                    <td>${g.price}</td>
                    <td>${g.intro}</td>
                    <td>${g.stock}</td>
                    <td>
<%--                        userUpdata.jsp?${u.username}--%>
                        <a href="/show_type_list?id=${g.id}"><img src="image/uqdata.png" alt="修改" title="修改"/></a>
                        <a href="/delete_goods?id=${g.id}" class="removeUser"><img src="image/delete.png" alt="删除" title="删除"/></a>
                    </td>
                </tr>
            </c:forEach>

        </table>
        <jsp:include page="page.jsp">
            <jsp:param value="/goods_list" name="url"/>
        </jsp:include>
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