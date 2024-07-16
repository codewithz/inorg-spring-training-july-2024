package com.inorg.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@Order(1)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
            System.out.println("----------Logging Filter----------");
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            request.getHeaderNames().asIterator()
                    .forEachRemaining(headerName ->
                            System.out.println(headerName + ": " + request.getHeader(headerName)));

            String codewithz=request.getHeader("codewithz");
            if(codewithz!=null && codewithz.equals("reject")){
                response.sendError(403,"Forbidden");
            }

            filterChain.doFilter(servletRequest, servletResponse);
    }
}
