package com.champlain.oop2.oop2assignment4;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooManagementApplication extends Application {
    public ZooManagementApplication() throws IOException {
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader enclosureListLoader = new FXMLLoader(ZooManagementApplication.class.getResource("enclosureList-view.fxml"));
        Scene scene = new Scene(enclosureListLoader.load());
        stage.setTitle("Zoo Management System");
        stage.setScene(scene);
        stage.show();
    }
    public void importAnimals(){

    }

    public static void main(String[] args) {
        launch();
    }
}