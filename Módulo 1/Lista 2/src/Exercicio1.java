import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner leitorUsuario = new Scanner(System.in);
        System.out.println("Informe o produto");
        String produto = leitorUsuario.nextLine();
        System.out.println("Qual o valor do "+produto+" ?");
        double valorProduto = leitorUsuario.nextDouble();
        leitorUsuario.nextLine();
        int porcentagemDesconto=0;
        double valorDesconto;
        double valorfinal;

        for(int i=1;i<=10;i++){
            porcentagemDesconto= (porcentagemDesconto+5);
            valorDesconto = valorProduto*(porcentagemDesconto/(double)100);
            valorfinal = valorProduto - valorDesconto;
            System.out.println(i + " x " + valorDesconto+ " = " + valorfinal);
        }

    }


}
