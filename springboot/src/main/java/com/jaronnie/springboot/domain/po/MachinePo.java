package com.jaronnie.springboot.domain.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@EqualsAndHashCode(callSuper = false)
@TableName(value = "machine", autoResultMap = true)
@Data
@Builder
public class MachinePo extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    private Integer credentialId;
    private String outerIp;
    private String innerIp;
    private String name;
}
