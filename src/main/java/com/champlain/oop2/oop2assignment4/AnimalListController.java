package com.champlain.oop2.oop2assignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalListController {
    @FXML
    private ListView<Object> animalListView;

    private Enclosure<Animal> aAnimals = new Enclosure<>("Animals");

    public void openAnimalDetails(ActionEvent pEvent, Animal pAnimal) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooManagementApplication.class.getResource("animalDetails-view.fxml"));
        Parent view = fxmlLoader.load();
        AnimalDetailsController newAnimalDetailsController = fxmlLoader.getController();
        newAnimalDetailsController.setEnclosure(aAnimals);
        if (pAnimal != null) {
            newAnimalDetailsController.setAnimal(pAnimal);
        }
        Scene nextScene = new Scene(view);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle("Add/Edit");
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();

        displayListView();
    }

    @FXML
    private void initialize() {
        animalListView.getItems().setAll(aAnimals);
    }

    @FXML
    protected void onViewEditButtonClick(ActionEvent event) throws Exception {
        Animal passedAnimal = getCurrentlySelectedAnimal();
        openAnimalDetails(event, passedAnimal);
    }

    private Animal getCurrentlySelectedAnimal() {
        int i = animalListView.getSelectionModel().getSelectedIndex();
        Animal passedAnimal = null;
        if (i == -1){
            throw new IllegalArgumentException("no");
        } else {
            passedAnimal = aAnimals.get(i);
        }
        return passedAnimal;
    }

    @FXML
    protected void onAddButtonClick(ActionEvent event) throws IOException {
        openAnimalDetails(event, null);

    }

    @FXML
    protected void onRemoveButtonClick() {
        this.aAnimals.remove(getCurrentlySelectedAnimal());
        displayListView();
    }

    @FXML
    protected void onBackButtonClick() {
    }

    public void displayListView() {
        ObservableList<String> enclosureNames = FXCollections.observableArrayList();

        for (Animal a : aAnimals) {
            enclosureNames.add(a.getName());
        }

        animalListView.getItems().setAll(enclosureNames);
        animalListView.refresh();
    }


    public void setEnclosure(Enclosure<Animal> pAnimals) {
        aAnimals = pAnimals;
    }
}