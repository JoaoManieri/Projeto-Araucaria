package com.manieri.projetoaraucaria.ui.fastDaily;

import com.manieri.projetoaraucaria.model.CalendarDayPart;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CalendarController {

    String day;

    @FXML
    private Text hours_text;

    @FXML
    private CheckBox daily_checkbox;

    @FXML
    private Text month_day;

    public void setDay(CalendarDayPart day) {

        this.day = day.getDay();
        month_day.setText(day.getDay());
        month_day.setFill(Color.web(day.getColor()));

        hours_text.setText(String.valueOf(day.getHours()));

        daily_checkbox.setVisible(day.isMenu());
        hours_text.setVisible(day.isMenu());

    }

    public boolean getDaily(){
        return daily_checkbox.isSelected();
    }

}
