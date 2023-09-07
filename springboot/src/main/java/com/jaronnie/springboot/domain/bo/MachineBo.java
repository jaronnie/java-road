package com.jaronnie.springboot.domain.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class MachineBo {
    @NotBlank(message = "名称不能为空")
    private String name;
}
