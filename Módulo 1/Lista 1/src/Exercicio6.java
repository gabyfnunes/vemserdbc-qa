import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args){
        Scanner leitorUsuario = new Scanner(System.in);

        System.out.println("Informe o total de eleitores: ");
        double totalEleitores = leitorUsuario.nextDouble();
        System.out.println("Quantos foram os votos nulos? ");
        int votosNulos = leitorUsuario.nextInt();
        System.out.println("Quantos foram os votos em branco? ");
        double votosBrancos = leitorUsuario.nextDouble();


        double votosValidos = totalEleitores-votosNulos-votosBrancos;
        double porcentagemVotosBrancos = (votosBrancos/totalEleitores)*100;
        double porcentagemVotosNulos = (votosNulos/totalEleitores)*100;
        double porcentagemVotosValidos = (votosValidos/totalEleitores)*100;


        System.out.println("O total de eleitores foi "+totalEleitores+".");
        System.out.println("Foram "+votosBrancos+" votos brancos. Ou seja, "+porcentagemVotosBrancos+"% dos votos.");
        System.out.println("Foram "+votosNulos+" votos nulos. Ou seja, "+porcentagemVotosNulos+"% dos votos.");
        System.out.println("No fim, houveram "+votosValidos+" votos válidos. Ou seja, "+porcentagemVotosValidos+"% dos votos.");
    }
}
