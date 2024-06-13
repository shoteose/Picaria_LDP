package com.example.picaria_ldp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ArrayList<String> mensagensR = new ArrayList<String>();

    private List<OuvinteMensagem> ouvintes = new ArrayList<>();

    public Cliente(InetAddress ip, int porta) throws IOException {

        s = new Socket(ip, porta);
        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());

        System.out.println("Cliente inicializado com sucesso.");

        Thread lerMensagem = new Thread(() -> {
            try {
                while (true) {
                    String mensagem = dis.readUTF();
                    notificarOuvintes(mensagem);
                    System.out.println("ouvi: " + mensagem);
                    mensagensR.add(mensagem);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        lerMensagem.start();
    }

    public void enviarMensagem(String mensagem) {
        try {
            dos.writeUTF(mensagem);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void adicionarOuvinte(OuvinteMensagem ouvinte) {
        ouvintes.add(ouvinte);

    }

    private void notificarOuvintes(String mensagem) {
        for (OuvinteMensagem ouvinte : ouvintes) {
            ouvinte.mensagemRecebida(mensagem);

        }
    }

    public interface OuvinteMensagem {
        void mensagemRecebida(String mensagem);
    }
}
