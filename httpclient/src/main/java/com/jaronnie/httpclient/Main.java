package com.jaronnie.httpclient;

import java.io.IOException;

import com.alibaba.fastjson.JSON;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Main {

    public static class Response {
        private int code;
        private String message;
        private String  data;

        public Response(int code, String message, String data) {
            this.code = code;
            this.message = message;
            this.data = data;
        }

        public Response() {}

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getData() {
            return data;
        }

        public void setData(String  data) {
            this.data = data;
        }
    }
    
    public static void main(String[] args) throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8080/hello/say");

        HttpResponse response = httpClient.execute(httpGet);

        Response res = new Response();
        res = JSON.parseObject(new String(EntityUtils.toByteArray(response.getEntity())), Response.class);

         // close
        httpClient.close();

        System.out.println(res.code);
    }
}
