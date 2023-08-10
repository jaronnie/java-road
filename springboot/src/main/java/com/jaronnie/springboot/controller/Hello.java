package com.jaronnie.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {
    @RequestMapping("say")
    public String say() {
        return "hello world";
    }
}
