package com.jaronnie.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaronnie.springboot.domain.bo.CredentialBo;
import com.jaronnie.springboot.domain.bo.PageQuery;
import com.jaronnie.springboot.domain.po.CredentialPo;
import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.domain.vo.TableDataInfo;
import com.jaronnie.springboot.mapper.CredentialMapper;
import com.jaronnie.springboot.service.ICredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CredentialServiceImpl implements ICredentialService {

    private final CredentialMapper baseMapper;

    private LambdaQueryWrapper<CredentialPo> buildQueryWrapper(CredentialBo credentialBo) {
        LambdaQueryWrapper<CredentialPo> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(credentialBo.getName()), CredentialPo::getName, credentialBo.getName());
        lqw.like(StringUtils.isNotBlank(credentialBo.getType()), CredentialPo::getType, credentialBo.getType());
        return lqw;
    }

    @Override
    public TableDataInfo<CredentialVo> queryPageList(PageQuery pageQuery, CredentialBo credentialBo) {
        LambdaQueryWrapper<CredentialPo> lqw = buildQueryWrapper(credentialBo);
        Page<CredentialPo> page = baseMapper.selectPage(pageQuery.build(), lqw);

        TableDataInfo<CredentialVo> credentialVoTableDataInfo = new TableDataInfo<>();
        credentialVoTableDataInfo.setTotal(page.getTotal());
        List<CredentialVo> result = page.getRecords().stream().map(credentialPo -> CredentialVo.builder()
                .id(credentialPo.getId())
                .type(credentialPo.getType())
                .name(credentialPo.getName())
                .createTime(credentialPo.getCreateTime())
                .updateTime(credentialPo.getUpdateTime())
                .build()).collect(Collectors.toList());
        credentialVoTableDataInfo.setRows(result);
        return credentialVoTableDataInfo;
    }

    @Override
    public CredentialVo detail(int id) {
        CredentialPo credentialPo = baseMapper.selectById(id);
        return BeanUtil.toBean(credentialPo, CredentialVo.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean create(CredentialBo credentialBo) {
        int flag = baseMapper.insert(CredentialPo.builder()
                .name(credentialBo.getName())
                .type(credentialBo.getType())
                .build());
        return flag == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean edit(CredentialBo credentialBo, Integer id) {
        CredentialPo credentialPo = BeanUtil.toBean(credentialBo, CredentialPo.class);
        credentialPo.setId(id);
        return baseMapper.updateById(credentialPo) == 1;
    }
}
