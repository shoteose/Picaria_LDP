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
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class jogoController extends Main implements Initializable{

    private Stage stage;
    private Scene scene;

    ArrayList<Button> Vuttons = new ArrayList<Button>();
    private int playerTurn = 0;
    @FXML
    private Button Button1;
    @FXML
    private Button Button2;
    @FXML
    private Button Button3;
    @FXML
    private Button Button4;
    @FXML
    private Button Button5;
    @FXML
    private Button Button6;
    @FXML
    private Button Button7;
    @FXML
    private Button Button8;
    @FXML
    private Button Button9;
    @FXML
    private Button Button10;
    @FXML
    private Button Button11;
    @FXML
    private Button Button12;
    @FXML
    private Button Button13;
    @FXML
    private Button fimT;

    @FXML
    private Text textoGrande;
    private int count = 1;
    private boolean podeJogar = true;
    @FXML
    private Text infoPecaUm;

    private String Jogada;


    @FXML
    public void jogo(ActionEvent e){

        if(podeJogar){

            if(SouPlayerUm == true){

                Button Button = (Button)e.getSource();
                Button.setOnMouseClicked((mouseEvent) -> {

                    if(count <= 3){

                        if(Button != Button7){

                            setPlayerSymbol(Button);

                            infoPecaUm.setText("Peças do Jogador: "+ (3-count));

                            count++;
                            podeJogar = false;
                            fimT.setDisable(false);

                            for(Button c : Vuttons){

                                if(Button == c){

                                    Jogada= "P1:1:"+c.getId();
                                    System.out.println(c.getId());

                                }


                            }

                        }
                    }else{

                        System.out.println("OPA NAO DEVIA DE DAR");
                    }

                });

            }else{

                Button Button = (Button)e.getSource();
                Button.setOnMouseClicked((mouseEvent) -> {

                    if(count <= 3){

                        if(Button != Button7){

                            setPlayerSymbol(Button);
                            count++;
                            infoPecaUm.setText("Peças do Jogador: "+ (3-count));

                            podeJogar = false;
                            fimT.setDisable(false);

                            for(Button c : Vuttons){

                                if(Button == c){

                                    Jogada= "P2:1:"+c.getId();
                                    System.out.println(c.getId());

                                }


                            }
                        }
                    }else{

                        System.out.println("OPA NAO DEVIA DE DAR");
                    }

                });

            }

        }
    }

    public void fimTurno(ActionEvent event) throws IOException {

        vericarWin();


        if(!Objects.equals(Jogada, "")){
            if(!Objects.equals(Jogada,cliente.mensagensR.getLast())){

                cliente.enviarMensagem(Jogada);

                Platform.runLater(() -> {

                    textoGrande.setText("A espera da Jogada do Oponente");

                });

            }
        }

        /*
        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {


                try {

                    dos.writeUTF(Jogada);
                    dos.flush();
                    System.out.println(dis);

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });

        sendMessage.start();
*/

    }

    private void processarMensagem(String mensagem) {



        Platform.runLater(() -> {

            System.out.println("Estou na funca de processar.");

            if(SouPlayerUm){

                if (mensagem.startsWith("P2")) {

                    esperaJogo=false;
                    textoGrande.setText(mensagem);

                    agiliza(mensagem);

                }

            }else{

                if (mensagem.startsWith("P1")) {

                    esperaJogo=false;
                    textoGrande.setText(mensagem);

                    agiliza(mensagem);

                }

            }

        });
    }

    private void agiliza(String mensagem){

        Platform.runLater(() -> {

        String[] partes = mensagem.split(":");
        int parteJogo = parseInt(partes[1]);
        if (parteJogo == 1) {

            System.out.println(partes[1] + " 2 -->" + partes[2]);

            String botaoClicado=partes[2];

            for (Button b:Vuttons){

                if(Objects.equals(b.getId(), botaoClicado)){

                    System.out.println(b.getId() + botaoClicado);
                    setAdvSymbol(b);

                    podeJogar = true;
                    fimT.setDisable(false);
                }
            }
            podeJogar = true;
        }

        });
    }

    public void vericarWin(){

        for (int a = 0; a < 16; a++) {
            String linha = switch (a) {
                case 0 -> Button1.getText() + Button5.getText() + Button7.getText();
                case 1 -> Button2.getText() + Button4.getText() + Button8.getText();
                case 2 -> Button6.getText() + Button10.getText() + Button12.getText();
                case 3 -> Button5.getText() + Button7.getText() + Button9.getText();
                case 4 -> Button7.getText() + Button9.getText() + Button13.getText();
                case 5 -> Button1.getText() + Button6.getText() + Button11.getText();
                case 6 -> Button11.getText() + Button12.getText() + Button13.getText();
                case 7 -> Button1.getText() + Button2.getText() + Button3.getText();
                case 8 -> Button3.getText() + Button8.getText() + Button13.getText();
                case 9 -> Button6.getText() + Button7.getText() + Button8.getText();
                case 10 -> Button2.getText() + Button7.getText() + Button12.getText();
                case 11 -> Button6.getText() + Button5.getText() + Button2.getText();
                case 12 -> Button12.getText() + Button9.getText() + Button8.getText();
                case 13 -> Button11.getText() + Button10.getText() + Button7.getText();
                case 14 -> Button10.getText() + Button7.getText() + Button4.getText();
                case 15 -> Button7.getText() + Button4.getText() + Button3.getText();
                default -> null;
            };

            if (linha.equals("XXX")) {

                this.podeJogar = false;
                this.count = 0;

                cliente.enviarMensagem("G1");
                Platform.runLater(() -> {
                    textoGrande.setText("Ganhaste!! :)");
                });

            } else if (linha.equals("OOO")) {

                this.podeJogar = false;
                this.count = 0;

                Platform.runLater(() -> {
                    textoGrande.setText("Perdeste!! :(");
                });
                cliente.enviarMensagem("G2");
            }
        }
    }

    public void setPlayerSymbol(Button Button) {
        if (SouPlayerUm) {
            Button.setText("X");
        } else {
            Button.setText("O");
        }

    }

    public void setAdvSymbol(Button Button) {

        if (!SouPlayerUm) {
            Button.setText("X");
        } else {
            Button.setText("O");
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cliente.adicionarOuvinte(mensagem -> {
            javafx.application.Platform.runLater(() -> processarMensagem(mensagem));
        });

            if(SouPlayerUm){
                podeJogar=true;
            }else{
                textoGrande.setText("A espera da jogada do Oponente");
                podeJogar=false;
            }
            fimT.setDisable(true);
            Vuttons.add(Button1);
            Vuttons.add(Button2);
            Vuttons.add(Button3);
            Vuttons.add(Button4);
            Vuttons.add(Button5);
            Vuttons.add(Button6);
            Vuttons.add(Button7);
            Vuttons.add(Button8);
            Vuttons.add(Button9);
            Vuttons.add(Button10);
            Vuttons.add(Button11);
            Vuttons.add(Button12);
            Vuttons.add(Button13);


    }
}
