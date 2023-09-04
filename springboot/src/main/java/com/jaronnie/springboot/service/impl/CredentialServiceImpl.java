package com.jaronnie.springboot.service.impl;

import cn.hutool.core.bean.BeanUtil;
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

@Service
@RequiredArgsConstructor
public class CredentialServiceImpl implements ICredentialService {

    private final CredentialMapper baseMapper;

    @Override
    public TableDataInfo<CredentialVo> queryPageList(PageQuery pageQuery) {
        Page<CredentialPo> page = new Page<>(pageQuery.getPageNum(), pageQuery.getPageSize());
        baseMapper.selectPage(page, null);
        return null;
    }

    @Override
    public CredentialVo detail(int id) {
        CredentialPo credentialPo = baseMapper.selectById(id);
        return BeanUtil.toBean(credentialPo, CredentialVo.class);
    }

    @Override
    public boolean create(CredentialBo credentialBo) {
        int flag = baseMapper.insert(CredentialPo.builder()
                .name(credentialBo.getName())
                .type(credentialBo.getType())
                .build());
        return flag == 1;
    }
}
