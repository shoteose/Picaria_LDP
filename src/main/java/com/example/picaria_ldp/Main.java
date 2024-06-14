package com.example.picaria_ldp;

import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.util.*;

import static java.lang.Integer.parseInt;


public class Main {

    public static Game game = new Game();
    public static Socket s;

    public static Stage stagee;
    public static int ServerPort;
    public InetAddress ip;

    public static boolean esperaJogo = false;


    public static boolean SouPlayerUm;

    public static LinkedList<Cliente> Jogadores= new LinkedList<Cliente>();

    public static Cliente cliente;

    public Jogador jogador;
    public static void main(String[] args) throws UnknownHostException, IOException {


        Thread rodaGame = new Thread(new Runnable() {
            @Override
            public void run() {

                game.main(args);

            }
        });

        rodaGame.start();

    }

    /*public void sendMessageServer(String msg) throws IOException {

        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    dos.writeUTF(msg);
                    dos.flush();

                } catch (IOException e) {
                }


            }
        });

    }*/

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }


}