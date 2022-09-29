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
        int  duracaoJogoHoras = 0;
        int  duracaoJogoMinutos =0;

        if(horaFinal<horaInicio) {
            duracaoJogoHoras = ((24 - horaInicio) + horaFinal);
            if(minutoFinal<minutoInicio){
                duracaoJogoMinutos = ((minutoFinal - minutoInicio) % 60)*(-1);
            }
            else{
                duracaoJogoMinutos = ((minutoFinal - minutoInicio) % 60);
            }
        }
        else{
            duracaoJogoHoras = ((horaFinal-horaInicio));
            duracaoJogoMinutos = ((minutoFinal - minutoInicio) % 60);
        }


        if(duracaoJogoHoras<24) {
                System.out.println("Duração do jogo (hh:mm): "+duracaoJogoHoras + ":" + duracaoJogoMinutos);

            }
            else {
                System.out.println("TEMPO MÁXIMO EXCEDIDO!");
            }
    }
}
