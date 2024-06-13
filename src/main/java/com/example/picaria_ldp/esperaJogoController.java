package com.example.picaria_ldp;

import javafx.application.Platform;
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


        cliente.enviarMensagem("qs");

        System.out.println("Estou a espera de jogar? " + esperaJogo);
        System.out.println("Sou player Um? " + SouPlayerUm);



        cliente.adicionarOuvinte(mensagem -> {

            Platform.runLater(() -> processarMensagem(mensagem));

        });

       /* String lastMensagem= cliente.mensagensR.getLast();

        processarMensagem(lastMensagem);*/



       /* if (!esperaJogo) {
            // Se não está à espera, configura a interface para uma nova partida
            textoInfo.setText("Preparando para a nova partida...");
        } else {
            counterE++;
            textoInfo.setText("Estás a espera de Jogar de novo " + counterE);

            if (SouPlayerUm) {
                textoInfo.setText("Aguardando a jogada do adversário...");
            } else {
                textoInfo.setText("É sua vez de jogar...");
            }
        }*/

    }

    private void processarMensagem(String mensagem) {


        Platform.runLater(() -> {

            System.out.println("Estou na funca de processar.");
            if (mensagem.startsWith("qs")) {

                System.out.println(mensagem + " processamento de mensagem");
                String[] partes = mensagem.split(":");
                int vez = parseInt(partes[1]);
                if (vez %2 == 0) {
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

        });
    }

    @FXML
    protected void voltar(ActionEvent event) throws IOException {

        /*
        try {

            /*Parent root = FXMLLoader.load(getClass().getResource("esperaJogo.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
           if(SouPlayerUm==true){

               Thread readMessage = new Thread(() -> {
                   while (true) {
                       try {

                           System.out.println("Estou dentro do readMessage e sou Player 1 e Estou a espera");
                           String resposta = dis.readUTF();

                           if(resposta.startsWith("P2")){
                               textoInfo.setText("P2 jogou");

                           }
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               });

               readMessage.start();

           }else{

               Thread readMessage = new Thread(() -> {
                   while (true) {
                       try {

                           String resposta = dis.readUTF();

                           if(resposta.startsWith("P1")){
                               textoInfo.setText("P1 jogou");

                           }
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                   }
               });

               readMessage.start();

           }





        } catch (Exception e) {
            e.printStackTrace();
        }
*/

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