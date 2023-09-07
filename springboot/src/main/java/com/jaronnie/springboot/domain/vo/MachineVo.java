package com.jaronnie.springboot.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MachineVo {
    private int id;
    private int credentialId;
    private String name;
    private String outerIp;
    private String innerIp;
    private Date createTime;
    private Date updateTime;
}