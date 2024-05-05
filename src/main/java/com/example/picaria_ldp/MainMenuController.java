package com.example.picaria_ldp;

import java.io.IOException;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Node;


import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private ListView<String> highscore;

    @FXML
    private Button botaoCriarJogador;

    private Stage stage;
    private Scene scene;
    public static LinkedList<Jogador> Jogadores= new LinkedList<Jogador>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ordenarHighScore();

        for(Jogador qwe: Jogadores){
            String listViewHighScore = qwe.getNome() + " : " + qwe.getCounterWins();
            this.highscore.getItems().add(listViewHighScore);

        }

    }

    @FXML protected void goPlay(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("jogadorMix.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML protected void mudaCenaCriar(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createPlayer.fxml"));
            Parent root = fxmlLoader.load();
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML protected void infoGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("howTo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void voltar(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ordenarHighScore() {

        Collections.sort(Jogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador j1, Jogador j2) {
                return Integer.compare(j2.getCounterWins(), j1.getCounterWins());
            }
        });

    }

    public void listarJogadores() {

        for(Jogador jogador: Jogadores){
            System.out.println(jogador.getNome() + " : " + jogador.getCounterWins());
        }

    }
    public void addJogador(Jogador jogador) {

        Jogadores.add(jogador);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
}


