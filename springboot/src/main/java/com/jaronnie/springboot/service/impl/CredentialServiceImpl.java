package com.jaronnie.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jaronnie.springboot.domain.bo.CredentialBo;
import com.jaronnie.springboot.domain.bo.PageQuery;
import com.jaronnie.springboot.domain.po.Credential;
import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.domain.vo.TableDataInfo;
import com.jaronnie.springboot.mapper.CredentialMapper;
import com.jaronnie.springboot.mapper.jpa.CredentialMapperJpa;
import com.jaronnie.springboot.service.ICredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.jaronnie.springboot.enumeration.errcode.CredentialErrorCodeEnum.CREDENTIAL_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class CredentialServiceImpl implements ICredentialService {

    private final CredentialMapper baseMapper;

    private final CredentialMapperJpa credentialMapperJpa;

    private LambdaQueryWrapper<Credential> buildQueryWrapper(CredentialBo credentialBo) {
        LambdaQueryWrapper<Credential> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(credentialBo.getName()), Credential::getName, credentialBo.getName());
        lqw.like(StringUtils.isNotBlank(credentialBo.getType()), Credential::getType, credentialBo.getType());
        return lqw;
    }

    @Override
    public TableDataInfo<CredentialVo> queryPageList(PageQuery pageQuery, CredentialBo credentialBo) {
        LambdaQueryWrapper<Credential> lqw = buildQueryWrapper(credentialBo);
        Page<Credential> page = baseMapper.selectPage(pageQuery.build(), lqw);

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
    public TableDataInfo<CredentialVo> queryPageListByJpa(PageQuery pageQuery, CredentialBo credentialBo) {
        Pageable pageable = PageRequest.of((pageQuery.getPageNum() - 1) * pageQuery.getPageSize(), pageQuery.getPageSize());
        List<Credential> credentialPos = credentialMapperJpa.list(pageable);
        System.out.println(credentialPos);
        return null;
    }

    @Override
    public CredentialVo detail(int id) {
        Credential credentialPo = baseMapper.selectById(id);
        if (credentialPo == null) {
            throw CREDENTIAL_NOT_EXIST.newException();
        }

        return BeanUtil.toBean(credentialPo, CredentialVo.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean create(CredentialBo credentialBo) {
        int flag = baseMapper.insert(Credential.builder()
                .name(credentialBo.getName())
                .type(credentialBo.getType())
                .build());
        return flag == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean edit(CredentialBo credentialBo, Integer id) {
        Credential credentialPo = BeanUtil.toBean(credentialBo, Credential.class);
        credentialPo.setId(id);
        return baseMapper.updateById(credentialPo) == 1;
    }
}
