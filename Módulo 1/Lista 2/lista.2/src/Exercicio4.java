import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args){

        Scanner leitorUsuario = new Scanner(System.in);

        int[] numeros = new int[20];

        for(int i = 0; i<=19; i++) {
            System.out.println("Informe um número: ");
            numeros[i] = leitorUsuario.nextInt();
        }
        for(int i = 19; i>=0; i--){
            System.out.println(numeros[i]);

        }


    }
}
