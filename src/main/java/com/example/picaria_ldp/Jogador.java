package com.example.picaria_ldp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Jogador implements Serializable {


    private String name;
    private DataInputStream dis;
    private DataOutputStream dos;
    Socket s;
    private String nome;
    private int counterWins;

    public Jogador(String nome){

        this.nome=nome;
        this.counterWins=0;

    }

    public Jogador(String nome, int a){

        this.nome=nome;
        this.counterWins=a;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCounterWins() {
        return counterWins;
    }

    public void ganhou() {
        this.counterWins ++;
    }
}
