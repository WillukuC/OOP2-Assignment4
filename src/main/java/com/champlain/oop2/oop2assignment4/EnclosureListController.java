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

public class EnclosureListController {
//    @FXML
//    ObservableList<String> enclosuresTop = FXCollections.observableArrayList("Lions", "Tigers", "Cougars");
    @FXML
    ListView<String> enclosuresView = new ListView<String>();

    @FXML
    protected void onViewButtonClick(ActionEvent pEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ZooManagementApplication.class.getResource("enclosure-view.fxml"));
        Parent view = fxmlLoader.load();
        EnclosureListController newEnclosureListController = fxmlLoader.getController();
        newEnclosureListController.setEnclosure(getSelectedEnclosure());
        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle(pEnclosure.getName());
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }
    public void importAnimals() {
        Enclosure Lion = new Enclosure();
        Lion.setName("Lion");
        Lion.addAnimal(new Lion("Simba"));
        Lion.addAnimal(new Lion("Mufasa"));
        Lion.addAnimal(new Lion("Nala"));

        Enclosure tigerHabitat = new Enclosure();
        tigerHabitat.setName("Tigers Habitat");
        tigerHabitat.addAnimal(new Tiger("Rajah"));
        tigerHabitat.addAnimal(new Tiger("Shere Khan"));

        Enclosure tigerCubs = new Enclosure();
        tigerCubs.setName("Tiger Cubs");
        tigerCubs.addAnimal(new Tiger("Tala (Mother)"));
        tigerCubs.addAnimal(new Tiger("Ravi"));
        tigerCubs.addAnimal(new Tiger("Kali"));
        tigerCubs.addAnimal(new Tiger("Indra"));

        CompositeAnimal tigers = new CompositeAnimal();
        tigers.setName("Tigers");
        tigers.addCollection(tigerHabitat);
        tigers.addCollection(tigerCubs);

        Enclosure cougarMedical = new Enclosure();
        cougarMedical.setName("Cougar Medical Care");
        cougarMedical.addAnimal(new Cougar("Sierra"));

        Enclosure cougarHabitat = new Enclosure();
        cougarHabitat.setName("Cougars Habitat");
        cougarHabitat.addAnimal(new Cougar("Rocky"));
        cougarHabitat.addAnimal(new Cougar("Luna"));
        cougarHabitat.addAnimal(new Cougar("Lenny"));

        CompositeAnimal cougars = new CompositeAnimal();
        cougars.setName("Cougars");
        cougars.addCollection(cougarHabitat);
        cougars.addCollection(cougarMedical);

        CompositeAnimal myCollection = new CompositeAnimal();
        myCollection.setName("Big Cats");
        myCollection.addCollection(Lion);
        myCollection.addCollection(tigers);
        myCollection.addCollection(cougars);
    }
    @FXML
    private Button backExitButton;
    private String aEnclosure;
    private String pEnclosure;
    public String getEnclosure() { return aEnclosure; }

    // public void setEnclosure(String aEnclosure) { this.aEnclosure = aEnclosure; }
    public void updateList(){

    }
    public void setEnclosure(String aEnclosure){
        this.aEnclosure = pEnclosure;
        this.updateList();
    }
    public void setSelectedEnclosure(String aEnclosure){

    }
    public String getSelectedEnclosure(){
        pEnclosure = enclosuresView.getSelectionModel().getSelectedItem();

        return pEnclosure;
    }
}


