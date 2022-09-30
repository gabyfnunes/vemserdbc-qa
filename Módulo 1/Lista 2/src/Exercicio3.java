import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner leitorUsuario = new Scanner(System.in);
        System.out.println("Informe o Nome do jogador: ");
        String nome = leitorUsuario.nextLine();

        while (nome!="sair") {
                System.out.println("Informe o Nome do jogador: ");
                nome = leitorUsuario.nextLine();
                System.out.println("Informe a idade do jogador: ");
                int idade = leitorUsuario.nextInt();
                leitorUsuario.nextLine();
                System.out.println("Informe a altura do jogador: ");
                double altura = leitorUsuario.nextDouble();
                System.out.println("Por fim, informe o peso do jogador: ");
                double peso = leitorUsuario.nextDouble();
                leitorUsuario.nextLine();

                for (int i = 0; i == 100; i++) {
                    double vetoresNumericos[] = {altura, peso, (double) idade};
                    System.out.println(vetoresNumericos[i]);
                }

            }
        if (nome=="sair"){
            System.out.println("cabou");
        }

        }
        }



