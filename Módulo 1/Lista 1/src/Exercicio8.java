import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args){
        Scanner leitorUsuario = new Scanner(System.in);
        System.out.println("Informe o código do cargo do funcionário: ");
        String codigoCargo = leitorUsuario.nextLine();
        System.out.println("Informe o salário atual do funcionário: ");
        double salarioAntesAumento = leitorUsuario.nextInt();
        leitorUsuario.nextLine();
        double salarioDepoisAumento=0;

        switch (codigoCargo){
            case "101":
                salarioDepoisAumento = salarioAntesAumento+(salarioAntesAumento*0.4);
                System.out.println("Cargo Gerente (101);\nSalário anterior: "+salarioAntesAumento+"R$\n" +
                        "Salário com aumento previsto (40%): "+salarioDepoisAumento+"R$\n" +
                        "Total de aumento recebido: "+(salarioDepoisAumento-salarioAntesAumento)+" R$.");

                break;
            case "102":
                salarioDepoisAumento = salarioAntesAumento+(salarioAntesAumento*0.2);
                System.out.println("Cargo Engenheiro (102);\nSalário anterior: "+salarioAntesAumento+"R$\n" +
                        "Salário com aumento previsto (20%): "+salarioDepoisAumento+"R$\n" +
                        "Total de aumento recebido: "+(salarioDepoisAumento-salarioAntesAumento)+" R$.");

                break;
            case "103":
                salarioDepoisAumento = salarioAntesAumento+(salarioAntesAumento*0.3);
                System.out.println("Cargo Técnico (103);\nSalário anterior: "+salarioAntesAumento+"R$\n" +
                        "Salário com aumento previsto (30%): "+salarioDepoisAumento+"R$\n" +
                        "Total de aumento recebido: "+(salarioDepoisAumento-salarioAntesAumento)+" R$.");

                break;
            default:
                salarioDepoisAumento = salarioAntesAumento+(salarioAntesAumento*0.4);
                System.out.println("Cargo: Não identificado (null);\nSalário anterior: "+salarioAntesAumento+"R$\n" +
                        "Salário com aumento previsto (40%): "+salarioDepoisAumento+"R$\n" +
                        "Total de aumento recebido: "+(salarioDepoisAumento-salarioAntesAumento)+" R$.");
        }

    }
}
