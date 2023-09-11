package com.manieri.projetoaraucaria.ui.task;

import com.manieri.projetoaraucaria.LoginStartAplication;
import com.manieri.projetoaraucaria.model.Issues;
import com.manieri.projetoaraucaria.requests.issues.IssuesRequest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TaskListController implements Initializable {

    static VBox _vbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        IssuesRequest issuesRequest = new IssuesRequest();
        try {
            newTask(issuesRequest.getAllIssues());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private VBox vbox;


    protected void newTask(ArrayList<Issues> taskList) {
        ArrayList<Issues> warranty_task = new ArrayList<>();
        ArrayList<Issues> general_task = new ArrayList<>();
        taskList.forEach(task -> {
            if (task.getStatus().getId() == 11) {
                warranty_task.add(task);
            } else {
                general_task.add(task);
            }
        });
        warranty_task.forEach(this::newRowIssue);
        general_task.forEach(this::newRowIssue);
    }

    private void newRowIssue(Issues task) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoginStartAplication.class.getResource("views/tasks/new-task-item.fxml"));
            Node content = null;
            content = fxmlLoader.load();

            NewTaskItemController controller = fxmlLoader.getController();
            controller.changeName(task);

            TaskListController._vbox = this.vbox;
            vbox.getChildren().add(2, content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
