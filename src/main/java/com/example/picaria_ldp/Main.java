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

    public void sendMessageServer(String msg) throws IOException {

        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    dos.writeUTF(msg);

                } catch (IOException e) {
                }


            }
        });

    }

   /* public void sendJogo(jogoController jogo) throws IOException {

        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    dos.writeUTF(jogo.toString());

                } catch (IOException e) {
                }


            }
        });

    }*/

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
}