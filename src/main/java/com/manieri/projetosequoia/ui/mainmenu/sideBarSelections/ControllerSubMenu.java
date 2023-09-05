package com.manieri.projetosequoia.ui.mainmenu.sideBarSelections;

import com.manieri.projetosequoia.ui.mainmenu.MainMenuController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Objects;

import static com.manieri.projetosequoia.ui.mainmenu.sideBarSelections.ControllerSubMenu.StatusSubMenu.*;

public class ControllerSubMenu extends MainMenuController {

    private VBox vboxMainMenu;

    public ControllerSubMenu(VBox vboxMainMenu, TabPane tabPane) {
        super();
        this.vboxMainMenu = vboxMainMenu;
    }

    String style = Objects.requireNonNull(getClass().getResource("/com/manieri/projetosequoia/css/fullpackstyling.css")).toExternalForm();

    private final VBox subSessionVBox = new VBox(0);

    static class StatusSubMenu {

        static Boolean subsessionOrderIsOpen = true;
        static Boolean subsessionCostumersIsOpen = true;
        static Boolean subsessionRulesIsOpen = true;
        static Boolean subsessionSettingsIsOpen = false;

    }

    void setSubSession(int relativeIndex, ArrayList<Button> listbuttons, Boolean subsessionIsOpen) {

        if (!subsessionIsOpen) {

            vboxMainMenu.getChildren().add(relativeIndex, subSessionVBox);
            subSessionVBox.setPadding(new Insets(0));
            subSessionVBox.getChildren().addAll(listbuttons);

        } else {
            vboxMainMenu.getChildren().remove(relativeIndex);

        }

    }
}
