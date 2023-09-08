package com.manieri.projetoaraucaria.requests.login;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manieri.projetoaraucaria.requests.CREDENTIALS;
import com.manieri.projetoaraucaria.requests.Requests;

import java.io.IOException;

public class LoginRequest extends Requests {

    public void checkLogin() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonData = objectMapper.createObjectNode()
                .put("username", CREDENTIALS.username)
                .put("password", CREDENTIALS.username);

        ObjectNode payload = objectMapper.createObjectNode();
        payload.set("time_entry", jsonData);
        String data = objectMapper.writeValueAsString(payload);
        System.out.println(POST("/login.json",data));
    }

}
