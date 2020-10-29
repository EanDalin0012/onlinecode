package com.onlinecode.core.config;

import com.onlinecode.admins.api.CategoryController;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@WebFilter("/*")
public class CorsFilter{
//        implements Filter {
//    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        final HttpServletResponse response = (HttpServletResponse) res;
//        log.info("========Start file http method "+((HttpServletRequest) req).getMethod()+"===========");
//        response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
//        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Allow-Headers", "*");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Cache-Control", "no-cache");
//
//        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
//            log.info("HHTTp OB"+((HttpServletRequest) req).getMethod());
//            response.setStatus(HttpServletResponse.SC_OK);
//        } else {
//            chain.doFilter(req, res);
//        }
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
}
