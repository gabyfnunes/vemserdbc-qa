import java.util.Scanner;
public class Exercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = {12, 5, 3, 4, 0, 7, 28, 64, 1, 10};
        int contagemNumerosIguais = 0;
        int contagemMenorNumero = 0;
        int contagemMaiorNumero = 0;
        int numero;

        System.out.println("Digite um número inteiro qualquer: ");
        numero = scanner.nextInt();

        for (int i = 0; i < numeros.length; i++){
            if(numero > numeros[i]){
                contagemMenorNumero++;
            } else if (numero < numeros[i]) {
                contagemMaiorNumero++;
            }else {
                contagemNumerosIguais++;
            }
        }

        System.out.println("No vetor tem "+contagemNumerosIguais+" números iguais a "+numero);
        System.out.println("No vetor tem  "+contagemMenorNumero+" números menores que "+numero);
        System.out.println("No vetor tem  "+contagemMaiorNumero+" números maiores que "+numero);
    }

}
