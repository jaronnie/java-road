package com.jaronnie.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {
    public static class Struct {
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        private String name;
        private int id;
    }

    @RequestMapping("/say")
    public JSONObject say() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",200);
        jsonObject.put("message", "ok");
        Struct struct = new Struct();
        struct.setId(1);
        struct.setName("jaronnie");
        JSONObject structJson = new JSONObject();
        structJson.put("id", struct.id);
        structJson.put("name", struct.name);
        jsonObject.put("data", structJson);

        return jsonObject;
    }
}
