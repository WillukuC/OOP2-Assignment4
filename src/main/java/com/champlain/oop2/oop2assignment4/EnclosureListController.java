package com.champlain.oop2.oop2assignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.util.Iterator;
import java.util.List;

// TODO: ListView initialization with the default enclosures (Lion, Cougar, Tiger)

/**
 * Controls the EnclosureList view, which either displays the list of
 * CompositeAnimals in the zoo, or the list of Enclosures in the CompositeAnimal.
 */
public class EnclosureListController {
    /**
     * Initializes the backExitButton
     */
    @FXML
    private Button backExitButton;
    /**
     * Initializes the viewButton
     */
    @FXML
    private Button viewButton;
    /**
     * Initializes the enclosuresListView
     */
    @FXML
    private ListView<Object> enclosuresListView;

    CompositeAnimal zooCollection = new CompositeAnimal("Zoo");
    /* IDK what any of this shit does, ngl
    private String aEnclosure;
    private String pEnclosure;
    public String getEnclosure() { return aEnclosure; }
     */
    @FXML
    protected void initialize() {
        importAnimals(zooCollection);
        displayListView(zooCollection.getList());
    }

    @FXML
    protected void onViewButtonClick(ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooManagementApplication.class.getResource("enclosure-view.fxml"));
        Parent view = fxmlLoader.load();
        EnclosureListController newEnclosureListController = fxmlLoader.getController();
        // newEnclosureListController.setEnclosure(getSelectedEnclosure());
        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle("Placeholder");
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }

    public void onBackButtonClick(ActionEvent actionEvent) {

    }

    /**
     * Sets the contents of a CompositeAnimal's contents to enclosuresListView.
     * @param pList the CompositeAnimal to display
     */
    public void displayListView(List<Object> pList) {
        // Initializes the placeholder list for contents to be displayed.
        List<String> content = new ArrayList<>();

        // Steps through pList
        for (Object o : pList ) {
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

    public void importAnimals(CompositeAnimal pCollection) {
        // Lions
        Enclosure Lion = new Enclosure("Lion");
        // Lion.addAnimal(new Lion("Simba"));
        // Lion.addAnimal(new Lion("Mufasa"));
        // Lion.addAnimal(new Lion("Nala"));

        // Tigers
        Enclosure tigerHabitat = new Enclosure("Tiger Habitat");
        // tigerHabitat.addAnimal(new Tiger("Rajah"));
        // tigerHabitat.addAnimal(new Tiger("Shere Khan"));

        Enclosure tigerCubs = new Enclosure("Tiger Cubs");
        // tigerCubs.addAnimal(new Tiger("Tala (Mother)"));
        // tigerCubs.addAnimal(new Tiger("Ravi"));
        // tigerCubs.addAnimal(new Tiger("Kali"));
        // tigerCubs.addAnimal(new Tiger("Indra"));

        CompositeAnimal tigers = new CompositeAnimal("Tigers");
        tigers.addObject(tigerHabitat);
        tigers.addObject(tigerCubs);

        // Cougars
        Enclosure cougarMedical = new Enclosure("Cougar Medical Care");
        // cougarMedical.addAnimal(new Cougar("Sierra"));

        Enclosure cougarHabitat = new Enclosure("Cougar Habitat");
        // cougarHabitat.addAnimal(new Cougar("Rocky"));
        // cougarHabitat.addAnimal(new Cougar("Luna"));
        // cougarHabitat.addAnimal(new Cougar("Lenny"));

        CompositeAnimal cougars = new CompositeAnimal("Cougars");
        cougars.addObject(cougarHabitat);
        cougars.addObject(cougarMedical);

        // Zoo
        pCollection.setName("Big Cats");
        pCollection.addObject(Lion);
        pCollection.addObject(tigers);
        pCollection.addObject(cougars);
    }

    /*
    public void setEnclosure(String aEnclosure){
        this.aEnclosure = pEnclosure;
        this.updateList();
    }

    public void setSelectedEnclosure(String aEnclosure){

    }
    public String getSelectedEnclosure(){
        pEnclosure = String.valueOf(enclosuresView.getSelectionModel().getSelectedItem());
        return pEnclosure;
    }
     */
}


