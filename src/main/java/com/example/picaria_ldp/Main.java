package com.example.picaria_ldp;

import java.io.*;
import java.net.*;
import java.util.*;


public class Main {

    public static Game game = new Game();
    public static Socket s;
    public final static int ServerPort = 1234;

    public static LinkedList<Jogador> Jogadores= new LinkedList<Jogador>();

    public static DataInputStream dis;
    public static DataOutputStream dos;


    public static void main(String[] args) throws UnknownHostException, IOException {

        Scanner scanner = new Scanner(System.in);
        InetAddress ip = InetAddress.getByName("localhost");
        s = new Socket(ip, ServerPort);
        dos = new DataOutputStream(s.getOutputStream());
        dis = new DataInputStream(s.getInputStream());

        Thread rodaGame = new Thread(new Runnable() {
            @Override
            public void run() {

                game.main(args);

            }
        });
        Thread sendMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String msg = scanner.nextLine();
                    try {
                        dos.writeUTF(msg);
                    } catch (IOException e) {
                    }
                }

            }
        });

        Thread readMessage = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String msg = dis.readUTF();
                        System.out.println(msg);
                    } catch (IOException e) {
                    }
                }
            }
        });

        rodaGame.start();
        sendMessage.start();
        readMessage.start();



    }

    public void initialize(URL url, ResourceBundle resourceBundle) {}

}