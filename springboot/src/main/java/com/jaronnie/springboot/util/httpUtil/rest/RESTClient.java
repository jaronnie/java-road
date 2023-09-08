package com.jaronnie.springboot.util.httpUtil.rest;

import lombok.Builder;
import lombok.Data;
import okhttp3.OkHttpClient;

import java.util.Map;

@Data
@Builder
public class RESTClient {
    private String protocol;
    private String addr;
    private String port;
    private Map<String, String> headers;
    private OkHttpClient httpClient;

    public void defaultHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        this.setHttpClient(builder.build());
    }
}