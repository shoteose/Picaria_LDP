package com.example.picaria_ldp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class createPlayerController extends Main {

    @FXML
    private TextField inputUsername;
    @FXML
    private TextField inputAdrr;
    @FXML
    private TextField inputPorta;
    @FXML
    private Button botaoCriarJogador;
    @FXML
    private Text errorName;
    private Stage stage;
    private Scene scene;

    @FXML
    protected void criarJogador(ActionEvent e) throws IOException {

        try {
            ip= InetAddress.getByName(inputAdrr.getText());
            ServerPort = Integer.parseInt(inputPorta.getText());
            s = new Socket(ip, ServerPort);

        }catch (Exception ex) {
            System.out.println(ex.getMessage());

            this.errorName.setText("Erro ao conectar ao servidor!! Tente novamente");
            this.inputUsername.setText("");
            this.inputAdrr.setText("");
            this.inputPorta.setText("");

        }

        dos = new DataOutputStream(s.getOutputStream());
        dis = new DataInputStream(s.getInputStream());



        String mens;
        boolean existeUsername = Jogadores.contains(this.inputUsername.getText());

        // Existe esse jogadro, logo envia para o servidor o seu nome e suas wins
      /*  if(!existeUsername){

            this.botaoCriarJogador.setDisable(true);

            Thread sendMessage = new Thread(new Runnable() {
                @Override
                public void run() {

                    String msg = inputUsername.getText();

                    for(Jogador jogador: Jogadores){
                        if(jogador.getNome() == inputUsername.getText()){
                            msg= jogador.getNome() + " " + jogador.getCounterWins();
                            try {
                                dos.writeUTF(msg);

                            } catch (IOException e) {
                            }
                            break;
                        }
                    }
                    try {
                        dos.writeUTF(msg);

                    } catch (IOException e) {
                    }


                }
            });

            sendMessage.start();

            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }else{

            errorName.setFill(Color.RED);
            errorName.setText("Já existe esse username!");

        }*/

        // Cria Jogador caso não exista e manda para o server o nome
       // if(!this.inputUsername.getText().isEmpty()) {

            setJogador(new Jogador(this.inputUsername.getText()));
           // System.out.println("n:" + jogador.getNome());
            MainMenuController.Jogadores.add(jogador);


            Thread sendMessage = new Thread(new Runnable() {
                @Override
                public void run() {

                        String msg = "n:"+ inputUsername.getText();
                        System.out.println(msg);
                        try {
                            //dos.writeUTF("why god");
                            dos.writeUTF(msg);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                }
            });

            sendMessage.start();

            /*Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();*/

            
       // }else{
      //      errorName.setFill(Color.RED);
      //      errorName.setText("Nome nulo é inválido! Tente de Novo");
       // }


    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

}
