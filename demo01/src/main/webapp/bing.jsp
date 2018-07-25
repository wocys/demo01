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
    $.ajax({
        url:"eCharts/bing.action",
        type:"get",
        dataType:"json",
        success:function (result) {
            myChart.hideLoading();
            myChart.setOption({
                series : [ {
                    data : result
                } ]
            })
        },
        error:function () {
            alert("加载数据失败")
        }
    })
    var myChart = echarts.init(document.getElementById('main'));
    var option = {
        title : {
            text : 'ECharts饼状图：姚泽英偏科情况'
        },
        series : [ {
            name : '分数',
            type : 'pie',
            itemStyle : {
                normal : {
                    label : {
                        show : true,
                        //格式器
                        formatter : '{b} : {c} ({d}%)'
                    },
                    labelLine : {
                        show : true
                    }
                }
            },
            //设定图表的缩放比例
            radius : '80%',
        } ]
    };
    myChart.setOption(option);
    myChart.showLoading();

</script>
</body>
</html>