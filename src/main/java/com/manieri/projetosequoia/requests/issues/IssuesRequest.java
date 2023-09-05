package com.manieri.projetosequoia.requests.issues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manieri.projetosequoia.model.Issues;
import com.manieri.projetosequoia.model.Project;
import com.manieri.projetosequoia.model.Status;
import com.manieri.projetosequoia.requests.Requests;

import java.io.IOException;
import java.util.ArrayList;

public class IssuesRequest extends Requests {

    public ArrayList<Issues> getAllIssues() throws IOException {
        ArrayList<Issues> issuesList = new ArrayList<>();
        var response = GET("issues.json?assigned_to_id=me&status_id=2|3");
        response.get("issues").forEach(resp -> {
            issuesList.add(new Issues(
                    resp.get("parent").get("id").intValue(),
                    new Status(
                            resp.get("status").get("id").intValue(),
                            resp.get("status").get("name").toString().replace("\"", ""),
                            resp.get("status").get("is_closed").booleanValue()),
                    new Project(
                            resp.get("project").get("id").intValue(),
                            resp.get("project").get("name").toString().replace("\"", "")
                    ),
                    resp.get("subject").toString().replace("\"", "")
            ));
        });
        return issuesList;
    }

    public ArrayList<Issues> insertIssues(int issue_id, String date, String hours, String comment) throws IOException {
        ArrayList<Issues> issuesList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonData = objectMapper.createObjectNode()
                .put("issue_id", issue_id)
                .put("spent_on", date)
                .put("hours", hours)
                .put("activity_id", 1)
                .put("comments", comment);

        ObjectNode payload = objectMapper.createObjectNode();
        payload.set("time_entry", jsonData);
        String data = objectMapper.writeValueAsString(payload);
        POST("time_entries.json", data);

        return issuesList;
    }


}
