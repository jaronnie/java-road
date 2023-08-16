package com.jaronnie.springboot.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class SerializationUtils {
    private static final Gson gson = new Gson();

    public static String serializeToCodeDataMessage(Object object) {
        int code = 200; // 默认状态码
        String data = gson.toJson(object); // 将对象序列化为 JSON 字符串
        String message = "ok"; // 默认消息

        // 创建一个包含 code、data 和 message 的 JSON 对象
        JsonObject response = new JsonObject();
        response.addProperty("code", code);
        response.add("data", gson.fromJson(data, JsonElement.class));
        response.addProperty("message", message);

        return gson.toJson(response); // 将 JSON 对象序列化为字符串
    }
}
