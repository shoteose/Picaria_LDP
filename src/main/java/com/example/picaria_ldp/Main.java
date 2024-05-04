package com.example.picaria_ldp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application{

    public static Tabuleiro tabuleiro;
    public static UserInput input;
    public static Game game;

    @Override
    public void start(Stage stage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        tabuleiro = new Tabuleiro();
        input = new UserInput();
        game = new Game(tabuleiro, input);
        game.start();

        launch(args);

    }

}