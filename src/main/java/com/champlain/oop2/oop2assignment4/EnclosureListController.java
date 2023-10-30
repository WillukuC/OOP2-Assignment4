package com.champlain.oop2.oop2assignment4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class EnclosureListController {
    @FXML
    private ListView collectionView;

    @FXML
    private Button viewButton;

    @FXML
    private Button backExitButton;

    ObservableList<String> collections = FXCollections.observableArrayList("Lions", "Tigers", "Cougars");
//    ListView<String> collectionView = new ListView<String>(collections);

}


