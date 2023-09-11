package com.manieri.projetoaraucaria.requests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Requests {

    private static final String userlink = CREDENTIALS.userlink;
    private static final String username = CREDENTIALS.username;
    private static final String password = CREDENTIALS.password;

    public static int REQUEST_STATUS_CODE;

    public JsonNode POST(String endpoint, String data) throws IOException {

        String apiUrl = userlink + endpoint;
        byte[] postData = data.getBytes(StandardCharsets.UTF_8);
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));

        try (OutputStream os = connection.getOutputStream()) {
            os.write(postData);
        }

        return getJsonNode(connection);
    }

    public int PUT(String endpoint, String parameters) throws IOException{

        String apiUrl = userlink + endpoint;
        byte[] postData = parameters.getBytes(StandardCharsets.UTF_8);
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));

        try (OutputStream os = connection.getOutputStream()) {
            os.write(postData);
        }
        getJsonNode(connection);

        return REQUEST_STATUS_CODE;
    }

    public JsonNode GET(String endpoint) throws IOException {
        String apiUrl = userlink + endpoint;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes()));

        return getJsonNode(connection);
    }

    private JsonNode getJsonNode(HttpURLConnection connection) throws IOException {

        /** -> Return CODE **/
        REQUEST_STATUS_CODE = connection.getResponseCode();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(response.toString());
            connection.disconnect();

            return jsonResponse;
        }
    }

}
