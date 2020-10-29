package com.onlinecode.core.config.WebMvcConfigAdapter;


import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class WebMvcConfigAdapter extends org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter {
    @Component
    @Order(Ordered.HIGHEST_PRECEDENCE)
    class CorsFilter implements Filter {

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {}

        @Override
        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
                throws IOException, ServletException {
            HttpServletResponse response = (HttpServletResponse) res;
            HttpServletRequest request = (HttpServletRequest) req;

            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
            response.setHeader("Access-Control-Max-Age", "3600");

            if("*/*".equals(request.getHeader("Accept"))) {
                response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            }
            else {
                response.setHeader("Access-Control-Allow-Origin", "*");

            }

            if (!"OPTIONS".equals(request.getMethod())) {
                chain.doFilter(req, res);
            } else {
            }
        }

        @Override
        public void destroy() {}
    }
}
