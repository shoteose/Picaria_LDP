package com.example.picaria_ldp;

import java.io.*;
import java.net.*;
import java.util.*;


public class Main {

    public static Game game = new Game();
    public static Socket s;
    public static int ServerPort;
    public InetAddress ip;

    public static LinkedList<Jogador> Jogadores= new LinkedList<Jogador>();

    public static DataInputStream dis;
    public static DataOutputStream dos;


    public static void main(String[] args) throws UnknownHostException, IOException {


        Thread rodaGame = new Thread(new Runnable() {
            @Override
            public void run() {

                game.main(args);

            }
        });

        rodaGame.start();

    }

    public void initialize(URL url, ResourceBundle resourceBundle) {}

}