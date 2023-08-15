package com.jaronnie.k8s_client;

import com.jaronnie.k8s_client.typed.coreV1.CoreV1Client;

public class ClientSet {
    public CoreV1Client coreV1() {
        return new CoreV1Client();
    }
}
