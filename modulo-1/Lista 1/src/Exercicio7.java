import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args){
        Scanner leitorUsuario = new Scanner(System.in);

        System.out.println("Informe o código do produto: ");
        String codigoProduto = leitorUsuario.nextLine();
        System.out.println("Informe a quantidade de produto: ");
        int quantidadeProdutos = leitorUsuario.nextInt();
        leitorUsuario.nextLine();
        double valorTotal=0;

        switch (codigoProduto){

            case "ABCD":
                valorTotal = quantidadeProdutos * 5.3;
                System.out.println("Valor total: "+valorTotal+" R$.");

                break;
            case "XYPK":
                valorTotal = quantidadeProdutos * 6;
                System.out.println("Valor total: "+valorTotal+" R$.");

                break;
            case "KLMP":
                valorTotal = quantidadeProdutos * 3.2;
                System.out.println("Valor total: "+valorTotal+" R$.");

                break;
            case "QRST":
                valorTotal = quantidadeProdutos * 2.5;
                System.out.println("Valor total: "+valorTotal+" R$.");

                break;

            default:
                System.out.println("Código Inválido.");


        }

    }
}
