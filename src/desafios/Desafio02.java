package desafios;

import java.util.Arrays;
import java.util.Scanner;

public class Desafio02 {

    static char[] t = new char[9];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int user = 0;
        int pc = 0;
        char jogar;

        do {
            limpar();
            int jogadas = 0;

            while (jogadas < 9) {
                mostrar();
                usuario();
                jogadas++;

                if (venceu('x')) {

                    user++;
                    System.out.println("usuario venceu.");
                    break;
                }

                if (jogadas == 9) {

                    System.out.println("velha.");
                    break;
                }

                computador();
                jogadas++;

                if (venceu('o')) {

                    pc++;
                    System.out.println("computador venceu.");
                    break;
                }
            }

            mostrar();

            System.out.print("jogar novamente? (s/n): ");
            jogar = sc.next().charAt(0);

        } while (jogar == 's');

        System.out.println("usuario: " + user);
        System.out.println("computador: " + pc);
    }

    static void usuario() {
        int posicao;

        do {
            System.out.print("posicao (1-9): ");
            posicao = sc.nextInt() - 1;

        } while (t[posicao] != ' ');

        t[posicao] = 'x';
    }

    static void computador() {
        if (tentar('o') || tentar('x')) {
            return;
        }

        for (int i = 0; i < 9; i++) {

            if (t[i] == ' ') {

                t[i] = 'o';
                return;
            }
        }
    }

    static boolean tentar(char jogador) {
        for (int i = 0; i < 9; i++) {
            if (t[i] == ' ') {

                t[i] = jogador;

                if (venceu(jogador)) {

                    t[i] = 'o';
                    return true;
                }

                t[i] = ' ';
            }
        }

        return false;
    }

    static boolean venceu(char jogador) {
        int[][] possibilidades = {
                { 0, 1, 2 },
                { 3, 4, 5 },
                { 6, 7, 8 },
                { 0, 3, 6 },
                { 1, 4, 7 },
                { 2, 5, 8 },
                { 0, 4, 8 },
                { 2, 4, 6 }
        };

        for (int[] p : possibilidades) {
            if (t[p[0]] == jogador && t[p[1]] == jogador && t[p[2]] == jogador) {
                return true;
            }
        }

        return false;
    }

    static void limpar() {
        Arrays.fill(t, ' ');
    }

    static void mostrar() {
        System.out.println(
                t[0] + "|" + t[1] + "|" + t[2] + "\n" +
                "-+-+-\n" +
                t[3] + "|" + t[4] + "|" + t[5] + "\n" +
                "-+-+-\n" +
                t[6] + "|" + t[7] + "|" + t[8]);
    }
}
