package com.jaronnie.springboot.domain.po;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = false)
@TableName(value = "credential", autoResultMap = true)
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credential extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @TableId
    private Integer id;
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String name;
    @TableField(updateStrategy = FieldStrategy.NOT_EMPTY)
    private String type;
}
