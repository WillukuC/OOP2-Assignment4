package com.champlain.oop2.oop2assignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnimalDetailsController {

    /*@FXML
    private AnimalCollectionViewController aParent;*/

    private Animal aAnimal;

    private Enclosure aEnclosure;

    @FXML
    private TextField aNameTextField;

    @FXML
    private TextField aWeightTextField;

    @FXML
    private TextField aAgeTextField;

    @FXML
    private Button aSaveButton;

    @FXML
    private Button aBackButton;

    @FXML
    protected void onSaveButtonClick() {
        try {
            this.aAnimal.setName(this.aNameTextField.getText());
            this.aAnimal.setWeight(Double.valueOf(this.aWeightTextField.getText()));
            this.aAnimal.setAge(Double.valueOf(this.aAgeTextField.getText()));
        } catch (IllegalArgumentException exception) {
            Alert viewAlert = new Alert(Alert.AlertType.WARNING, exception.getMessage());
            viewAlert.showAndWait();
            return;
        }

        /*this.aEnclosure.addAnimal(aAnimal);*/

        this.onBackButtonClick();
    }

    @FXML
    protected void onBackButtonClick() {
        Stage stage = (Stage) aNameTextField.getScene().getWindow();
        stage.close();
    }

    public void setAnimal(Animal pAnimal) {
        this.aAnimal = pAnimal;
        this.aNameTextField.setText(pAnimal.getName());
        this.aWeightTextField.setText(String.valueOf(pAnimal.getWeight()));
        this.aAgeTextField.setText(String.valueOf(pAnimal.getAge()));
    }
}
