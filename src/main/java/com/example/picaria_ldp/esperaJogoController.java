package com.example.picaria_ldp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
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
    @FXML
    private Text textoInfo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (esperaJogo == false) {


            Thread readMessage = new Thread(() -> {
                while (true) {
                    try {
                        boolean minhaVez = false;
                        String resposta = dis.readUTF();

                        if (resposta.startsWith("qs")) {

                            String[] partes = resposta.split(":");
                            int vez = parseInt(partes[1]);
                            if (vez == 0) {

                                System.out.println("Entrou no if, apareceu o botão jogar " + partes[1]);
                                SouPlayerUm = true;
                                textoInfo.setText("Partida Encontrada, és o primeiro a Jogar");
                                botaoJogar.setVisible(true);
                                botaoSair.setVisible(false);
                            } else {

                                System.out.println(SouPlayerUm);
                                textoInfo.setText("Partida Encontrada, é a vez do oponente");
                                SouPlayerUm = false;
                                System.out.println(SouPlayerUm);
                                botaoJogar.setDisable(true);
                                botaoJogar.setVisible(false);
                                botaoSair.setVisible(true);
                                botaoSair.setDisable(false);


                            }

                        }

                        if(resposta.startsWith("P1")){
                            textoInfo.setText("Jogaste");

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            readMessage.start();

        }
        else{

            textoInfo.setText("Estás a espera de Jogar de novo");

            Thread readMessage = new Thread(() -> {
                while (true) {
                    try {

                        String resposta = dis.readUTF();

                        if(resposta.startsWith("P1")){
                            textoInfo.setText("P1 jogou");

                        }

                        if(resposta.startsWith("P2")){
                            textoInfo.setText("P2 jogou");

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            readMessage.start();


        }
    }

    @FXML
    protected void voltar(ActionEvent event) throws IOException {
       try {

            Parent root = FXMLLoader.load(getClass().getResource("esperaJogo.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


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