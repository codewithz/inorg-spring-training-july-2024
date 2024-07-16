package com.inorg.functional;

import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;
import java.util.stream.Stream;

public class BookHandler {

    public ServerResponse getAllBooks(ServerRequest request){

        return ServerResponse.ok().body(
                List.of(
                        new Book("Harry Potter","J.K.Rowling"),
                        new Book("Java with Z","Zartab"))
        );
    }

    public ServerResponse getBookByName(ServerRequest request){
        String name=request.pathVariable("name");

        return ServerResponse.ok().body(
                Stream.of(
                        new Book("Harry Potter","J.K.Rowling"),
                        new Book("Java with Z","Zartab"))
                        .filter(book->book.getTitle().equals(name))
                        .findFirst()
        );
    }
}
