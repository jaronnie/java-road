package com.jaronnie.springboot.controller;

import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.util.SerializationUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/credential")
public class Credential {
    @RequestMapping("/{id}")
    public String detail(@PathVariable int id) {
        CredentialVo credentialVo =  new CredentialVo();
        credentialVo.setId(id);
        credentialVo.setName("jaronnieCredential");
        return SerializationUtils.serializeToCodeDataMessage(credentialVo);
    }
}
