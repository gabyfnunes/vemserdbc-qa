import java.sql.SQLOutput;
import java.util.Scanner;

public class Exercicio9 {
    public static void main(String[] args){
        Scanner leitorUsuario = new Scanner(System.in);

        System.out.println("Informe a hora do ínicio do Jogo: ");
        int horaInicio = leitorUsuario.nextInt();
        leitorUsuario.nextLine();
        System.out.println("Informe o minuto do ínicio do Jogo: ");
        int minutoInicio = leitorUsuario.nextInt();
        leitorUsuario.nextLine();

        System.out.println("Informe a hora do final do Jogo: ");
        int horaFinal = leitorUsuario.nextInt();
        leitorUsuario.nextLine();
        System.out.println("Informe o minuto do final do Jogo: ");
        int minutoFinal = leitorUsuario.nextInt();
        leitorUsuario.nextLine();


        horaInicio = (horaInicio*60);
        horaFinal = (horaFinal*60);

        int duracaoJogoHoras = ((horaFinal-horaInicio)/60);
        int duracaoJogoMinutos = ((minutoFinal-minutoInicio)%60);

            if(duracaoJogoHoras<=24) {
                System.out.println("Duração do jogo (hh:mm): "+duracaoJogoHoras + ":" + duracaoJogoMinutos);

            }
            else {
                System.out.println("TEMPO MÁXIMO EXCEDIDO!");
            }
    }
}
