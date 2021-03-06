package com.hbjg.system.utils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "CORSFilter")
public class CORSFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String origin = req.getHeader("Origin");
        if(origin == null) {
            origin = req.getHeader("Referer");
        }
        resp.setHeader("Access-Control-Allow-Origin", origin);//这里不能写*，*代表接受所有域名访问，如写*则下面一行代码无效。谨记
        resp.setHeader("Access-Control-Allow-Credentials", "true");//true代表允许携带cookie
        //下面这两个也很关键
        resp.setHeader("Access-Control-Allow-Methods", "POST,GET,PATCH,DELETE,PUT,OPTIONS");
//        resp.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");
        resp.setHeader("Access-Control-Allow-Headers", "*");
//        resp.setHeader("Access-Control-Expose-Headers", "*");
        resp.setHeader("Access-Control-Allow-Headers", "token,content-type");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}

