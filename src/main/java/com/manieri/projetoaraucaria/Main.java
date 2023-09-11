package com.manieri.projetoaraucaria;

import com.manieri.projetoaraucaria.model.IssueStatus;
import com.manieri.projetoaraucaria.model.Issues;
import com.manieri.projetoaraucaria.model.Project;
import com.manieri.projetoaraucaria.model.Status;
import com.manieri.projetoaraucaria.requests.issues.IssuesRequest;
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

public class Main   {
    public static void main(String[] args) throws IOException {
       System.out.println("teste de mudar status");
        var issu = new Issues(20464, new Status(1, "", false),new Project(0,""),"");

        new IssuesRequest().changeStatus(issu, IssueStatus.NEW);
    }
}
