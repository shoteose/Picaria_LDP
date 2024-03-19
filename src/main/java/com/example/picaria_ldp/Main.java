//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Peca[][] tabuleiro;

    public static void main(String[] args) {

        criaTabuleiro();
        imprimirTabuleiro();
    }

    public static void criaTabuleiro(){
        /**
             int counter = 0;

             Peca[] tabuleiroA1 = new Peca[3];
             Peca[] tabuleiroA2 = new Peca[2];
             Peca[] tabuleiroA3 = new Peca[3];
             Peca[] tabuleiroA4 = new Peca[2];
             Peca[] tabuleiroA5 = new Peca[3];


            do {

                String nome="tabuleiroA" + (counter+1);
                Peca[] nome = new Peca[3];
                tabuleiro
                Peca pecas = new Peca(1);
                tabuleiroA[counter]= pecas;


                System.out.println("Tenho este " + counter + " e tenho este id" + tabuleiroA[counter].getId());
                counter++;

            }while (counter !=3);
        **/

        tabuleiro = new Peca[5][];


        tabuleiro[0] = new Peca[3];
        tabuleiro[1] = new Peca[2];
        tabuleiro[2] = new Peca[3];
        tabuleiro[3] = new Peca[2];
        tabuleiro[4] = new Peca[3];


    }

    public static void imprimirTabuleiro() {

        for (int i = 0; i < tabuleiro.length; i++) {

            for (int j = 0; j < tabuleiro[i].length; j++) {

                if (tabuleiro[i][j] != null) {

                    System.out.print(tabuleiro[i][j].getId() + " ");

                } else {

                    /**if(i%2 != 0){

                        System.out.print("[ " + i + j + " ]");

                    }else{

                        System.out.print("[ " + i + j + " ]");

                    }**/
                    System.out.print("[ " + i + j + " ]");

                }
            }
            System.out.println();
        }
    }

}