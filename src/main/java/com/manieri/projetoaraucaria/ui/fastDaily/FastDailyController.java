package com.manieri.projetoaraucaria.ui.fastDaily;

import com.manieri.projetoaraucaria.LoginStartAplication;
import com.manieri.projetoaraucaria.model.CalendarFormater;
import com.manieri.projetoaraucaria.model.Issues;
import com.manieri.projetoaraucaria.ui.util.IssuesListCell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FastDailyController implements Initializable {


    @FXML
    private TextField daily_coment;

    @FXML
    private TextField daily_time;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button sendButon;

    @FXML
    private ComboBox<Issues> task_comboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ComboBox<Issues> comboBox = new ComboBox<>();
        comboBox.getItems().addAll();

        comboBox.setCellFactory(item -> new IssuesListCell());
        comboBox.setButtonCell(new IssuesListCell());

        try {
            setTitle("Domingo", 0, "#Ab3310");
            setTitle("Segunda-feira", 1, "#FFFFFF");
            setTitle("Terça-feira", 2, "#FFFFFF");
            setTitle("Quarta-feira", 3, "#FFFFFF");
            setTitle("Quinta-feira", 4, "#FFFFFF");
            setTitle("Sexta-feira", 5, "#FFFFFF");
            setTitle("Sabado", 6, "#FFFFFF");
        } catch (IOException ignored) {
        }
        setWeekDays();
    }

    private void setTitle(String label, int colum, String color) throws IOException {
        var day = new Label(label);
        day.setStyle("-fx-text-fill:" + color + ";" + "-fx-font-size: 20px;");
        GridPane.setHalignment(day, HPos.CENTER);
        GridPane.setValignment(day, VPos.CENTER);
        gridPane.add(day, colum, 0);
    }

    private void setWeekDays() {

        LocalDate dataAtual = LocalDate.now();
        int mesAtual = dataAtual.getMonthValue();
        int anoAtual = dataAtual.getYear();

        LocalDate primeiroDiaDoMes = LocalDate.of(anoAtual, mesAtual, 1);
        LocalDate ultimoDiaDoMes = primeiroDiaDoMes.plusMonths(1).minusDays(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        ArrayList<CalendarFormater> listDays = new ArrayList<>();

        for (LocalDate data = primeiroDiaDoMes; !data.isAfter(ultimoDiaDoMes); data = data.plusDays(1)) {
            int indiceDiaSemana = (data.getDayOfWeek().getValue()) % 7 + 1; // 7 (Dom) a 6 (Sab)
            listDays.add(new CalendarFormater(indiceDiaSemana, data.format(formatter)));
        }

        alocDays(listDays);

    }

    private void alocDays(ArrayList<CalendarFormater> listDays) {
        final int[] row = {1};
        listDays.forEach(it -> {
            if ((it.getDayofWeek()) == 1) {
                try {
                    setlayoutDays(it.getDayOfMonth(), (it.getDayofWeek() - 1), row[0], "#Ab3310", false);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    if (it.getDayofWeek() == 7) {
                        setlayoutDays(it.getDayOfMonth(), (it.getDayofWeek() - 1), row[0], "#FFFFFF", false);
                    } else {
                        setlayoutDays(it.getDayOfMonth(), (it.getDayofWeek() - 1), row[0], "#FFFFFF", true);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (it.getDayofWeek() == 7) {
                    row[0]++;
                }

            }
        });
    }

    private void setlayoutDays(String monthDay, int colum, int row, String color, boolean menu) throws IOException {

        FXMLLoader loader = new FXMLLoader(LoginStartAplication.class.getResource("views/fastDaily/calendar-part.fxml"));
        StackPane stakPane = new StackPane();
        stakPane.getChildren().add(loader.load());
        stakPane.setAlignment(Pos.CENTER); // Centralize o conteúdo
        gridPane.add(stakPane, colum, row);
        CalendarController calendarController = loader.getController();
        calendarController.setDay(monthDay, color, menu);
    }

}
