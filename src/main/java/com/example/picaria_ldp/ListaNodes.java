package com.example.picaria_ldp;

public class ListaNodes {

    Node head;

    public ListaNodes() {
        this.head = null;
    }


    public void addNode(Peca peca) {
        Node newNode = new Node(peca);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current != null) {
                if (current.ce == null) {
                    current.ce = newNode;
                    newNode.cd = current;
                    return;
                } else if (current.c == null) {
                    current.c = newNode;
                    newNode.b = current;
                    return;
                } else if (current.cd == null) {
                    current.cd = newNode;
                    newNode.ce = current;
                    return;
                } else if (current.e == null) {
                    current.e = newNode;
                    newNode.d = current;
                    return;
                } else if (current.d == null) {
                    current.d = newNode;
                    newNode.e = current;
                    return;
                } else if (current.be == null) {
                    current.be = newNode;
                    newNode.bd = current;
                    return;
                } else if (current.b == null) {
                    current.b = newNode;
                    newNode.be = current;
                    return;
                } else if (current.bd == null) {
                    current.bd = newNode;
                    newNode.be = current;
                    return;
                }
                current = current.c; // Movendo para o próximo nó na lista ligada (direção sul)
            }
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println("Node: " + current.peca);
            System.out.println("  CE: " + (current.ce != null ? current.ce.peca.eJogador1 : null));
            System.out.println("  C:  " + (current.c != null ? current.c.peca.eJogador1 : null));
            System.out.println("  CD: " + (current.cd != null ? current.cd.peca.eJogador1 : null));
            System.out.println("  E:  " + (current.e != null ? current.e.peca.eJogador1 : null));
            System.out.println("  D:  " + (current.d != null ? current.d.peca.eJogador1 : null));
            System.out.println("  BE: " + (current.be != null ? current.be.peca.eJogador1 : null));
            System.out.println("  B:  " + (current.b != null ? current.b.peca.eJogador1 : null));
            System.out.println("  BD: " + (current.bd != null ? current.bd.peca.eJogador1 : null));
            System.out.println();
            current = current.c; // Movendo para o próximo nó na lista ligada (direção sul)
        }
    }
}
