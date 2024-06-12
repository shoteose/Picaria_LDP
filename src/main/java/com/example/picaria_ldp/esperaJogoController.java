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

        if(esperaJogo==false){


        Thread readMessage = new Thread(() -> {
            while (true) {
                try {
                    boolean minhaVez = false;
                    String resposta = dis.readUTF();

                    if(resposta.startsWith("qs")){

                        String[] partes = resposta.split(":");
                        int vez = parseInt(partes[1]);
                        if(vez == 0){

                            System.out.println( "Entrou no if, apareceu o botão jogar" + partes[1]);
                            System.out.println(SouPlayerUm);
                            SouPlayerUm = true;
                            System.out.println(SouPlayerUm);
                            textoInfo.setText("Partida Encontrada, és o primeiro a Jogar");
                            botaoJogar.setVisible(true);
                            botaoSair.setVisible(false);
                        }else{

                            System.out.println(SouPlayerUm);
                            textoInfo.setText("Partida Encontrada, é a vez do oponente");
                            SouPlayerUm =false;
                            System.out.println(SouPlayerUm);
                            botaoJogar.setDisable(true);
                            botaoJogar.setVisible(true);
                            botaoSair.setVisible(false);

                            do{

                                Thread readMessage2 = new Thread(() -> {
                                    while (true) {
                                        try {

                                            String resposta2 = dis.readUTF();

                                            if (resposta2.startsWith("P1")) {
                                                this.botaoJogar.setVisible(true);
                                                this.botaoSair.setDisable(false);
                                            }

                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });

                                readMessage2.start();



                            }while(minhaVez == false);

                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        readMessage.start();
        }else{

            this.textoInfo.setText("A espera da jogada do oponente");
            this.botaoSair.setVisible(false);
            this.botaoJogar.setDisable(true);

            Thread readMessage = new Thread(() -> {
                while (true) {
                    try {

                        String resposta = dis.readUTF();

                        if(SouPlayerUm == true){

                            if(resposta.startsWith("P2")){

                                System.out.println("Sou o Player 1 e o Player 2 acabou de jogar");

                            }

                        }else{

                            if(resposta.startsWith("P1")){

                                System.out.println("Sou o Player 2 e o Player 1 acabou de jogar");

                            }
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