package com.champlain.oop2.oop2assignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class AnimalListController {
    @FXML
    private Label enclosureNameLabel;

    @FXML
    protected void onViewEditButtonClick() {
        Alert viewAlert = new Alert(Alert.AlertType.WARNING, "View");
        viewAlert.showAndWait();
    }

    @FXML
    protected void onAddButtonClick() {
        Alert addAlert = new Alert(Alert.AlertType.WARNING, "Add");
        addAlert.showAndWait();
    }

    @FXML
    protected void onRemoveButtonClick() {
        Alert removeAlert = new Alert(Alert.AlertType.WARNING, "Remove");
        removeAlert.showAndWait();
    }

    @FXML
    protected void onBackButtonClick() {
        Alert backAlert = new Alert(Alert.AlertType.WARNING, "Back");
        backAlert.showAndWait();
    }
}