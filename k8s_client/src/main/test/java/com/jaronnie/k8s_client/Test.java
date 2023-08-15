package com.jaronnie.k8s_client;

import com.jaronnie.k8s_client.models.coreV1.Credential;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // new ClientSet
        ClientSet clientSet = new ClientSet();
        // 调用 coreV1 服务的 credential 模块的 list 接口
        ArrayList<Credential> list = clientSet.coreV1().credential().list();
        for (Credential credential : list) {
            System.out.println(credential.toString());
        }

        // 调用 coreV1 服务的 machine 模块的 list 接口
        clientSet.coreV1().machine().list();
    }
}
