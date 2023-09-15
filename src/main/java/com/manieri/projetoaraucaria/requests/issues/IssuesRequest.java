package com.manieri.projetoaraucaria.requests.issues;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.manieri.projetoaraucaria.model.IssueStatus;
import com.manieri.projetoaraucaria.model.Issues;
import com.manieri.projetoaraucaria.model.Project;
import com.manieri.projetoaraucaria.model.Status;
import com.manieri.projetoaraucaria.requests.Requests;

import java.io.IOException;
import java.util.ArrayList;

public class IssuesRequest extends Requests {

    final String issuesTypesID = "2|3|11|14";

    public ArrayList<Issues> getIssuesByStatus(int issueId) throws  IOException {
        System.out.println("ID -->> " + issueId);
        ArrayList<Issues> issuesList = new ArrayList<>();
        JsonNode response;
        if (issueId == -1){
            response = GET("issues.json?assigned_to_id=me&status_id=2|3&limit=50");
        }else {
            response = GET("issues.json?assigned_to_id=me&status_id="+ issueId +"&limit=50");
        }

        return getIssues(issuesList, response);
    }

    public ArrayList<Issues> getAllIssues() throws IOException {
        ArrayList<Issues> issuesList = new ArrayList<>();
        var response = GET("issues.json?assigned_to_id=me&status_id="+ issuesTypesID +"&limit=50");
        System.out.println(response);
        return getIssues(issuesList, response);
    }

    private ArrayList<Issues> getIssues(ArrayList<Issues> issuesList, JsonNode response) {
        response.get("issues").forEach(resp -> {
            issuesList.add(new Issues(
                    resp.get("id").intValue(),
                    new Status(
                            resp.get("status").get("id").intValue(),
                            resp.get("status").get("name").toString().replace("\"", ""),
                            resp.get("status").get("is_closed").booleanValue()),
                    new Project(
                            resp.get("project").get("id").intValue(),
                            resp.get("project").get("name").toString().replace("\"", "")
                    ),
                    resp.get("subject").toString().replace("\"", ""),
                    resp.get("updated_on").toString().replace("\"", "")
            ));
        });
        return issuesList;
    }

    public ArrayList<Status> getIssuesByStatus() throws  IOException {
        ArrayList<Status> issuesTypeList = new ArrayList<>();
        var response = GET("issues.json?assigned_to_id=me&status_id="+ issuesTypesID +"&limit=50");
        response.get("issues").forEach(resp -> {
            Status status = new Status(resp.get("status").get("id").intValue(),
                    resp.get("status").get("name").toString().replace("\"", ""),
                    resp.get("status").get("is_closed").booleanValue());
            if(!issuesTypeList.contains(status)){
                issuesTypeList.add(status);
            }
        });
        return issuesTypeList;
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

    public boolean changeStatus(Issues issues, IssueStatus newStatusId) throws IOException {
        var endPoint = "/issues/" + issues.getIssuesId() + ".json";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonData = objectMapper.createObjectNode()
                .put("status_id", newStatusId.getId());
        ObjectNode payload = objectMapper.createObjectNode();
        payload.set("issue", jsonData);
        String data = objectMapper.writeValueAsString(payload);
        var outCode = PUT(endPoint,data);
        System.out.println("classe: "+ getClass().getName() +" função: changeStatus result code -> "+ outCode);

        if(outCode > 399){
            return false;
        }else {
            return true;
        }

    }
}


