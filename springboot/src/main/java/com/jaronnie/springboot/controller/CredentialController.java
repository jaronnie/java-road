package com.jaronnie.springboot.controller;

import com.jaronnie.springboot.domain.bo.CredentialBo;
import com.jaronnie.springboot.domain.bo.PageQuery;
import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.domain.vo.TableDataInfo;
import com.jaronnie.springboot.service.ICredentialService;
import com.jaronnie.springboot.util.R;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1.0/credential")
public class CredentialController {
    private final ICredentialService iCredentialService;

    @GetMapping("/list")
    public R<TableDataInfo<CredentialVo>> page(@ModelAttribute PageQuery pageQuery) {
        System.out.println(pageQuery.getPageNum());
        return R.ok(iCredentialService.queryPageList(pageQuery));
    }

    @GetMapping("/{id}")
    public R<CredentialVo> detail(@PathVariable int id) {
        return R.ok(iCredentialService.detail(id));
    }

    @PostMapping("/create")
    public R<Object> create(@RequestBody CredentialBo credentialBo) {
        return iCredentialService.create(credentialBo) ?
                R.ok("ok")
                :
                R.fail("create error");
    }
}
