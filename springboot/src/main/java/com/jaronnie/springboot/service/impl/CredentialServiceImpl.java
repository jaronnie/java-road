package com.jaronnie.springboot.service.impl;

import com.jaronnie.springboot.domain.bo.CredentialBo;
import com.jaronnie.springboot.domain.po.CredentialPo;
import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.mapper.CredentialMapper;
import com.jaronnie.springboot.service.ICredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
public class CredentialServiceImpl implements ICredentialService {

    private final CredentialMapper baseMapper;

    @Override
    public CredentialVo detail(int id) {
        CredentialPo credentialPo =  baseMapper.selectById(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // TODO user beanCopy or define a baseMapperPlus
        return CredentialVo.builder()
                .id(credentialPo.getId())
                .name(credentialPo.getName())
                .type(credentialPo.getType())
                .createTime(dateFormat.format(credentialPo.getCreateTime()))
                .updateTime(dateFormat.format(credentialPo.getUpdateTime()))
                .build();
    }

    @Override
    public boolean create(CredentialBo credentialBo) {
        // TODO 修复无法自动更新创建时间的问题
        int flag = baseMapper.insert(CredentialPo.builder()
                        .name(credentialBo.getName())
                        .type(credentialBo.getType())
                        .build());
        return flag == 1;
    }
}
