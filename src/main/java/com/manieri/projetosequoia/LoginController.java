package com.manieri.projetosequoia;

import com.manieri.projetosequoia.ui.mainmenu.MainMenuAplication;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController{

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void clicExit() {
        stage.close();
    }

    @FXML
    protected void clicLogin() throws Exception {

        stage.close();
        new MainMenuAplication().start(new Stage());

    }
}