package com.jaronnie.springboot.service;

import com.jaronnie.springboot.domain.bo.MachineBo;
import com.jaronnie.springboot.domain.bo.PageQuery;
import com.jaronnie.springboot.domain.vo.MachineVo;
import com.jaronnie.springboot.domain.vo.TableDataInfo;

public interface IMachineService {

    TableDataInfo<MachineVo> queryPageList(PageQuery pageQuery, MachineBo machineBo);

    MachineVo detail(int id);

    boolean create(MachineBo machineBo);
}
