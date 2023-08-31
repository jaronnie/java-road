package com.jaronnie.springboot.domain.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@TableName(value = "credential", autoResultMap = true)
@Data
@Builder
public class CredentialPo extends BaseEntity {
    @TableId
    private int id;
    private String name;
    private String type;
    private Date createTime;
    private Date updateTime;
}
