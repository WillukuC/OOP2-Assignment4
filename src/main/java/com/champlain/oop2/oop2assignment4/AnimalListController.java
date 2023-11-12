package com.champlain.oop2.oop2assignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.util.List;

public class AnimalListController {
    @FXML
    private final ListView<Animal> animalListView = new ListView<>();

    Enclosure currentEnclosure = new Enclosure("Enclosure");

    private String aEnclosure;

    @FXML
    protected void initialize() {
        displayListView(currentEnclosure.getList());
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