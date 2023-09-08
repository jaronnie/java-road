package com.jaronnie.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jaronnie.springboot.domain.po.MachinePo;
import com.jaronnie.springboot.domain.vo.MachineStatisticsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MachineMapper extends BaseMapper<MachinePo> {
    @Select("SELECT credential.type, COUNT(*) AS count " +
            "FROM machine " +
            "LEFT JOIN credential ON machine.credential_id = credential.id " +
            "GROUP BY credential.type")
    List<MachineStatisticsVo> getCountByCredentialType();
}

