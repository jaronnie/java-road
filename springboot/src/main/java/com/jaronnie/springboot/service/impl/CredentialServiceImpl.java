package com.jaronnie.springboot.service.impl;

import com.jaronnie.springboot.domain.bo.CredentialBo;
import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.service.ICredentialService;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceImpl implements ICredentialService {
    @Override
    public CredentialVo detail(int id) {
        CredentialVo credentialVo =  new CredentialVo();
        credentialVo.setId(id);
        credentialVo.setName("jaronnieCredential");
        return credentialVo;
    }

    @Override
    public void create(CredentialBo credentialBo) {

    }
}
