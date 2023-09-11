package com.jaronnie.springboot;

import com.jaronnie.springboot.domain.vo.MachineStatisticsVo;
import com.jaronnie.springboot.domain.vo.MachineVo;
import com.jaronnie.springboot.util.httpUtil.ClientSet;
import com.jaronnie.springboot.util.httpUtil.rest.RESTClient;

import java.util.ArrayList;

;

public class TestMachine {


    public static void main(String[] args) {
        RESTClient restClient = RESTClient.builder().
                addr("127.0.0.1").
                port("8081").
                build();

        ClientSet clientSet = new ClientSet(restClient);

        try {
            ArrayList<MachineStatisticsVo> machineStatisticsVos = new ArrayList<>();
            machineStatisticsVos = clientSet.directClient()
                    .setVerb("GET")
                    .buildSubPath("/api/v1.0/machine/statistics")
                    .call().into(machineStatisticsVos.getClass());

            System.out.println(machineStatisticsVos);

            MachineVo machineVo = clientSet.directClient()
                    .setVerb("GET")
                    .buildSubPath("/api/v1.0/machine/1")
                    .call().into(MachineVo.class);
            System.out.println(machineVo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
