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

    public static Enclosure<Animal> aAnimals = new Enclosure<>("Animals");

    public void openAnimalDetails(ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooManagementApplication.class.getResource("animalDetails-view.fxml"));
        Parent view = fxmlLoader.load();
        AnimalDetailsController newAnimalDetailsController = fxmlLoader.getController();
        //newAnimalDetailsController.setCurrentEnclosure((CompositeAnimal) zooCollection.getObjectList().get(listIndex));
        Scene nextScene = new Scene(view);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle("Add/Edit");
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }

    @FXML
    private void initialize() {
        animalListView.getItems().setAll(aAnimals);
    }

    @FXML
    protected void onViewEditButtonClick(ActionEvent event) throws IOException {
        openAnimalDetails(event);

    }

    @FXML
    protected void onAddButtonClick(ActionEvent event) throws IOException {
        openAnimalDetails(event);
    }

    @FXML
    protected void onRemoveButtonClick() {
        Alert removeAlert = new Alert(Alert.AlertType.WARNING, "Remove");
        removeAlert.showAndWait();
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


//    public void setAnimals(Enclosure<Animal> pAnimals) {
//        aAnimals = pAnimals;
//    }
}