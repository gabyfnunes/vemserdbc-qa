import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner leitorUsuario = new Scanner(System.in);
        System.out.println("Jogador 1,escolha um número:");
        int numeroAdivinhar = leitorUsuario.nextInt();
        System.out.println("Jogador 2, sua vez! Tente adivinhar qual é o número do Jogador 1: ");
        int tentativa = leitorUsuario.nextInt();

        while (tentativa != numeroAdivinhar) {
            if (tentativa > numeroAdivinhar) {
                System.out.println("O número a ser encontrado é menor que o que vc digitou. ");
            }

            if (tentativa < numeroAdivinhar) {
                System.out.println("O número a ser encontrado é maior que o que vc digitou. ");
            }

            System.out.println("Jogador 2, tente de novo: ");
            int tentativa2 = leitorUsuario.nextInt();
            tentativa = tentativa2;
        }
        System.out.println("Parabéns! Você adivinhou!");

    }
}
