import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matriculaMaiorNota = 0;
        double notaFinal = 0, mediaProva, mediaTrabalho, maiorNota = 0, notaTotal = 0, mediaNotaTotal;
        double[][] matriz = new double[5][4];

        for (int i = 0; i < matriz.length; i++){
            System.out.println("\nInforme os dados do aluno: "+(i + 1)+" (Matricula, Média das provas, Medias dos trabalhos)");
            for (int j = 0; j < matriz[i].length - 1; j++){
                matriz[i][j] = scanner.nextDouble();
            }
        }

        for(int i = 0; i < matriz.length; i++){
            mediaProva = matriz[i][1];
            mediaTrabalho = matriz[i][2];
            notaFinal = mediaProva * 0.6 + mediaTrabalho * 0.4;
            matriz[i][3] = notaFinal;

            notaTotal += notaFinal;

            if(notaFinal > maiorNota){
                maiorNota = notaFinal;
                matriculaMaiorNota = (int) matriz[i][0];
            }
        }
        mediaNotaTotal = notaTotal / matriz.length;

        System.out.println("Matrícula com maior nota: "+matriculaMaiorNota);
        System.out.printf("Média das notas finais: %.2f\n",mediaNotaTotal);

    }
}