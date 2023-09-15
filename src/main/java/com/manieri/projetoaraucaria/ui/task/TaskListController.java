package com.manieri.projetoaraucaria.ui.task;

import com.manieri.projetoaraucaria.LoginStartAplication;
import com.manieri.projetoaraucaria.model.Issues;
import com.manieri.projetoaraucaria.requests.issues.IssuesRequest;
import com.manieri.projetoaraucaria.util.Observer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TaskListController implements Initializable, Observer {

    static VBox _vbox;

    private boolean allIssues;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Inicialização da view");
    }

    @FXML
    private VBox vbox;

    private int id = -1;

    public void updateIssuesList(int id, boolean allIssues) {


            this.id = id;

        System.out.println("init update");
        System.out.println("init update --< ID: " + id + this.id);
        IssuesRequest issuesRequest = new IssuesRequest();
        if (allIssues) {
            try {
                newTask(issuesRequest.getAllIssues());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("caiu aqui 2");
            try {
                newTask(issuesRequest.getIssuesByStatus(id));
            } catch (IOException e) {
                System.out.println("erro -> " + e);
                throw new RuntimeException(e);
            }
        }
    }


    protected void newTask(ArrayList<Issues> taskList) {
        System.out.println("Caiu aqui 2");
        System.out.println(taskList);
        taskList.forEach(this::newRowIssue);
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

    @Override
    public void update() {
        updateIssuesList(id, false);
    }
}
