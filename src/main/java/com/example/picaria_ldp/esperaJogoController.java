package com.example.picaria_ldp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class esperaJogoController extends Main implements Initializable {

    private Stage stage;
    private Scene scene;

    @FXML
    private Button botaoJogar;
    @FXML
    private Button botaoSair;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Thread readMessage = new Thread(() -> {
            while (true) {
                try {
                    String resposta = dis.readUTF();

                    if(resposta.startsWith("qs")){

                        String[] partes = resposta.split(":");
                        System.out.println(partes[0]);
                        int vez = parseInt(partes[1]);
                        if(vez == 1){

                            System.out.println(partes[1]);

                            botaoJogar.setVisible(true);
                            botaoSair.setText("fodace");
                            botaoSair.setVisible(false);
                        }

                    }
                    System.out.println(resposta);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        readMessage.start();
    }

    @FXML
    protected void voltar(ActionEvent event) throws IOException {
       /* try {
            Parent root = FXMLLoader.load(getClass().getResource("jogo.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


    }

    @FXML
    protected void jogar(ActionEvent event) throws IOException {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("jogo.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}