package com.manieri.projetoaraucaria.ui.task;

import com.manieri.projetoaraucaria.model.IssueStatus;
import com.manieri.projetoaraucaria.model.Issues;
import com.manieri.projetoaraucaria.requests.issues.IssuesRequest;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ModalTaskController implements Initializable {

    @FXML
    private CheckBox InProgress_task;

    @FXML
    private CheckBox basal_task;

    @FXML
    private TextArea comment;

    @FXML
    private DatePicker datePicker;

    @FXML
    private CheckBox done_task;

    @FXML
    private TextField hours;

    @FXML
    private Button sendButton;

    @FXML
    private Text taskName;

    @FXML
    private CheckBox warranty_task;

    private Issues issues;

    private ArrayList<CheckBox> checkBoxArrayList = new ArrayList<>();

    IssueStatus issueStatus;

    @FXML
    void sendInfoToApi(ActionEvent event) throws IOException {
        var request = new IssuesRequest();
        request.insertIssues(issues.getIssuesId(), String.valueOf(datePicker.getValue()), hours.getText(), comment.getText());
        request.changeStatus(issues,);
    }

    void setIssues(Issues issues) {
        this.issues = issues;
        taskName.setText(issues.getSubject());

        if (issues.getStatus().getId() == IssueStatus.NEW.getId() || issues.getStatus().getId() == IssueStatus.IN_PROGRESS.getId()) {
            InProgress_task.setSelected(true);
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

        newCheckBoxListener(InProgress_task);
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

    private int getIssueStatus(){
        checkBoxArrayList.forEach(checkBox -> {
            if (checkBox.isSelected()){
                if(checkBox == basal_task){
                    return IssueStatus.BASAL.getId();
                }
            } else{
                return IssueStatus.IN_PROGRESS.getId();
            }
        });
        return IssueStatus.IN_PROGRESS;
    }
}
