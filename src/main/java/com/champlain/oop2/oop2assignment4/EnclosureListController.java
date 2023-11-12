package com.champlain.oop2.oop2assignment4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// TODO: ListView initialization with the default enclosures (Lion, Cougar, Tiger)

/**
 * Controls the EnclosureList view, which either displays the list of
 * CompositeAnimals in the zoo, or the list of Enclosures in the CompositeAnimal.
 */
public class EnclosureListController {
    public Button viewButton;
    public Button backExitButton;
    /**
     * Initializes the enclosuresListView
     */
    @FXML
    private ListView<Object> enclosuresListView;

    ZooSingleton zooCollection = ZooSingleton.getInstance();

    private String aEnclosure;

    private Enclosure<Animal> aAnimals;

    @FXML
    protected void initialize() {
        displayListView(zooCollection.getObjectList());
        enclosuresListView.getSelectionModel().select(0);
    }

    @FXML
    protected void onViewButtonClick(ActionEvent pEvent) throws IOException {
        int listIndex = enclosuresListView.getSelectionModel().getSelectedIndex();

        if (zooCollection.getObjectList().get(listIndex) instanceof Enclosure) {
            FXMLLoader fxmlLoader = new FXMLLoader(ZooManagementApplication.class.getResource("animalList-view.fxml"));
            Parent view = fxmlLoader.load();
            AnimalListController newAnimalViewController = fxmlLoader.getController();

            newAnimalViewController.setAnimals(getSelectedAnimals());

            Scene nextScene = new Scene(view);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle("Enclosure");
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
            nextStage.showAndWait();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(ZooManagementApplication.class.getResource("enclosureList-view.fxml"));
            Parent view = fxmlLoader.load();
            EnclosureListController newEnclosureViewController = fxmlLoader.getController();
            newEnclosureViewController.setEnclosure(getSelectedEnclosure());
            Scene nextScene = new Scene(view);
            Stage nextStage = new Stage();
            nextStage.setScene(nextScene);
            nextStage.setTitle("Enclosure");
            nextStage.initModality(Modality.WINDOW_MODAL);
            nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
            nextStage.showAndWait();
        }
    }


    private boolean isCompositeAnimal(String enclosureName) {
        for (Object obj : zooCollection.getObjectList()) {
            if (obj instanceof CompositeAnimal && ((CompositeAnimal) obj).getName().equals(enclosureName)) {
                return true;
            }
        }
        return false;
    }

    public void onBackButtonClick(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }

    /**
     * Sets the contents of a CompositeAnimal's contents to enclosuresListView.
     *
     * @param pList the CompositeAnimal to display
     */
    public void displayListView(List<Object> pList) {
        List<String> enclosureNames = new ArrayList<>();

        for (Object o : pList) {
            String name;
            System.out.println(o.getClass());

            if (o instanceof CompositeAnimal) {
                name = ((CompositeAnimal) o).getName();
            } else {
                name = ((Enclosure<Animal>) o).getName();
            }
            enclosureNames.add(name);
        }

        enclosuresListView.getItems().setAll(enclosureNames);
    }

    /**
     * set aEnclosure to the name of the selected Enclosure then calls updateList()
     *
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
        return String.valueOf(enclosuresListView.getSelectionModel().getSelectedItem());
    }

    public Enclosure<Animal> getSelectedAnimals() {
        Enclosure<Animal> selectedEnclosure = new Enclosure<>("");
        enclosuresListView.getSelectionModel().getSelectedItem();
        selectedEnclosure = (Enclosure<Animal>) enclosuresListView.getSelectionModel().getSelectedItem();

        return selectedEnclosure;
    }

    /**
     * Updates displayListView with the selected CompositeAnimal for the new Window
     */
    private void updateList() {
        // Find the selected CompositeAnimal
        CompositeAnimal selectedCompositeAnimal = setSelectedCompositeAnimal(aEnclosure);

        // Display the contents of the selected CompositeAnimal
        if (selectedCompositeAnimal != null) {
            displayListView(selectedCompositeAnimal.getList());
        }
    }

    /**
     * Searches through list of Objects to find the corresponding CompositeAnimal. Returns if found, else null.
     * null is for redundancy in case of errors.
     *
     * @param name Name of selected CompositeAnimal
     * @return CompositeAnimal objects
     */
    private CompositeAnimal setSelectedCompositeAnimal(String name) {
        for (Object obj : zooCollection.getObjectList()) {
            if (obj instanceof CompositeAnimal && ((CompositeAnimal) obj).getName().equals(name)) {
                return (CompositeAnimal) obj;
            }
        }
        return null;
    }
}


