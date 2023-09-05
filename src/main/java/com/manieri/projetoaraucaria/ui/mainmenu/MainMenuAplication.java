package com.manieri.projetoaraucaria.ui.mainmenu;

import com.manieri.projetoaraucaria.LoginStartAplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class MainMenuAplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/manieri/projetoaraucaria/img/logotipo.png")));
        stage.getIcons().add(icon);
        FXMLLoader fxmlLoader = new FXMLLoader(LoginStartAplication.class.getResource("main-menu-side-bar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Main menu - Projeto Sequoia");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setScene(scene);
        stage.setMaximized(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
