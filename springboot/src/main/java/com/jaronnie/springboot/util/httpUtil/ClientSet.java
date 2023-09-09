package com.jaronnie.springboot.util.httpUtil;


import com.jaronnie.springboot.util.httpUtil.rest.RESTClient;
import com.jaronnie.springboot.util.httpUtil.rest.Request;
import com.jaronnie.springboot.util.httpUtil.typed.DirectClient;

import java.util.HashMap;
import java.util.Objects;

public class ClientSet {
    private final DirectClient directClient;

    public ClientSet(RESTClient restClient) {
        if (restClient.getHttpClient() == null) {
            restClient.defaultHttpClient();
        }

        if (Objects.equals(restClient.getProtocol(), null)) {
            restClient.setProtocol("http");
        }
        if (Objects.equals(restClient.getPort(), null)) {
            restClient.setPort("80");
        }

        if (restClient.getHeaders() == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("version", "v0.0.1-SNAPSHOT");
            restClient.setHeaders(hashMap);
        }
        this.directClient = DirectClient.NewForConfig(restClient);
    }

    public Request directClient() {
        Request request = new Request();
        request.setRestClient(this.directClient.restClient().getRestClient());
        return request;
    }
}