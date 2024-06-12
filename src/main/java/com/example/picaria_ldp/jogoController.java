package com.example.picaria_ldp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class jogoController extends Main implements Initializable{

    ArrayList<Button> Vuttons = new ArrayList<>();
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
    private int count = 0;
    private boolean podeJogar = true;
    @FXML
    private Text infoPecaUm;


    @FXML
    public void jogo(ActionEvent e){

        if(podeJogar){

            if(SouPlayerUm == true){

                Button Button = (Button)e.getSource();
                Button.setOnMouseClicked((mouseEvent) -> {

                    if(count <= 3){

                        if(Button != Button7){

                            setPlayerSymbol(Button);
                            count++;
                            infoPecaUm.setText("Peças do Jogador: "+ (3-count));

                            podeJogar = false;

                        }
                    }

                });

            }else{


            }

        }
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

                try {
                    sendMessageServer(jogador.getNome() + " ganhou!");
                } catch (IOException e) {

                }
            } else if (linha.equals("OOO")) {

                this.podeJogar = false;
                this.count = 0;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {


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
