package com.manieri.projetosequoia.ui.task;

import com.manieri.projetosequoia.LoginStartAplication;
import com.manieri.projetosequoia.model.Issues;
import com.manieri.projetosequoia.requests.Requests;
import com.manieri.projetosequoia.requests.issues.IssuesRequest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TaskListController implements Initializable {

    static VBox _vbox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ArrayList<String> list = new ArrayList<>();
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
        taskList.forEach(task -> {
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
        });
    }
}
