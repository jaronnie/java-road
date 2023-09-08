package com.jaronnie.springboot.domain.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MachineStatisticsVo {
    private String type;
    private Integer count;
}
