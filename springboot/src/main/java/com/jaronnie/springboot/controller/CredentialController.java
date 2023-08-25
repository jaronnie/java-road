package com.jaronnie.springboot.controller;

import com.jaronnie.springboot.domain.bo.CredentialBo;
import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.service.ICredentialService;
import com.jaronnie.springboot.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1.0/credential")
public class CredentialController {
    private final ICredentialService iCredentialService;

    @GetMapping("/{id}")
    public R<CredentialVo> detail(@PathVariable int id) {
        return R.ok(iCredentialService.detail(id));
    }

    @PostMapping("/create")
    public void create(@RequestBody CredentialBo credentialBo) {
        System.out.println(credentialBo.getName());
    }
}
