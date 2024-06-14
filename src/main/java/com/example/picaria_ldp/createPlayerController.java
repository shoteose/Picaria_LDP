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
            String nome = this.inputUsername.getText();
            // s = new Socket(ip, ServerPort);
            cliente= new Cliente(nome,ip,ServerPort);

        }catch (Exception ex) {

            System.out.println(ex.getMessage());

            this.errorName.setText("Erro ao conectar ao servidor!! Tente novamente");
            this.inputUsername.setText("");
            this.inputAdrr.setText("");
            this.inputPorta.setText("");

        }

        //setDos(new DataOutputStream(s.getOutputStream()));
        //setDis(new DataInputStream(s.getInputStream()));

            setJogador(new Jogador(this.inputUsername.getText()));

            Jogadores.add(cliente);

            cliente.enviarMensagem("nome:"+ inputUsername.getText());

            /*Thread sendMessage = new Thread(new Runnable() {
                @Override
                public void run() {

                        String msg = "nome:"+ inputUsername.getText();

                        try {

                            dos.writeUTF(msg);
                            dos.flush();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                }
            });

            sendMessage.start();*/

        Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
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
