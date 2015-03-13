<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.fedomn.todomvc.Model.Todo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fedomn.todomvc.Service.TodoService" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<head>
    <title>TodoMVC</title>
    <link rel="stylesheet" href="<%=basePath%>bower_components/todomvc-common/base.css">
    <link rel="stylesheet" href="<%=basePath%>bower_components/todomvc-app-css/index.css">
</head>


<body>
<%
    List<Todo> allTodo = new TodoService().getAll();
%>

    <%--<a class="btn btn-block btn-lg" href="<%=basePath%>index"><h1>Goddess userList</h1></a>--%>
    <section id="todoapp">
        <header id="header">
            <h1>todos</h1>
            <input id="new-todo" placeholder="What needs to be done?" autofocus>
        </header>

        <section id="main">
            <input id="toggle-all" type="checkbox">

            <ul id="todo-list">
                <c:forEach items="<%=allTodo%>" var="todo">
                    <li class="active" data-id="${todo.id}">
                    <div class="view">
                        <input class="toggle" type="checkbox">
                        <label>${todo.title}</label>
                        <button class="destroy"></button>
                    </div>
                    <input class="edit" value="${todo.title}">
                    </li>
                </c:forEach>
            </ul>
        </section>

        <footer id="footer">
            <span id="todo-count"><strong><%=allTodo.size()%></strong> items left</span>
            <ul id="filters">
                <li>
                    <a href="#/all">All</a>
                </li>
                <li>
                    <a href="#/active">Active</a>
                </li>
                <li>
                    <a href="#/completed">Completed</a>
                </li>
            </ul>
            <button id="clear-completed">Clear completed</button>
        </footer>
    </section>




    <footer id="info">
        <p>Double-click to edit a todo</p>
        <p>Part of <a href="http://todomvc.com">TodoMVC</a></p>
    </footer>

    <script src="<%=basePath%>bower_components/jquery/dist/jquery.min.js"></script>
    <script src="<%=basePath%>bower_components/jquery/dist/jquery.cookie.js"></script>
    <script src="<%=basePath%>static/js/index.js"></script>

</body>
</html>
