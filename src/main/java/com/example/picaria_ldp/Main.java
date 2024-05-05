package com.example.picaria_ldp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static Game game = new Game();
    public static Socket s;
    public final static int ServerPort = 1234;

    public static void main(String[] args) throws UnknownHostException, IOException {
        game.main(args);

        try {
// Cria um socket para comunicar com o servidor
            s = new Socket("localhost", 6666);
// Após conectar obtem o Stream (DataStream) do servidor
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
// Escreve dados no Stream
            dos.writeUTF("Olá servidor.");
// Envia dados
            dos.flush();
// Fecha Stream e coneção
            dos.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}