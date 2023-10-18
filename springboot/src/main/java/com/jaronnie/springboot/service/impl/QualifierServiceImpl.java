package com.jaronnie.springboot.service.impl;

import com.jaronnie.springboot.service.QualifierService;
import org.springframework.stereotype.Service;

@Service
public class QualifierServiceImpl implements QualifierService {
    @Override
    public String getVersion() {
        return "v1";
    }
}
