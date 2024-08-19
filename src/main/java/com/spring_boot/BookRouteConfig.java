package com.spring_boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

@Configuration
public class BookRouteConfig {
    record Book(String name,String author){};

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        BookHandler bookHandler = new BookHandler();
        return RouterFunctions.route()
                .GET("/api/v1/FEbooks", bookHandler::getAllBooks)
                .GET("/api/v1/FEbooks/{name}",bookHandler::getBook)
                .build();
    }


}
