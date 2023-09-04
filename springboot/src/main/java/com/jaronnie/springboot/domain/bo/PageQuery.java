package com.jaronnie.springboot.domain.bo;

import lombok.Data;

@Data
public class PageQuery {
    private int pageNum;
    private int pageSize;
}
