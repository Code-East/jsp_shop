<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
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
                <li><a href="userList.html">用户管理</a></li>
                <li><a href="/goods_list">商品管理</a></li>
                <li><a href="#">订单管理</a></li>
                <li><a href="login.html">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>商品管理页面 >> 商品修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="/goods_update" method="get">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <input readonly type="hidden" name="id" value="${g.id}" />
                <div>
                    <label for="userName">商品名:</label>
                    <input readonly type="text" name="name" id="userName" value="${g.name}"/>
                </div>


                <div>
                    <label for="data">展示图:</label>
                    <input readonly type="text" name="cover" id="data" value="${g.cover}"/>
                </div>
                <div>
                    <label for="userphone">详情图片1:</label>
                    <input type="text" name="image1" id="userphone" value="${g.image1}"/>
                </div>
                <div>
                    <label for="name">详情图片2:</label>
                    <input type="text" name="image2" id="name" value="${g.image2}"/>
                </div>
                <div>
                    <label for="password">价格:</label>
                    <input type="text" name="price" id="password" value="${g.price}"/>
                </div>
                <div>
                    <label for="password">库存:</label>
                    <input type="text" name="stock" i value="${g.stock}"/>
                </div>
                <div>
                    <label for="password">类型:</label>
                    <jsp:include page="type_list.jsp"></jsp:include>
                </div>
                <div>
                    <label>简介:</label>
<%--                    <input type="text" name="address" id="address" value="${g.address}"/>--%>
                        <textarea name="intro" style="width: 400px;height: 100px">${g.intro}</textarea>
                </div>

                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="submit" value="保存" />
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>