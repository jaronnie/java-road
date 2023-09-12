package com.jaronnie.springboot;

import com.google.gson.reflect.TypeToken;
import com.jaronnie.springboot.domain.vo.MachineStatisticsVo;
import com.jaronnie.springboot.domain.vo.MachineVo;
import com.jaronnie.springboot.util.httpUtil.ClientSet;
import com.jaronnie.springboot.util.httpUtil.rest.RESTClient;

import java.util.ArrayList;

public class TestMachine {


    public static void main(String[] args) {
        RESTClient restClient = RESTClient.builder().
                addr("127.0.0.1").
                port("8081").
                build();

        ClientSet clientSet = new ClientSet(restClient);

        try {
            ArrayList<MachineStatisticsVo> machineStatisticsVos = clientSet.directClient()
                    .setVerb("GET")
                    .buildSubPath("/api/v1.0/machine/statistics")
                    .call().into(new TypeToken<ArrayList<MachineStatisticsVo>>() {
                    }.getType());

            System.out.println(machineStatisticsVos.get(0).getType());

            MachineVo machineVo = clientSet.directClient()
                    .setVerb("GET")
                    .buildSubPath("/api/v1.0/machine/1")
                    .call().into(new TypeToken<MachineVo>() {
                    }.getType());
            System.out.println(machineVo.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
