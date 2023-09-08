package com.jaronnie.springboot;

import com.jaronnie.springboot.util.httpUtil.rest.ClientSet;
import com.jaronnie.springboot.util.httpUtil.rest.RESTClient;

public class TestMachine {


    public static void main(String[] args) {
        RESTClient restClient = RESTClient.builder().
                addr("127.0.0.1").
                port("8081").
                build();

        ClientSet clientSet = new ClientSet(restClient);

        try {
            Object object = clientSet.directClient()
                    .setVerb("GET")
                    .buildSubPath("/api/v1.0/machine/statistics")
                    .call().RawResponse();

            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
