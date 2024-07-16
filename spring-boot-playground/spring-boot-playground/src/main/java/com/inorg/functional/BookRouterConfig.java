package com.inorg.functional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class BookRouterConfig {


    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        BookHandler handler = new BookHandler();
        return RouterFunctions.route()
                .GET("/books",handler::getAllBooks)
                .GET("/books/{name}",handler::getBookByName)
                .build();
    }

}
