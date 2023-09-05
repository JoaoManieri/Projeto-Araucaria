package com.manieri.projetosequoia.validadeFields;

import javafx.scene.control.TextField;
import java.util.ArrayList;


public class ValidadeTextFields {

    public void textField(ArrayList<TextField> textFields) {

        textFields.forEach(it -> {
            it.setStyle("-fx-border-color: red;");
        });

    }
}
