<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <title>Goddess注册页面</title>
  <link rel="stylesheet" href="<%=basePath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>

<div class="page-header">
  <h1 class="text-center">Goddess注册页面</h1>
</div>
  <%=request.getParameter("new-todo")%>

</body>
</html>

