package com.manieri.projetosequoia.ui.mainmenu;

import com.manieri.projetosequoia.ui.mainmenu.sideBarSelections.ControllerCostumers;
import com.manieri.projetosequoia.ui.mainmenu.sideBarSelections.ControllerTasks;
import com.manieri.projetosequoia.ui.mainmenu.sideBarSelections.ControllerRules;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class MainMenuController {
    @FXML
    public TabPane tabPaneMain;

    @FXML
    private VBox mainMenu_vbox;

    @FXML
    private Button button_normas;

    @FXML
    private Button button_orcaments;

    @FXML
    private Button button_settings;

    @FXML
    private Button button_users;

    @FXML
    private VBox vbox_sideMenu;

    @FXML
    void clicTasks() {

        int indice = vbox_sideMenu.getChildren().indexOf(button_orcaments);
        ControllerTasks ct = new ControllerTasks(vbox_sideMenu, tabPaneMain);
        ct.changeStatus();
        ct.actionSubMenu(indice + 1);

    }

    @FXML
    void clickCostumers() {

//        int indice = vbox_sideMenu.getChildren().indexOf(button_users);
//        ControllerCostumers cm = new ControllerCostumers(vbox_sideMenu, tabPaneMain);
//        cm.changeStatus();
//        cm.actionSubMenu(indice + 1);

    }

    @FXML
    void clickRules() {
//        int indice = vbox_sideMenu.getChildren().indexOf(button_normas);
//        ControllerRules cm = new ControllerRules(vbox_sideMenu, tabPaneMain);
//        cm.changeStatus();
//        cm.actionSubMenu(indice + 1);

    }

    @FXML
    void clickSettings() {

    }
}
