package com.champlain.oop2.oop2assignment4;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ZooManagementApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader zooApplicationLoader = new FXMLLoader(ZooManagementApplication.class.getResource("enclosureList-view.fxml"));
        Scene scene = new Scene(zooApplicationLoader.load());
        stage.setTitle("Zoo Management System");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}