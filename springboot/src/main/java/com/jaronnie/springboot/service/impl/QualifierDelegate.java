package com.jaronnie.springboot.service.impl;

import com.jaronnie.springboot.service.QualifierService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class QualifierDelegate implements QualifierService {
    final QualifierService qualifierService;

    public QualifierDelegate(@Qualifier(value = "qualifierServiceImpl") QualifierService qualifierService) {
        this.qualifierService = qualifierService;
    }

    @Override
    public String getVersion() {
        System.out.println("get version");
        return qualifierService.getVersion();
    }
}
