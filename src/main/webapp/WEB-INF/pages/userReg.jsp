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

<form method="post" action="dologin.jsp">

  <div class="row">
    <div class="form-group col-md-3 col-md-offset-4">
      <div class="input-group">
        <span class="input-group-addon" id="sizing-addon1">姓名：</span>
        <input name="username" type="text" class="form-control" aria-describedby="sizing-addon1">
      </div>
      <br>
      <div class="input-group">
        <span class="input-group-addon" id="sizing-addon2">密码：</span>
        <input name="password" type="password" class="form-control" aria-describedby="sizing-addon2">
      </div>
    </div>
  </div>
  <div class="row">
    <div class="col-md-offset-7">
      <button type="submit" class="btn btn-primary vertical-space">注册</button>
    </div>
  </div>


</form>

</body>
</html>

