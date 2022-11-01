import javax.swing.*;
import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args){
        Scanner leitorUsuario = new Scanner(System.in);

        System.out.println("Informe a base do retângulo: ");
        int base = leitorUsuario.nextInt();
        System.out.println("Informe a altura do retângulo: ");
        int altura = leitorUsuario.nextInt();

        int area = base*altura;

        System.out.println("A área do retângulo é "+area+"m².");


    }
}
