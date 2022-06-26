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
            <span>商品管理页面 >> 商品增加页面</span>
        </div>
        <div class="providerAdd">
            <form action="/add_goods" method="get">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <div style="margin-left: 155px">
                    <labe style="font-size: 14px">商品名:</labe>
                    <input type="text" name="name" id="name"/>
                    <span >*</span>
                </div>

                <div>
                    <label>展示图片:</label>
                    <input type="text" name="cover" id="cover"/>
                    <span >*</span>
                </div>
                <div>
                    <label>详情图片1:</label>
                    <input type="text" name="image1" id="image1" />
                    <span >*</span>
                </div>
                <div>
                    <label>详情图片1:</label>
                    <input type="text" name="image2" id="image2" />
                </div>

                <div>
                    <label for="price">价格:</label>
                    <input type="text" name="price" id="price" />
                </div>

                <div>
                    <label for="stock">库存:</label>
                    <input type="text" name="stock" id="stock" />
                </div>
                <div>
                    <label>类型:</label>
<%--                    <select name="type_id">--%>
<%--                        <option value="1">--请选择--</option>--%>
<%--                    </select>--%>
                    <jsp:include page="type_list.jsp"></jsp:include>
                </div>
                <div>
                    <label>简介:</label>
                    <textarea name="intro" style="width: 400px; height: 100px;"></textarea>
                </div>

                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="submit" value="增加" />
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