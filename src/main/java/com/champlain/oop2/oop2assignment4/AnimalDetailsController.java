package com.champlain.oop2.oop2assignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AnimalDetailsController {
    @FXML
    private TextField nameTextField;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    protected void onSaveButtonClick() {
        Alert viewAlert = new Alert(Alert.AlertType.WARNING, "Save");
        viewAlert.showAndWait();
    }

    @FXML
    protected void onBackButtonClick() {
        Alert viewAlert = new Alert(Alert.AlertType.WARNING, "Back");
        viewAlert.showAndWait();
    }
}
