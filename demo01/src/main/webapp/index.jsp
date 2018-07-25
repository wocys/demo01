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
<a href="bar.jsp">树状图</a>
<a href="bing.jsp">饼状图</a>
<a href="line.jsp">折线图</a>
<a href="user/getAll.action">查询用户信息</a>
    <p>牛逼啊</P>
</body>
</html>
