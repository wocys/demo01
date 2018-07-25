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
    option = {
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [/*820, 932, 901, 934, 1290, 1330, 1320*/],
            type: 'line'
        }]
    };

    myChart.setOption(option);
    myChart.showLoading();

    $.ajax({
        url:"eCharts/bing.action",
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