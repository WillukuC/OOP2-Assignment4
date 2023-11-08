package com.champlain.oop2.oop2assignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class EnclosureListController {
//    @FXML
//    ObservableList<String> enclosuresTop = FXCollections.observableArrayList("Lions", "Tigers", "Cougars");
    @FXML
    ListView<String> enclosuresView = new ListView<String>();

    @FXML
    protected void onViewButtonClick() {
        enclosuresView.getSelectionModel().getSelectedItem();
    }
    @FXML
    private Button backExitButton;
}


