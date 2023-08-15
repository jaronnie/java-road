package com.jaronnie.k8s_client;

public class Test {
    public static void main(String[] args) {
        // new ClientSet
        ClientSet clientSet = new ClientSet();
        // 调用 coreV1 服务的 credential 模块的 list 接口
        clientSet.coreV1().credential().list();
        // 调用 coreV1 服务的 machine 模块的 list 接口
        clientSet.coreV1().machine().list();
    }
}
