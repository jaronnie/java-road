package com.jaronnie.springboot.domain.vo;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class AuthorVo {
    private String id;
    private String firstName;
    private String lastName;

    public AuthorVo(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private static final List<AuthorVo> authors = Arrays.asList(
            new AuthorVo("author-1", "Joanne", "Rowling"),
            new AuthorVo("author-2", "Herman", "Melville"),
            new AuthorVo("author-3", "Anne", "Rice")
    );

    public static AuthorVo getById(String id) {
        return authors.stream().filter(author -> author.getId().equals(id)).findFirst().orElse(null);
    }

}
