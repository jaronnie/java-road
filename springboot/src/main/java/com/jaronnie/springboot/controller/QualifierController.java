package com.jaronnie.springboot.controller;

import com.jaronnie.springboot.service.QualifierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("/api/v1/qualifier")
public class QualifierController {
    @Qualifier("qualifierDelegate")
    @Autowired
    private QualifierService qualifierService;

    @GetMapping("/version")
    public String version() {
        return qualifierService.getVersion();
    }
}
