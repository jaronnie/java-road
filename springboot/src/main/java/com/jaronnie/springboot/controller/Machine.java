package com.jaronnie.springboot.controller;

import com.jaronnie.springboot.domain.vo.MachineVo;
import com.jaronnie.springboot.util.SerializationUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/machine")
public class Machine {
    @RequestMapping("/{id}")
    public String detail(@PathVariable int id) {
        MachineVo machineVo =  new MachineVo();
        machineVo.setId(id);
        machineVo.setName("jaronnieMachine");
        return SerializationUtils.serializeToCodeDataMessage(machineVo);
    }
}
