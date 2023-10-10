package com.jaronnie.springboot.controller;

import com.jaronnie.springboot.domain.vo.AuthorVo;
import com.jaronnie.springboot.domain.vo.BookVo;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GraphqlController {
    @QueryMapping
    public BookVo bookById(@Argument String id) {
        return BookVo.getById(id);
    }

    @SchemaMapping
    public AuthorVo author(BookVo book) {
        return AuthorVo.getById(book.getAuthorId());
    }
}
