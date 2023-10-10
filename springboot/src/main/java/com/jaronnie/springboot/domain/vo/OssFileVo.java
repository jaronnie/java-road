package com.jaronnie.springboot.domain.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OssFileVo {
    String url;
    String name;
    Date uploadTime;
}
