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
        displayListView(zooCollection.getList());
        enclosuresListView.getSelectionModel().select(0);
    }

    @FXML
    protected void onViewButtonClick(ActionEvent pEvent) throws IOException {
        if (enclosuresListView.getSelectionModel().getSelectedIndex() < 0) {
            Alert selectionAlert = new Alert(Alert.AlertType.WARNING, "Please select an enclosure.");
            selectionAlert.showAndWait();
        } else {

            String selectedItemName = enclosuresListView.getSelectionModel().getSelectedItem().toString();
            CompositeAnimal<Object> placeholderCompositeAnimal;
            Enclosure<Animal> placeholderEnclosure;

            for (int i = 0; i < zooCollection.getList().size() - 1; i++) {
                Object tempObject = zooCollection.getList().get(i);
                if (tempObject instanceof CompositeAnimal && Objects.equals(((CompositeAnimal) tempObject).getName(), selectedItemName)) {
                    placeholderCompositeAnimal = (CompositeAnimal) tempObject;

                    FXMLLoader fxmlLoader = new FXMLLoader(ZooManagementApplication.class.getResource("enclosureList-view.fxml"));
                    Parent view = fxmlLoader.load();
                    EnclosureListController newEnclosureListController = fxmlLoader.getController();
                    newEnclosureListController.zooCollection = placeholderCompositeAnimal;
                    Scene nextScene = new Scene(view);
                    Stage nextStage = new Stage();
                    nextStage.setScene(nextScene);
                    nextStage.setTitle(placeholderCompositeAnimal.getName());
                    nextStage.initModality(Modality.WINDOW_MODAL);
                    nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
                    nextStage.showAndWait();

                    break;
                } else if (tempObject instanceof Enclosure && Objects.equals(((Enclosure) tempObject).getName(), selectedItemName)) {
                    placeholderEnclosure = (Enclosure) tempObject;

                    FXMLLoader fxmlLoader = new FXMLLoader(ZooManagementApplication.class.getResource("animalList-view.fxml"));
                    Parent view = fxmlLoader.load();
                    AnimalListController newAnimalListController = fxmlLoader.getController();
                    newAnimalListController.aEnclosure = placeholderEnclosure;
                    Scene nextScene = new Scene(view);
                    Stage nextStage = new Stage();
                    nextStage.setScene(nextScene);
                    nextStage.setTitle(placeholderEnclosure.getName());
                    nextStage.initModality(Modality.WINDOW_MODAL);
                    nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
                    nextStage.showAndWait();

                    break;
                }
            }
        }
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
        // Initializes the placeholder list for contents to be displayed.
        List<String> content = new ArrayList<>();

        // Steps through pList
        for (Object o : pList) {
            // Initializes listItem, which will be added to "content".
            String listItem = "";

            // Gets name of the pList object, which can only be
            // either a CompositeAnimal or an Enclosure. Must
            // typecast "o" if the .getName() method is to be used.
            if (o instanceof CompositeAnimal) {
                listItem = ((CompositeAnimal) o).getName();
            } else if (o instanceof Enclosure) {
                listItem = ((Enclosure) o).getName();
            }

            // Adds the name of the CompositeAnimal/Enclosure to the contents.
            content.add(listItem);
        }

        // Displays the contents in the ListView.
        enclosuresListView.getItems().setAll(content);
    }

    /**
     * Imports lists and creates new Enclosure / CompositeAnimals of current zoo animals
     *
     * @param pCollection represents a CompositeAnimal object
     */
    public void importAnimals(CompositeAnimal pCollection) {
        // Lions
        Enclosure lions = new Enclosure("Lions");
        lions.addAnimal(new Lion("Simba"));
        lions.addAnimal(new Lion("Mufasa"));
        lions.addAnimal(new Lion("Nala"));

        // Tigers
        Enclosure tigerHabitat = new Enclosure("Tiger Habitat");
        tigerHabitat.addAnimal(new Tiger("Rajah"));
        tigerHabitat.addAnimal(new Tiger("Shere Khan"));

        Enclosure tigerCubs = new Enclosure("Tiger Cubs");
        tigerCubs.addAnimal(new Tiger("Tala (Mother)"));
        tigerCubs.addAnimal(new Tiger("Ravi"));
        tigerCubs.addAnimal(new Tiger("Kali"));
        tigerCubs.addAnimal(new Tiger("Indra"));

        CompositeAnimal tigers = new CompositeAnimal("Tigers");
        tigers.addEnclosure(tigerHabitat);
        tigers.addEnclosure(tigerCubs);

        // Cougars
        Enclosure cougarMedical = new Enclosure("Cougar Medical Care");
        cougarMedical.addAnimal(new Cougar("Sierra"));

        Enclosure cougarHabitat = new Enclosure("Cougar Habitat");
        cougarHabitat.addAnimal(new Cougar("Rocky"));
        cougarHabitat.addAnimal(new Cougar("Luna"));
        cougarHabitat.addAnimal(new Cougar("Lenny"));

        CompositeAnimal cougars = new CompositeAnimal("Cougars");
        cougars.addEnclosure(cougarHabitat);
        cougars.addEnclosure(cougarMedical);

        // Zoo
        pCollection.setName("Big Cats");
        pCollection.addEnclosure(lions);
        pCollection.addCompositeAnimal(tigers);
        pCollection.addCompositeAnimal(cougars);
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


