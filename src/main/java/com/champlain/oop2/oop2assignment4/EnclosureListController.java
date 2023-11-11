package com.champlain.oop2.oop2assignment4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    CompositeAnimal<Object> zooCollection = new CompositeAnimal<>("Zoo");

    private String aEnclosure;

    @FXML
    protected void initialize() {
        importAnimals(zooCollection);
        displayListView(zooCollection);
        enclosuresListView.getSelectionModel().select(0);
    }

    @FXML
    protected void onViewButtonClick(ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooManagementApplication.class.getResource("enclosure-view.fxml"));
        Parent view = fxmlLoader.load();
        EnclosureListController newEnclosureViewController = fxmlLoader.getController();
        newEnclosureViewController.setEnclosure(getSelectedEnclosure());
        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle("PENIS");
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }


    private boolean isCompositeAnimal(String enclosureName) {
        for (Object obj : zooCollection.getList()) {
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
        enclosuresListView.getItems().setAll(pList);
    }

    /**
     * Imports lists and creates new Enclosure / CompositeAnimals of current zoo animals
     *
     * @param pCollection represents a CompositeAnimal object
     */
    public void importAnimals(CompositeAnimal<Object> pCollection) {
        // Lions
        Enclosure<Animal> lions = new Enclosure<>("Lions");
        lions.add(new Lion("Simba"));
        lions.add(new Lion("Mufasa"));
        lions.add(new Lion("Nala"));

        // Tigers
        Enclosure<Animal> tigerHabitat = new Enclosure<>("Tiger Habitat");
        tigerHabitat.add(new Tiger("Rajah"));
        tigerHabitat.add(new Tiger("Shere Khan"));

        Enclosure<Animal> tigerCubs = new Enclosure<>("Tiger Cubs");
        tigerCubs.add(new Tiger("Tala (Mother)"));
        tigerCubs.add(new Tiger("Ravi"));
        tigerCubs.add(new Tiger("Kali"));
        tigerCubs.add(new Tiger("Indra"));

        CompositeAnimal<Object> tigers = new CompositeAnimal<>("Tigers");
        tigers.add(tigerHabitat);
        tigers.add(tigerCubs);

        // Cougars
        Enclosure<Animal> cougarMedical = new Enclosure<>("Cougar Medical Care");
        cougarMedical.add(new Cougar("Sierra"));

        Enclosure<Animal> cougarHabitat = new Enclosure<>("Cougar Habitat");
        cougarHabitat.add(new Cougar("Rocky"));
        cougarHabitat.add(new Cougar("Luna"));
        cougarHabitat.add(new Cougar("Lenny"));

        CompositeAnimal<Object> cougars = new CompositeAnimal<>("Cougars");
        cougars.add(cougarHabitat);
        cougars.add(cougarMedical);

        // Zoo
        pCollection.setName("Big Cats");
        pCollection.add(lions);
        pCollection.add(tigers);
        pCollection.add(cougars);
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
        for (Object obj : zooCollection.getList()) {
            if (obj instanceof CompositeAnimal && ((CompositeAnimal) obj).getName().equals(name)) {
                return (CompositeAnimal) obj;
            }
        }
        return null;
    }
}


