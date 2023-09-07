package com.jaronnie.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jaronnie.springboot.domain.po.MachinePo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MachineMapper extends BaseMapper<MachinePo> {

}

