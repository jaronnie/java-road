package com.jaronnie.springboot.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CredentialVo {
    private int id;
    private String name;
    private String type;
    private Date createTime;
    private Date updateTime;
}