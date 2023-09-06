package com.manieri.projetoaraucaria.ui.fastDaily;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CalendarController {
    @FXML
    private CheckBox daily_checkbox;

    @FXML
    private Text month_day;

    public void setDay(String day, String color, boolean menu) {
        month_day.setText(day);
        month_day.setFill(Color.web(color));
        daily_checkbox.setVisible(menu);
    }

    public boolean getDaily(){
        return daily_checkbox.isSelected();
    }

}
