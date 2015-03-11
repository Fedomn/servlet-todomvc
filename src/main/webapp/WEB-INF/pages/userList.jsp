<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fedomn.todomvc.Model.Goddess" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Goddess成员列表</title>
  <link rel="stylesheet" href="<%=basePath%>bower_components/bootstrap/dist/css/bootstrap.min.css">
</head>
<body>
<%
  List<Goddess> goddessList = (List<Goddess>) request.getAttribute("goddessList");
%>
<div class="container">
  <div class="panel-default">
    <div class="panel-heading">
      <h4>Goddess成员列表</h4>
    </div>
    <div class="panel-body">
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>姓名</th>
            <th>年纪</th>
            <th>生日</th>
            <th>Email</th>
            <th>电话</th>
          </tr>
        </thead>
        <tbody id="user-body">
          <c:forEach items="<%=goddessList%>" var="goddess">
            <script type="text/javascript">
              console.log(${goddess});
            </script>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>


  <script src="<%=basePath%>static/js/index.js"></script>
    <script src="<%=basePath%>bower_components/jquery/dist/jquery.min.js"></script>
</body>
</html>
