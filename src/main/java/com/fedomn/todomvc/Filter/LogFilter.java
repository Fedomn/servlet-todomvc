package com.fedomn.todomvc.Filter;

import com.fedomn.todomvc.Model.Todo;
import com.fedomn.todomvc.Service.TodoService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LogFilter implements Filter {
    FilterConfig config;
    private static HashSet<String> mapping = null;

    static {
        mapping = new HashSet<String>();
        mapping.addAll(Arrays.asList("/index.jsp", "/all", "/active", "/completed"));
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("begin do the log filter!");
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取ServletContext对象 用于记录日志
        ServletContext servletContext = this.config.getServletContext();
        //将请求转换成HttpServletRequest 请求
        HttpServletRequest hreq = (HttpServletRequest) servletRequest;
        String path = hreq.getServletPath();
        //打印日志 用户请求路径
        System.out.println("Log Filter已经截获到用户的请求的地址: " + path);
        if (mapping.contains(path)) {
            try {
                servletRequest.setAttribute("todolist", getMappingList(path));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest, servletResponse);
        }
        //转发到目的地址
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        config = null;
    }


    private List<Todo> getMappingList(String url) throws SQLException {
        switch (url) {
            case "/all":
            case "/index.jsp":
                return new TodoService().getAll();
            case "/active":
                return new TodoService().getActive();
            case "/completed":
                return new TodoService().getCompleted();
        }
        return null;
    }
}
