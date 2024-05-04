package com.example.picaria_ldp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainMenu.fxml"));
        Parent root = fxmlLoader.load();

        MainMenuController controller = fxmlLoader.getController();
        controller.setStage(stage);  // Passa a referência do Stage para o controlador

        Scene scene = new Scene(root);
        stage.setTitle("Picaria");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}