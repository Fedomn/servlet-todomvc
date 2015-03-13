package com.fedomn.todomvc.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LogFilter implements Filter{
    FilterConfig config;

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
        //打印日志 用户请求路径
        System.out.println("Log Filter已经截获到用户的请求的地址: "+hreq.getServletPath());
        //转发到目的地址
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        config = null;
    }
}
