package com.spring_boot;

import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;
import java.util.stream.Stream;


public class BookHandler {
    public  ServerResponse getAllBooks(ServerRequest request) {
        return ServerResponse.ok().body(List.of(
                new BookRouteConfig.Book("LOTR", "JK Rowling")
        ));
    }

    public ServerResponse getBook(ServerRequest request) {
        String name = request.pathVariable("name") ;
        return ServerResponse.ok().body(Stream.of(
                new BookRouteConfig.Book("LOTR", "JK Rowling")
        ).filter(book -> book.name().equals(name)).findFirst());
    }
}
