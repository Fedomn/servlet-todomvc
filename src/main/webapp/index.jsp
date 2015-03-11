<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<head>
    <title>start page</title>
    <link rel="stylesheet" href="<%=basePath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
</head>


<body>
    <%--<a class="btn btn-block btn-lg" href="<%=basePath%>index"><h1>Goddess userList</h1></a>--%>




</body>
</html>
