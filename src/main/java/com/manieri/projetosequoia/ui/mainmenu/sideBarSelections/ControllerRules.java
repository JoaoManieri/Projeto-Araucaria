package com.manieri.projetosequoia.ui.mainmenu.sideBarSelections;

import com.manieri.projetosequoia.LoginStartAplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerRules extends ControllerSubMenu implements ModelSubMenu {

    ArrayList<Button> arrayButtons = new ArrayList<Button>();

    private final TabPane _tabPane;

    public ControllerRules(VBox vboxMainMenu, TabPane tabPane) {
        super(vboxMainMenu, tabPane);
        this._tabPane = tabPane;
    }

    @Override
    public void actionSubMenu(int relativeIndex) {

        Button button1 = new Button(" - Nova especificação");
        button1.setId("newSpecification_button");
        button1.setAlignment(Pos.BASELINE_LEFT);
        button1.setOnAction(e -> newSpecification());
        button(button1);

        Button button2 = new Button(" - Nova norma");
        button2.setId("newRule_button");
        button2.setAlignment(Pos.BASELINE_LEFT);
        button2.setOnAction(e -> newRule());
        button(button2);

        Button button3 = new Button(" - Editar norma");
        button3.setId("editRule_button");
        button3.setAlignment(Pos.BASELINE_LEFT);
        button3.setOnAction(e -> editRule());
        button(button3);

        Button newEntity = new Button(" - Nova Entidade");
        newEntity.setId("editRule_button");
        newEntity.setAlignment(Pos.BASELINE_LEFT);
        newEntity.setOnAction(e -> newEntity());
        button(newEntity);

        Button button4 = new Button(" - Teste Davi");
        button4.setId("testeDavi_button");
        button4.setAlignment(Pos.BASELINE_LEFT);
        button4.setOnAction(e -> testeDavi());
        button(button4);

        setSubSession(relativeIndex, arrayButtons, StatusSubMenu.subsessionRulesIsOpen);
    }

    private void button(Button button) {
        button.setPrefHeight(40.0);
        button.setPrefWidth(260.0);
        button.getStylesheets().add(style);
        button.setTextFill(Color.WHITE);
        button.setPadding(new Insets(0, 0, 0, 80.0));
        button.setFont(new Font(14.0));
        arrayButtons.add(button);
    }

    @Override
    public void changeStatus() {
        if (!StatusSubMenu.subsessionRulesIsOpen) {
            StatusSubMenu.subsessionRulesIsOpen = true;
        } else {
            StatusSubMenu.subsessionRulesIsOpen = false;
        }
    }

    @FXML
    void newSpecification() {
        try {
            _tabPane.toFront();
            FXMLLoader loader = new FXMLLoader(LoginStartAplication.class.getResource("views/rules/new-specification-view.fxml"));
            Node content = loader.load();

            Tab novaAba = new Tab("Nova Especificação");
            novaAba.setStyle("-fx-background-color: white;"); //muda a cor dá tab

            novaAba.setContent(content);
            _tabPane.getTabs().add(novaAba);
            novaAba.getTabPane().getSelectionModel().select(novaAba);
            novaAba.getContent().requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void newRule() {
        try {
            _tabPane.toFront();
            FXMLLoader loader = new FXMLLoader(LoginStartAplication.class.getResource("views/rules/new-rule-view.fxml"));
            Node content = loader.load();

            Tab novaAba = new Tab("Nova Norma");
            novaAba.setStyle("-fx-background-color: white;"); //muda a cor dá tab
            novaAba.setContent(content);
            _tabPane.getTabs().add(novaAba);
            novaAba.getTabPane().getSelectionModel().select(novaAba);
            novaAba.getContent().requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void editRule() {
        try {
            _tabPane.toFront();
            FXMLLoader loader = new FXMLLoader(LoginStartAplication.class.getResource("views/rules/edit-rule-view.fxml"));
            Node content = loader.load();

            Tab novaAba = new Tab("Editar Norma");
            novaAba.setStyle("-fx-background-color: white;"); //muda a cor dá tab
            novaAba.setContent(content);
            _tabPane.getTabs().add(novaAba);
            novaAba.getTabPane().getSelectionModel().select(novaAba);
            novaAba.getContent().requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void newEntity(){
        try {
            _tabPane.toFront();
            FXMLLoader loader = new FXMLLoader(LoginStartAplication.class.getResource("views/rules/new-entity-view.fxml"));
            Node content = loader.load();

            Tab novaAba = new Tab("Nova Entidade");
            novaAba.setStyle("-fx-background-color: white;");
            novaAba.setContent(content);
            _tabPane.getTabs().add(novaAba);
            novaAba.getTabPane().getSelectionModel().select(novaAba);
            novaAba.getContent().requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void testeDavi() {
        try {

            _tabPane.toFront();
            FXMLLoader loader = new FXMLLoader(LoginStartAplication.class.getResource("views/rules/davi-teste.fxml"));
            Node content = loader.load();

            Tab novaAba = new Tab("Davi Teste");
            novaAba.setContent(content);
            _tabPane.getTabs().add(novaAba);
            novaAba.getTabPane().getSelectionModel().select(novaAba);
            novaAba.getContent().requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
