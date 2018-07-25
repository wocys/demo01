<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#daochu").click(function () {
                $.ajax({
                    url:"/user/daochuExcel.action",
                    success:function (data) {
                        alert(data);
                    },
                    error:function () {
                        alert("加载数据失败")
                    }
                })
            });
        })
    </script>
</head>
<body>
<div>
    <form enctype="multipart/form-data" method="post" action="/user/uploadExcel.action">
        <input type="file" name="excel"/>
        <input type="submit">
    </form>
    <button id="daochu">导出</button>
</div>
<table border="1">
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
    <c:forEach items="${users}" var="item">
        <tr>
            <td>${item.person_id}</td>
            <td>${item.name}</td>
            <td>${item.age}</td>
            <td><fmt:formatDate value="${item.birthday}" pattern="yyyy年MM月dd日" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
