package com.champlain.oop2.oop2assignment4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnimalDetailsController {
    public Button aBackButton;
    public Button aSaveButton;

    private Animal aAnimal = new Animal();

    private Enclosure aEnclosure;

    @FXML
    private TextField aNameTextField;

    @FXML
    private TextField aWeightTextField;

    @FXML
    private TextField aAgeTextField;

    private boolean isNew = true;

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

        if(this.isNew){
            this.aEnclosure.addAnimal(this.aAnimal);
        }

        this.onBackButtonClick();
    }

    @FXML
    protected void onBackButtonClick() {
        Stage stage = (Stage) aNameTextField.getScene().getWindow();
        stage.close();
    }

    /*Setting the data from the selected entity and turning of the isNew boolean*/
    public void setAnimal(Animal pAnimal) {
        this.isNew = false;
        this.aAnimal = pAnimal;
        this.aNameTextField.setText(pAnimal.getName());
        this.aWeightTextField.setText(String.valueOf(pAnimal.getWeight()));
        this.aAgeTextField.setText(String.valueOf(pAnimal.getAge()));
    }

    /*Setting which enclosure, a new animal is suppose to be added to*/
    public void setEnclosure(Enclosure pEnclosure) {
        this.aEnclosure = pEnclosure;
    }
}
