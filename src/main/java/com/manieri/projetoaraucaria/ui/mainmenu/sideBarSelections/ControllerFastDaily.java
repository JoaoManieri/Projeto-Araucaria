package com.manieri.projetoaraucaria.ui.mainmenu.sideBarSelections;

import com.manieri.projetoaraucaria.LoginStartAplication;
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

public class ControllerFastDaily extends ControllerSubMenu implements ModelSubMenu{

    private final TabPane _tabPane;

    public ControllerFastDaily(VBox vboxMainMenu, TabPane tabPane) {
        super(vboxMainMenu, tabPane);
        this._tabPane = tabPane;
    }

    ArrayList<Button> arrayButtons = new ArrayList<Button>();


    @Override
    public void actionSubMenu(int relativeIndex) {
        Button newOrder = new Button(" - Apontamento rápido");
        newOrder.setId("weeklyQuickNote_button");
        newOrder.setAlignment(Pos.BASELINE_LEFT);
        newOrder.setOnAction(e -> weeklyQuickNote());
        buttonComplements(newOrder);

        setSubSession(relativeIndex,arrayButtons,StatusSubMenu.subsessionCostumersIsOpen);
    }

    private void buttonComplements(Button button) {
        button.setPrefHeight(40.0);
        button.setPrefWidth(260.0);
        button.getStylesheets().add(style);
        button.setTextFill(Color.WHITE);
        button.setPadding(new Insets(0, 0, 0, 80.0));
        button.setFont(new Font(14.0));
        arrayButtons.add(button);
    }

    public void changeStatus() {
        if(StatusSubMenu.subsessionCostumersIsOpen){
            StatusSubMenu.subsessionCostumersIsOpen = false;
        } else {
            StatusSubMenu.subsessionCostumersIsOpen = true;
        }
    }

    @FXML
    protected void weeklyQuickNote() {
        try {
            _tabPane.toFront();
            FXMLLoader loader = new FXMLLoader(LoginStartAplication.class.getResource("views/fastDaily/fast-daily-view.fxml"));
            Node content = loader.load();

            Tab novaAba = new Tab("Apontamento rápido semanal");

            novaAba.setStyle("-fx-background-color:  #383838;"); //muda a cor dá aba
            novaAba.setContent(content);
            _tabPane.getTabs().add(novaAba);
            novaAba.getTabPane().getSelectionModel().select(novaAba);
            novaAba.getContent().requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
