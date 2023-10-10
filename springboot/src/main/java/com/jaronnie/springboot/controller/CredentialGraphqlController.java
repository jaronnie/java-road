package com.jaronnie.springboot.controller;

import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.service.ICredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CredentialGraphqlController {
    private final ICredentialService iCredentialService;

    @QueryMapping
    public CredentialVo credentialDetail(@Argument Integer id) {
        return iCredentialService.detail(id);
    }
}
