package com.jaronnie.k8s_client.typed.coreV1;

import com.jaronnie.k8s_client.models.coreV1.Credential;

import java.util.ArrayList;

public class CredentialClient {
    public ArrayList<Credential> list() {
        // 创建一个空的 ArrayList
        ArrayList<Credential> credentials = new ArrayList<>();

        Credential credential = new Credential();
        credential.setName("jaronnie");
        credential.setId(1);

        credentials.add(credential);
        return credentials;
    }

    public Credential detail() {
        return new Credential();
    }
}
