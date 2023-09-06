package com.jaronnie.springboot.domain.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CredentialBo {
    @NotBlank(message = "名称不能为空")
    private String name;
    @NotBlank(message = "类型不能为空")
    private String type;
}
