package com.jaronnie.springboot.controller;

import com.jaronnie.springboot.domain.bo.CredentialBo;
import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.util.SerializationUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1.0/credential")
public class Credential {
    @GetMapping("/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request) {

        System.out.println(request.getHeader("Content-Type"));
        System.out.println(request.getHeader("version"));

        CredentialVo credentialVo =  new CredentialVo();
        credentialVo.setId(id);
        credentialVo.setName("jaronnieCredential");
        return SerializationUtils.serializeToCodeDataMessage(credentialVo);
    }

    @PostMapping("/create")
    public void create(@RequestBody CredentialBo credentialBo) {
        System.out.println(credentialBo.getName());
    }
}
