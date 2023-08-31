package com.jaronnie.springboot.domain.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CredentialVo {
    private int id;
    private String name;
    private String type;
}