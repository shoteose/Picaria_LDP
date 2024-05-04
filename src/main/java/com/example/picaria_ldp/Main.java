package com.example.picaria_ldp;
import java.util.*;


public class Main {

    public static Tabuleiro tabuleiro;
    public static UserInput input;
    public static Game game;

    public static void main(String[] args) {

        tabuleiro = new Tabuleiro();
        input = new UserInput();
        game = new Game(tabuleiro, input);
        game.start();

    }

}