package com.jaronnie.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaronnie.springboot.domain.bo.MachineBo;
import com.jaronnie.springboot.domain.bo.PageQuery;
import com.jaronnie.springboot.domain.po.MachinePo;
import com.jaronnie.springboot.domain.vo.MachineStatisticsVo;
import com.jaronnie.springboot.domain.vo.MachineVo;
import com.jaronnie.springboot.domain.vo.TableDataInfo;
import com.jaronnie.springboot.mapper.MachineMapper;
import com.jaronnie.springboot.service.IMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MachineServiceImpl implements IMachineService {

    private final MachineMapper baseMapper;

    private LambdaQueryWrapper<MachinePo> buildQueryWrapper(MachineBo machineBo) {
        LambdaQueryWrapper<MachinePo> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(machineBo.getName()), MachinePo::getName, machineBo.getName());
        return lqw;
    }

    @Override
    public TableDataInfo<MachineVo> queryPageList(PageQuery pageQuery, MachineBo machineBo) {
        LambdaQueryWrapper<MachinePo> lqw = buildQueryWrapper(machineBo);
        /*
          联表查询出 credential type 为 k8s 的 machine
          String credentialType = "k8s";
          lqw.inSql(MachinePo::getCredentialId, "SELECT id FROM credential WHERE type = '" + credentialType + "'");
         */

        Page<MachinePo> page = baseMapper.selectPage(pageQuery.build(), lqw);

        TableDataInfo<MachineVo> machineVoTableDataInfo = new TableDataInfo<>();
        machineVoTableDataInfo.setTotal(page.getTotal());
        List<MachineVo> result = page.getRecords().stream().map(machinePo -> MachineVo.builder()
                .id(machinePo.getId())
                .credentialId(machinePo.getCredentialId())
                .name(machinePo.getName())
                .outerIp(machinePo.getOuterIp())
                .innerIp(machinePo.getInnerIp())
                .createTime(machinePo.getCreateTime())
                .updateTime(machinePo.getUpdateTime())
                .build()).collect(Collectors.toList());
        machineVoTableDataInfo.setRows(result);
        return machineVoTableDataInfo;
    }

    @Override
    public MachineVo detail(int id) {
        MachinePo machinePo = baseMapper.selectById(id);
        return BeanUtil.toBean(machinePo, MachineVo.class);
    }

    @Override
    public Boolean create(MachineBo machineBo) {
        int flag = baseMapper.insert(MachinePo.builder()
                .name(machineBo.getName())
                .build());
        return flag == 1;
    }

    @Override
    public List<MachineStatisticsVo> statistics() {
        return baseMapper.getCountByCredentialType();
    }
}
