package com.manieri.projetoaraucaria.ui.task;

import com.manieri.projetoaraucaria.LoginStartAplication;
import com.manieri.projetoaraucaria.model.Issues;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class NewTaskItemController {

    @FXML
    private Text textName;

    @FXML
    private Text textProject;

    @FXML
    private Text textStatus;

    @FXML
    private AnchorPane paneMain;

    void changeName(Issues task){

        textName.setText(task.getSubject());
        textProject.setText(task.getProject().getName());

        if(task.getStatus().getId() == 2){
            //new
            Color color = Color.web("#648161");
            textStatus.setFill(color);
        } else if(task.getStatus().getId() == 3){
            //progress
            Color color = Color.web("#D5A400");
            textStatus.setFill(color);
        }
        textStatus.setText(task.getStatus().getName());
        paneMain.setOnMouseClicked((MouseEvent event) -> {
            try {
                openModal(task);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void openModal(Issues task) throws IOException {

        FXMLLoader loader = new  FXMLLoader(LoginStartAplication.class.getResource("views/tasks/modal-task.fxml"));
        Parent root = loader.load();

        Stage modalStage = new Stage();
        modalStage.initModality(Modality.APPLICATION_MODAL);
        modalStage.initStyle(StageStyle.DECORATED);
        modalStage.setTitle("Modal");

        Scene scene = new Scene(root);
        modalStage.setScene(scene);

        ModalTaskController controller = loader.getController();
        controller.setIssues(task);
        modalStage.showAndWait();

    }

}
