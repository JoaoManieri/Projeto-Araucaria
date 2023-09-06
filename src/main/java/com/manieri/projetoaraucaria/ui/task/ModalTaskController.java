package com.manieri.projetoaraucaria.ui.task;

import com.manieri.projetoaraucaria.model.Issues;
import com.manieri.projetoaraucaria.requests.issues.IssuesRequest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ModalTaskController implements Initializable {

    @FXML
    private CheckBox done_task;

    @FXML
    private CheckBox granted_task;

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

    @FXML
    void sendInfoToApi(ActionEvent event) throws IOException {
        new IssuesRequest().insertIssues(issues.getIssuesId(), String.valueOf(datePicker.getValue()),hours.getText(),comment.getText());
    }

    void setIssues(Issues issues){
        this.issues = issues;
        taskName.setText(issues.getSubject());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        done_task.setDisable(true);
        datePicker.setValue(LocalDate.now());
    }
}
