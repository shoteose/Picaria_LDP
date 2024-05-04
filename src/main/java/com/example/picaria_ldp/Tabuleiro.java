package com.example.picaria_ldp;

public class Tabuleiro {

    private Peca[][] tabuleiro;

    public Tabuleiro() {
        this.tabuleiro = new Peca[5][5];
    }

    public void imprimirTabuleiro() {

        for (int i = 0; i < tabuleiro.length; i++) {

            for (int j = 0; j < tabuleiro[i].length; j++) {

                if (tabuleiro[i][j] != null) {

                    System.out.println(tabuleiro[i][j].getId() + " ");

                } else {

                    if(i%2 == 0){

                        if(j%2 == 0){

                            if (tabuleiro[i][j] == null){

                                System.out.print(" [   ] ");

                            }else{

                                tabuleiro[i][j].getId();

                            }


                        }

                    }else{

                        if(j%2 != 0){

                            if (tabuleiro[i][j] == null){

                                System.out.print("   [   ]  ");

                            }else{

                                tabuleiro[i][j].getId();

                            }

                        }


                    }


                }
            }
            System.out.println();
        }
    }

}
