package com.example.picaria_ldp;
import java.util.*;
public class Game {

    private Tabuleiro tabuleiro;
    private UserInput input;
    private LinkedList<Jogador> jogadores = new LinkedList<Jogador>();

    public Game(Tabuleiro tabuleiro, UserInput input) {
        this.tabuleiro = tabuleiro;
        this.input = input;
    }

    public void start() {
        tabuleiro.imprimirTabuleiro();
        MenuIntro();
    }

    private void MenuIntro() {

        boolean sair = false;

        do {

            System.out.println("""
                          PICARIA
                          
                     1- Jogar
                     2- Adicionar Jogadores
                     3- Ranking
                     4- Sair
                    
                    """);
            System.out.print("Escolha a opção: ");
            int escolha = input.lerInt();

            switch (escolha) {

                case 1:
                    Jogar();
                    break;
                case 2:
                    adicionarJogador();
                    break;
                case 3:

                    break;
                case 4:
                    sair = true;
                    break;
            }

        } while (!sair);
    }

    private void Jogar() {

        boolean sair = false;
        boolean jogador1Add = false;
        boolean jogador2Add = false;

        do {

            System.out.println("""
                          PICARIA
                          
                     1- Adicionar Jogador 1
                     2- Adicionar Jogador 2
                     3- Jogar
                    
                    """);
            System.out.print("Escolha a opção: ");
            int escolha = input.lerInt();

            switch (escolha) {

                case 1:
                    adicionarJogador();
                    jogador1Add = true;
                    break;
                case 2:
                    adicionarJogador();
                    jogador2Add = true;
                    break;
                case 3:
                    if (jogador1Add && jogador2Add) {


                    } else {
                        System.out.println("Jogadores não adicionados!");
                    }
                    break;
            }

        } while (!sair);
    }

    private void adicionarJogador() {

        boolean voltar = false;

        do {

            System.out.println("""
                          PICARIA
                          
                     1- Ver Jogadores já existentes
                     2- Adicionar Jogadores
                     3- Voltar
                    
                    
                    """);
            System.out.print("Escolha a opção: ");
            int escolha = input.lerInt();

            switch (escolha) {

                case 1:
                    System.out.println(jogadores);
                    break;
                case 2:


                    break;
                case 3:
                    voltar = true;
                    break;
            }

        } while (!voltar);
    }
}
    

