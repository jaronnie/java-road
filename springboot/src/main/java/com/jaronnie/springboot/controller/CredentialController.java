package com.jaronnie.springboot.controller;

import com.jaronnie.springboot.domain.bo.CredentialBo;
import com.jaronnie.springboot.domain.bo.PageQuery;
import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.domain.vo.TableDataInfo;
import com.jaronnie.springboot.service.ICredentialService;
import com.jaronnie.springboot.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1.0/credential")
public class CredentialController {
    private final ICredentialService iCredentialService;

    @GetMapping("/list")
    public R<TableDataInfo<CredentialVo>> page(@ModelAttribute PageQuery pageQuery, @ModelAttribute CredentialBo credentialBo) {
        return R.ok(iCredentialService.queryPageList(pageQuery, credentialBo));
    }

    @GetMapping("/listByJpa")
    public R<TableDataInfo<CredentialVo>> pageByType(@ModelAttribute PageQuery pageQuery, @ModelAttribute CredentialBo credentialBo) {
        return R.ok(iCredentialService.queryPageListByJpa(pageQuery, credentialBo));
    }

    @GetMapping("/{id}")
    public R<CredentialVo> detail(@PathVariable int id) {
        return R.ok(iCredentialService.detail(id));
    }

    @PostMapping("/create")
    public R<Boolean> create(@Validated @RequestBody CredentialBo credentialBo) {
        return R.ok(iCredentialService.create(credentialBo));
    }

    @PostMapping("/edit/{id}")
    public R<Boolean> edit(@RequestBody CredentialBo credentialBo, @PathVariable Integer id) {
        return R.ok(iCredentialService.edit(credentialBo, id));
    }
}
