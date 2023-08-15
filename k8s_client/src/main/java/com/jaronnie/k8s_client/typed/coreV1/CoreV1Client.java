package com.jaronnie.k8s_client.typed.coreV1;

public class CoreV1Client {
    public CredentialClient credential() {
        return new CredentialClient();
    }

    public MachineClient machine() {
        return new MachineClient();
    }
}
