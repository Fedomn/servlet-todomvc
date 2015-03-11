<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<head>
    <title>start page</title>
</head>


<body>
    <a class="btn btn-block" href="<%=basePath%>index"><h1>Goddess userList</h1></a>

</body>
</html>
