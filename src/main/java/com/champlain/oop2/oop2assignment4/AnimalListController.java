package com.champlain.oop2.oop2assignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class AnimalListController {
    @FXML
    private final ListView<Object> animalListView = new ListView<>();

    private Enclosure<Animal> aAnimals = new Enclosure<>("Animals");

    @FXML
    protected void initialize() {
        displayListView(aAnimals);
        animalListView.getSelectionModel().select(0);
    }

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
    }

    public void displayListView(Enclosure<Animal> pAnimals) {
        ObservableList<String> enclosureNames = FXCollections.observableArrayList();

        for (Animal a : pAnimals) {
            enclosureNames.add(a.getName());
        }

        animalListView.getItems().setAll(enclosureNames);
    }


    public void setAnimals(Enclosure<Animal> pAnimals) {
        this.aAnimals = pAnimals;
    }
}