package com.jaronnie.springboot.service;

import com.jaronnie.springboot.domain.bo.CredentialBo;
import com.jaronnie.springboot.domain.bo.PageQuery;
import com.jaronnie.springboot.domain.vo.CredentialVo;
import com.jaronnie.springboot.domain.vo.TableDataInfo;

public interface ICredentialService {

    TableDataInfo<CredentialVo> queryPageList(PageQuery pageQuery, CredentialBo credentialBo);

    TableDataInfo<CredentialVo> queryPageListByJpa(PageQuery pageQuery, CredentialBo credentialBo);

    CredentialVo detail(int id);

    Boolean create(CredentialBo credentialBo);

    Boolean edit(CredentialBo credentialBo, Integer id);
}
