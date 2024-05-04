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
    private Parent root;
    public LinkedList<Jogador> Jogadores= new LinkedList<Jogador>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Jogador asd= new Jogador("joao",2);
        Jogador aaa= new Jogador("konas",8);
        Jogador bbb= new Jogador("hugo",9);
        Jogador ccc= new Jogador("lol",1);
        Jogadores.add(asd);
        Jogadores.add(aaa);
        Jogadores.add(bbb);
        Jogadores.add(ccc);

        Collections.sort(Jogadores, new Comparator<Jogador>() {
            @Override
            public int compare(Jogador j1, Jogador j2) {
                return Integer.compare(j2.getCounterWins(), j1.getCounterWins());
            }
        });

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
    @FXML
    public void mudaCenaCriar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("createPlayer.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Picaria");
        this.stage.setScene(scene);
        this.stage.show();
    }

    @FXML protected void infoGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("howTo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }
}


