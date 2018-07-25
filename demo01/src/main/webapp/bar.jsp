<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <script src="js/echarts.min.js"></script>
    <script src="js/jquery.min.js"></script>
</head>
<body>
<div id="main" style="width: 600px; height: 400px;"></div>
<script>
    var myChart = echarts.init(document.getElementById('main'));
    var option = {
        //图表标题
        title : {
            text : 'ECharts柱状图：新闻数据访问量'
        },
//提示信息
        tooltip : {
            trigger : 'axis',//显示该列下所有坐标轴所对应的数据
            axisPointer : { // 坐标轴指示器,坐标轴触发有效
//鼠标滑过显示效果 'line'直线 | 'shadow'阴影(默认)
                type : 'shadow'
            }
        },
        //X轴数据
        xAxis : {
            data : [ "娱乐新闻", "体育新闻", "财经新闻", "其他" ]
        },
        yAxis : {},
        //系列列表
        series : [ {
            name : '访问量',//鼠标滑过数字前面的内容,“访问量：450”
            type : 'bar',//柱状图类型
//样式定制,可以自定义字体颜色,大小等属性,本例中使用默认样式
            label : {
                normal : {
                    show : true
                }
            },
            data : [ 450, 800, 300, 280 ] //每一列的数据
        } ]
    };
    //使用制定的配置项和数据显示图表(装载)
    myChart.setOption(option);
    //读取状态的动画
    myChart.showLoading()
    $.ajax({
        url:"eCharts/bar.action",
        type:"get",
        dataType:"json",
        success:function (result) {
            var x = [];
            var y = [];
            $(result).each(function (index,item){
                x.push(item.name);
                y.push(item.value);
            })
            myChart.hideLoading();
            myChart.setOption({
                xAxis : {
                    data : x
                },
                series : [ {
                    name : '数量',
                    data : y
                } ]
            });
        },
        error:function () {
            alert("加载数据失败")
        }
    })

</script>
</body>
</html>