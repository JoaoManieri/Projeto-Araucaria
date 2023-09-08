package com.manieri.projetoaraucaria;

import com.manieri.projetoaraucaria.requests.login.LoginRequest;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        CheckBox checkBox = new CheckBox("CheckBox com Cor de Caixinha");

        StackPane root = new StackPane();
        root.getChildren().add(checkBox);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Mudar Cor da Caixinha do CheckBox em JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();

        new LoginRequest().checkLogin();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
