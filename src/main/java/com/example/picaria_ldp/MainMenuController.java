package com.example.picaria_ldp;

import java.io.IOException;
import java.util.*;

import com.almasb.fxgl.app.services.SystemBundleService;
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

public class MainMenuController extends Main implements Initializable {

    @FXML
    private ListView<String> highscore;

    @FXML
    private Button botaoCriarJogador;

    private Stage stage;
    private Scene scene;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        for(Jogador qwe: Jogadores){
            String listViewHighScore = qwe.getNome() + " : " + qwe.getCounterWins();
            this.highscore.getItems().add(listViewHighScore);

        }

        ordenarHighScore();

       /* Thread receberMessagem = new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        String msg = dis.readUTF();
                        if(msg.startsWith("")){}
                        System.out.println(msg);

                    } catch (IOException e) {
                    }

            }
        });

        receberMessagem.start();*/



    }

    @FXML protected void goPlay(ActionEvent event) throws IOException {

       /* Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {

                String msg = "qs";

                try {

                    dos.writeUTF(msg);
                    dos.flush();
                    System.out.println(dis);

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        sendMessage.start();*/

        //cliente.enviarMensagem("qs");

        Parent root = FXMLLoader.load(getClass().getResource("esperaJogo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


        stagee=stage;

    }


    @FXML protected void infoGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("howTo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void fechar(ActionEvent event) throws IOException {

        cliente.enviarMensagem("logout");
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();

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


