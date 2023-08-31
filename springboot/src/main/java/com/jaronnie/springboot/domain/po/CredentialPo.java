package com.jaronnie.springboot.domain.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "credential", autoResultMap = true)
@Data
public class CredentialPo {
    @TableId
    private int id;
    private String name;
    private String type;
}
