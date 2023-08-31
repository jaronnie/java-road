package com.jaronnie.springboot.service;

import com.jaronnie.springboot.domain.bo.CredentialBo;
import com.jaronnie.springboot.domain.vo.CredentialVo;

public interface ICredentialService {
    CredentialVo detail(int id);

    boolean create(CredentialBo credentialBo);
}
