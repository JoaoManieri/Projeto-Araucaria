package com.manieri.projetoaraucaria.ui.mainmenu.sideBarSelections;

import com.manieri.projetoaraucaria.LoginStartAplication;
import com.manieri.projetoaraucaria.model.IssueStatus;
import com.manieri.projetoaraucaria.model.Status;
import com.manieri.projetoaraucaria.requests.issues.IssuesRequest;
import com.manieri.projetoaraucaria.ui.task.TaskListController;
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

public class ControllerTasks extends ControllerSubMenu implements ModelSubMenu {

    private final TabPane _tabPane;

    public ControllerTasks(VBox vboxMainMenu, TabPane tabPane) {
        super(vboxMainMenu, tabPane);
        this._tabPane = tabPane;
    }

    ArrayList<Button> arrayButtons = new ArrayList<Button>();

    @Override
    public void actionSubMenu(int relativeIndex) {
        ArrayList<Status> subMenuList = new ArrayList<>();
        try {
            subMenuList.addAll( new IssuesRequest().getIssuesByStatus());
        } catch (IOException ignored){
            //TODO Tratar erros de nao conexão com intenet
        }
        if (!StatusSubMenu.subsessionOrderIsOpen) {
            createNewSubmenu(new Status(IssueStatus.ALL.getId(), "All tasks", false));
            subMenuList.forEach(this::createNewSubmenu);
        }

        setSubSession(relativeIndex, arrayButtons, StatusSubMenu.subsessionOrderIsOpen);
    }

    private void createNewSubmenu(Status status){
        Button editOrder = new Button(status.getName());
        String id = status.getName().replaceAll("\\s+", "");
        editOrder.setId(id);
        editOrder.setAlignment(Pos.BASELINE_LEFT);
        editOrder.setOnAction(e -> clickListTask(status));
        buttonBuilder(editOrder);
    }

    private void buttonBuilder(Button button) {
        button.setPrefHeight(40.0);
        button.setPrefWidth(260.0);
        button.getStylesheets().add(style);
        button.setTextFill(Color.WHITE);
        button.setPadding(new Insets(0, 0, 0, 80.0));
        button.setFont(new Font(14.0));
        arrayButtons.add(button);
    }

    public void changeStatus() {
        if (!StatusSubMenu.subsessionOrderIsOpen) {
            StatusSubMenu.subsessionOrderIsOpen = true;
        } else {
            StatusSubMenu.subsessionOrderIsOpen = false;
        }
    }

    @FXML
    protected void clickListTask(Status status) {
        try {
            _tabPane.toFront();
            FXMLLoader loader = new FXMLLoader(LoginStartAplication.class.getResource("views/tasks/list-task-view.fxml"));
            Node content = loader.load();

            boolean all = (status.getId() == IssueStatus.ALL.getId());
            TaskListController controller = loader.getController();
            controller.updateIssuesList(status.getId(), all);

            Tab novaAba = new Tab(status.getName());
            novaAba.setStyle("-fx-background-color:  #383838;"); //muda a cor dá tab
            novaAba.setContent(content);
            _tabPane.getTabs().add(novaAba);
            novaAba.getTabPane().getSelectionModel().select(novaAba);
            novaAba.getContent().requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
