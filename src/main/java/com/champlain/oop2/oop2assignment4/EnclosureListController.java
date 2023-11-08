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
        EnclosureListController newEnclosureViewController = fxmlLoader.getController();
        newEnclosureViewController.setEnclosure(getSelectedEnclosure());
        Scene nextScene = new Scene(view, 500, 500);
        Stage nextStage = new Stage();
        nextStage.setScene(nextScene);
        nextStage.setTitle(pEnclosure.setName());
        nextStage.initModality(Modality.WINDOW_MODAL);
        nextStage.initOwner(((Node) pEvent.getSource()).getScene().getWindow());
        nextStage.showAndWait();
    }
    @FXML
    private Button backExitButton;
    private String aEnclosure;
    private String pEnclosure;
    public String getEnclosure() { return aEnclosure; }

    public void setEnclosure(String aEnclosure) { this.aEnclosure = aEnclosure; }
    public void updateList(){

    }

    public void setEnclosure(){
        this.aEnclosure = pEnclosure;
        this.updateList();
    }
    public String getSelectedEnclosure(){
        return pEnclosure;
    }
}


