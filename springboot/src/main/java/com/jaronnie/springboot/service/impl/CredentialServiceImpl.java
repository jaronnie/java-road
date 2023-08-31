package com.jaronnie.springboot.service.impl;

import com.jaronnie.springboot.domain.bo.CredentialBo;
import com.jaronnie.springboot.domain.po.CredentialPo;
import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.mapper.CredentialMapper;
import com.jaronnie.springboot.service.ICredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CredentialServiceImpl implements ICredentialService {

    private final CredentialMapper baseMapper;

    @Override
    public CredentialVo detail(int id) {
        CredentialPo credentialPo =  baseMapper.selectById(id);

        return CredentialVo.builder()
                .id(credentialPo.getId())
                .name(credentialPo.getName())
                .type(credentialPo.getType())
                .build();
    }

    @Override
    public void create(CredentialBo credentialBo) {

    }
}
