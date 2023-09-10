package com.jaronnie.springboot.util.httpUtil.rest;

import com.google.gson.Gson;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import okhttp3.Headers;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

@Getter
public class Request {
    private RESTClient restClient;
    private String verb;
    private String params;
    private String subPath;
    private Object body;

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    public Request setBody(Object body) {
        this.body = body;
        return this;
    }

    public Request setVerb(String verb) {
        this.verb = verb;
        return this;
    }

    public Request buildParams(String params) {
        this.params = params;
        return this;
    }

    public Request buildSubPath(String subPath) {
        this.subPath = subPath;
        return this;
    }

    public Request buildSubPath(String subPath, ArrayList<PathParam> pathParams) {
        for (PathParam pathParam : pathParams) {
            this.subPath = subPath.replaceAll("\\{" + pathParam.getName() + "}", String.valueOf(pathParam.getValue()));
        }
        return this;
    }

    @Data
    @Builder
    public static final class PathParam {
        private String name;
        private Object value;
    }

    public String defaultUrl() throws Exception {
        if ("".equals(this.restClient.getProtocol()) || "".equals(this.restClient.getAddr()) || "".equals(this.restClient.getPort())) {
            throw new Exception("invalid url, please check your protocol and addr and port");
        }

        return this.restClient.getProtocol() +
                "://" +
                this.restClient.getAddr() +
                ":" +
                this.restClient.getPort() +
                this.getSubPath();
    }

    public okhttp3.Request buildRequest() throws Exception {
        Gson gson = new Gson();
        String jsonBody = gson.toJson(this.body);
        RequestBody requestBody = RequestBody.create(jsonBody.getBytes());
        if (Objects.equals(this.verb, "GET")) {
            requestBody = null;
        }

        okhttp3.Request.Builder reqBuilder = (new okhttp3.Request.Builder())
                .url(this.defaultUrl())
                .method(this.verb, requestBody)
                .headers(Headers.of(this.restClient.getHeaders()));
        return reqBuilder.build();
    }

    public Request call() throws Exception {
        okhttp3.Request request = this.buildRequest();
        Response res = this.restClient.getHttpClient().newCall(request).execute();
        assert res.body() != null;
        this.body = res.body().string();
        res.close();
        return this;
    }

    public Object RawResponse() {
        return this.body;
    }

    public <T> T into(Type type) {
        Gson gson = new Gson();
        Result result = gson.fromJson((String) this.body, Result.class);
        if (result.getCode() != 200) {
            return null;
        }
        Object data = result.getData();
        String jsonString = gson.toJson(data);
        return gson.fromJson(jsonString, type);
    }
}
