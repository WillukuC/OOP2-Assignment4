package com.champlain.oop2.oop2assignment4;

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
import java.util.List;

public class AnimalListController {
    @FXML
    private final ListView<Animal> animalListView = new ListView<>();

    Enclosure currentEnclosure = new Enclosure(getSelectedEnclosure().toString());

    private String aEnclosure;
    private void openAnimalEditor(ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooManagementApplication.class.getResource("animalDetails-view.fxml"));
        Parent view = fxmlLoader.load();
        AnimalDetailsController newAnimalDetailsController = fxmlLoader.getController();
        //newAnimalDetailsController.setEnclosure(getSelectedEnclosure());
        Scene nextScene = new Scene(view);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle(getSelectedEnclosure().toString());
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }
        

    @FXML
    protected void initialize() {
        displayListView(currentEnclosure.getList());
        animalListView.getSelectionModel().select(0);
    }

    @FXML
    protected void onViewEditButtonClick(ActionEvent event) throws IOException {
        openAnimalEditor(event);
    }

    @FXML
    protected void onAddButtonClick(ActionEvent event) throws IOException {
        openAnimalEditor(event);
    }

    @FXML
    protected void onRemoveButtonClick() {
        Alert removeAlert = new Alert(Alert.AlertType.WARNING, "Remove");
        removeAlert.showAndWait();
    }

    @FXML
    protected void onBackButtonClick(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    /**
     * set aEnclosure to the name of the selected Enclosure then calls updateList()
     * @param selectedEnclosure name of currently selected Enclosure
     */
    public void setEnclosure(String selectedEnclosure) {
        this.aEnclosure = selectedEnclosure;
        updateList();
    }

    /**
     * @return name of currently selected item
     */
    public String getSelectedEnclosure() {
        return String.valueOf(animalListView.getSelectionModel().getSelectedItem());
    }

    /**
     * Updates displayListView with the selected CompositeAnimal for the new Window
     */
    private void updateList() {
        // Find the selected CompositeAnimal
        Enclosure selectedEnclosure = setSelectedEnclosure(aEnclosure);

        // Display the contents of the selected CompositeAnimal
        if (selectedEnclosure != null) {
            displayListView(selectedEnclosure.getList());
        }
    }

    private void displayListView(List<Animal> list) {
        animalListView.getItems().setAll(list);
    }

    private Enclosure setSelectedEnclosure(String aEnclosure) {
        return null;
    }
}