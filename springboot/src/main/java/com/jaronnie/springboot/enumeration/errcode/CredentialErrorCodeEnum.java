package com.jaronnie.springboot.enumeration.errcode;

import com.jaronnie.springboot.component.exception.assertion.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CredentialErrorCodeEnum implements BusinessExceptionAssert {
    CREDENTIAL_NOT_EXIST(10001, "凭证不存在");

    private final int code;
    private final String message;
}
