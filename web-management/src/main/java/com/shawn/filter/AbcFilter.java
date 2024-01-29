package com.shawn.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * 执行流程：
 * 请求->放行前逻辑->放行->资源->放行后逻辑
 * 介绍：一个web应用中，可以配置多个过滤器，这多个过滤器就形成了一个过滤器链
 * 顺序：注解配置的Filter，优先级是按照过滤器类名（字符串）的自然顺序
 */
//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("拦截到了请求...放行前逻辑");
        // 放行
        chain.doFilter(request,response);
        System.out.println("拦截到了请求，放行后逻辑");
    }
}
