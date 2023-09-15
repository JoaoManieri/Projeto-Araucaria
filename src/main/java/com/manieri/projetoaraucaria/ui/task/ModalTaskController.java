package com.manieri.projetoaraucaria.ui.task;

import com.fasterxml.jackson.databind.JsonNode;
import com.manieri.projetoaraucaria.model.IssueStatus;
import com.manieri.projetoaraucaria.model.Issues;
import com.manieri.projetoaraucaria.requests.issues.IssuesRequest;
import com.manieri.projetoaraucaria.util.LiveData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ModalTaskController implements Initializable {

    @FXML
    private CheckBox inProgress_task;

    @FXML
    private CheckBox basal_task;

    @FXML
    private CheckBox done_task;

    @FXML
    private CheckBox warranty_task;

    @FXML
    private TextArea comment;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField hours;

    @FXML
    private Button sendButton;

    @FXML
    private Text taskName;

    private Issues issues;

    private final ArrayList<CheckBox> checkBoxArrayList = new ArrayList<>();

    int issueStatus;


    @FXML
    void sendInfoToApi(ActionEvent event) throws IOException {

        var request = new IssuesRequest();
//        request.insertIssues(issues.getIssuesId(), String.valueOf(datePicker.getValue()), hours.getText(), comment.getText());


        int newStatus = getIssueStatus();
        IssueStatus status = IssueStatus.fromId(newStatus);

        boolean out = false;

        if(newStatus != issueStatus){
            out = request.changeStatus(issues, status);
        }

        System.out.println("-->> Saida async? git" + out);

        Node sourceNode = (Node) event.getSource();
        Stage stage = (Stage) sourceNode.getScene().getWindow();

        LiveData liveData = new LiveData();
        TaskListController observador = new TaskListController();

        liveData.addObserver(observador);
        liveData.putData("");

        stage.close();

    }

    void setIssues(Issues issues) {

        this.issues = issues;
        issueStatus =issues.getStatus().getId();
        taskName.setText(issues.getSubject());

        if (issues.getStatus().getId() == IssueStatus.NEW.getId() || issues.getStatus().getId() == IssueStatus.IN_PROGRESS.getId()) {
            inProgress_task.setSelected(true);
        } else if (issues.getStatus().getId() == IssueStatus.BASAL.getId()) {
            basal_task.setSelected(true);
        } else if (issues.getStatus().getId() == IssueStatus.WARRANTY.getId()) {
            warranty_task.setSelected(true);
        } else if (issues.getStatus().getId() == IssueStatus.DONE.getId()) {
            done_task.setSelected(true);
        }

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        datePicker.setValue(LocalDate.now());

        newCheckBoxListener(inProgress_task);
        newCheckBoxListener(basal_task);
        newCheckBoxListener(done_task);
        newCheckBoxListener(warranty_task);



    }

    private void newCheckBoxListener(CheckBox checkBox) {
        ChangeListener<Boolean> checkBoxChangeListener = new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue) {
                    checkBoxArrayList.forEach(box -> {
                        if (checkBox == box) {
                        } else {
                            box.setSelected(false);
                        }
                    });
                }
            }
        };

        checkBox.selectedProperty().addListener(checkBoxChangeListener);

        checkBoxArrayList.add(checkBox);
    }

    private int getIssueStatus() {
        if (inProgress_task.isSelected()) {return IssueStatus.IN_PROGRESS.getId();}
        if (basal_task.isSelected()) {return IssueStatus.BASAL.getId();}
        if (done_task.isSelected()) {return IssueStatus.DONE.getId();}
        if (warranty_task.isSelected()) {return IssueStatus.WARRANTY.getId();}
        return IssueStatus.IN_PROGRESS.getId();
    }

}
