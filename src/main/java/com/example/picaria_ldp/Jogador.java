package com.example.picaria_ldp;

public class Jogador {

    private String nome;
    private int counterWins;

    public Jogador(String nome){

        this.nome=nome;
        this.counterWins=0;

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
