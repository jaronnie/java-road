package com.jaronnie.springboot.util.httpUtil.rest;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String message;
    private Object data;
}