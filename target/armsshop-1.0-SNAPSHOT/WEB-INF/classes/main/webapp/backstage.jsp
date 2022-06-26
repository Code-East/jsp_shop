<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>枪械商城后台管理</title>
</head>
<link rel="stylesheet" href="css/public.css"/>
<link rel="stylesheet" href="css/style.css"/>
<script src="js/echarts.js"></script>
<style>
    #echarts_box{
        display: flex;
    }
    #echarts_box #main1{
        width: 700px;
        height: 600px;
        margin: 50px 50px 0px 0px;
    }
    #echarts_box #main2{
        width: 600px;
        height: 600px;
        margin-top: 50px;
    }
</style>
<body>
<!--头部-->
<jsp:include page="header.jsp"></jsp:include>
<!--时间-->
<section class="publicTime">
    <span id="time">2022年02月21日 08:30  星期一</span>
</section>
<!--主体内容-->
<section class="publicMian" >
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="userlistservlet">用户管理</a></li>
                <li><a href="/goods_list">商品管理</a></li>
                <li><a href="#">订单管理</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
<%--        <img class="wColck" src="img/logo.png" alt=""/>--%>
<%--        <div class="wFont">--%>
<%--            <h2><%=request.getSession().getAttribute("username") %></h2>--%>
<%--            <p>枪械商城后台管理!</p>--%>
<%--            <span id="hours"></span>--%>
<%--        </div>--%>
        <div id="echarts_box">
            <div id="main1"></div>
            <div id="main2"></div>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>
<script>
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main1'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '本周销售展示'
        },
        tooltip: {},
        legend: {
            data: ['销量']
        },
        xAxis: {
            data: ['周一', '周二', '周三', '周四', '周五', '周六','周日']
        },
        yAxis: {},
        series: [
            {
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    var chartDom2 = document.getElementById('main2');
    var myChart2 = echarts.init(chartDom2);
    var option2;

    option2 = {
        tooltip: {
            trigger: 'item'
        },
        legend: {
            top: '5%',
            left: 'center'
        },
        series: [
            {
                name: '销量',
                type: 'pie',
                radius: ['40%', '70%'],
                avoidLabelOverlap: false,
                itemStyle: {
                    borderRadius: 10,
                    borderColor: '#fff',
                    borderWidth: 2
                },
                label: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    label: {
                        show: true,
                        fontSize: '40',
                        fontWeight: 'bold'
                    }
                },
                labelLine: {
                    show: false
                },
                data: [
                    { value: 10, name: '手枪' },
                    { value: 7, name: '步枪' },
                    { value: 5, name: '冲锋枪' },
                    { value: 4, name: '重武器' },
                    { value: 3, name: '小刀' },
                    { value: 3, name: '投掷物' }
                ]
            }
        ]
    };

    myChart2.setOption(option2);

</script>
</script>
</body>
</body>
</html>