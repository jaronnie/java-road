package com.jaronnie.springboot.service;

import com.jaronnie.springboot.domain.bo.MachineBo;
import com.jaronnie.springboot.domain.bo.PageQuery;
import com.jaronnie.springboot.domain.vo.MachineStatisticsVo;
import com.jaronnie.springboot.domain.vo.MachineVo;
import com.jaronnie.springboot.domain.vo.TableDataInfo;

import java.util.List;

public interface IMachineService {

    TableDataInfo<MachineVo> queryPageList(PageQuery pageQuery, MachineBo machineBo);

    MachineVo detail(int id);

    Boolean create(MachineBo machineBo);

    List<MachineStatisticsVo> statistics();
}
