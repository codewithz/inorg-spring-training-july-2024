package com.inorg.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(2)
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("----------My Filter Filter Starts----------");
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        request.getHeaderNames().asIterator()
//                .forEachRemaining(headerName ->
//                        System.out.println(headerName + ": " + request.getHeader(headerName)));
        System.out.println("\n\n---------My Filter Filter Ends----------");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
