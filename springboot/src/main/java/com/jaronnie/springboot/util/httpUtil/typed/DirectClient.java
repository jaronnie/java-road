package com.jaronnie.springboot.util.httpUtil.typed;

import com.jaronnie.springboot.util.httpUtil.rest.RESTClient;
import com.jaronnie.springboot.util.httpUtil.rest.Request;

public class DirectClient {
    private final RESTClient restClient;

    public DirectClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    public Request restClient() {
        Request request = new Request();
        request.setRestClient(this.restClient);
        return request;
    }

    public static DirectClient NewForConfig(RESTClient restClient) {
        return new DirectClient(restClient);
    }
}
