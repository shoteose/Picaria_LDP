package com.example.picaria_ldp;

public class Node {

    Jogador Jogador;
    Node next;

    public Node(Jogador Embarcacao) {
        this.Jogador = Jogador;
        this.next = null;
    }

    public Jogador getJogador() {
        return Jogador;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}
