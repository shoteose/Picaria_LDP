package com.example.picaria_ldp;

import javafx.stage.Stage;

import java.io.*;
import java.net.*;
import java.util.*;


public class Main {

    public static Game game = new Game();
    public static Socket s;

    public static Stage stagee;
    public static int ServerPort;
    public InetAddress ip;
    public static boolean temInimigo = false;
    public static boolean esperaJogo = false;


    public static boolean SouPlayerUm;

    public static int counterE = 0;

    public static ArrayList<String> historico = new ArrayList();

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
                    dos.flush();

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

    public static DataInputStream getDis() {
        return dis;
    }

    public static void setDis(DataInputStream dis) {
        Main.dis = dis;
    }

    public static DataOutputStream getDos() {
        return dos;
    }

    public static void setDos(DataOutputStream dos) {
        Main.dos = dos;
    }
}