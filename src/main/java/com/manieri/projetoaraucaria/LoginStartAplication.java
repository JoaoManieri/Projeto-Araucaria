package com.manieri.projetoaraucaria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.util.Objects;

public class
LoginStartAplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        LoginController controller = fxmlLoader.getController();
        controller.setStage(stage);

        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/manieri/projetoaraucaria/img/logotipo.png")));
        stage.getIcons().add(icon);

        fxmlLoader.getController();


        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();


//        try {
//            controller.clicLogin();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

    }

    public static void main(String[] args) {
        launch();
    }
}