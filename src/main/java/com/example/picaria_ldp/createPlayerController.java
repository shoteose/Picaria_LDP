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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class createPlayerController extends MainMenuController {

    @FXML
    private TextField inputUsername;
    @FXML
    private Button botaoCriarJogador;
    @FXML
    private Text errorName;
    private Stage stage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    protected void voltar(ActionEvent event) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void criarJogador(ActionEvent e) throws IOException {


        if(!this.inputUsername.getText().isEmpty()) {
            this.botaoCriarJogador.setDisable(true);
            Jogador jogador = new Jogador(this.inputUsername.getText());
            MainMenuController.Jogadores.add(jogador);
            inputUsername.clear();
            
        }else{
            errorName.setFill(Color.RED);
            errorName.setText("Nome inválido! Tente de Novo");

        }


    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }

}
