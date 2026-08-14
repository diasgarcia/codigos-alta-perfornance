package jogomario;

import java.util.Scanner;

public class PontosNivel {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int mario[][] = new int[678][64];
        int ponto[] = new int[64];

        for (int i = 0; i < 678; i++) {
            System.out.println();
            for (int j = 0; j < 64; j++) {
                System.out.printf("Pontos do jogador %d no nivel %d: ", i + 1, j + 1);
                mario[i][j] = ler.nextInt();
                ponto[j] = 0;
            }
        }

        for (int i = 0; i < 678; i++) {
            for (int j = 0; j < 64; j++) {
                ponto[j] = 0;
            }
        }

        System.out.println();

        for (int j = 0; j < 64; j++) {
            System.out.printf("Total de pontos dos jogadores no nivel %d é de %d \n", j + 1, ponto[j]);
        }
    }

}
