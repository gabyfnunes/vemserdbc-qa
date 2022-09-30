import java.util.Scanner;

public class Exercicio5 {

    public static void main (String[] args){
        Scanner leitorUsuario = new Scanner(System.in);

        int aluno1 = leitorUsuario.nextInt();
        leitorUsuario.nextLine();
        double notaMediaProva1 = leitorUsuario.nextDouble();
        leitorUsuario.nextLine();
        double notaMediaExercicio1 = leitorUsuario.nextDouble();
        leitorUsuario.nextLine();

        int aluno2 = leitorUsuario.nextInt();
        leitorUsuario.nextLine();
        double notaMediaProva2 = leitorUsuario.nextDouble();
        leitorUsuario.nextLine();
        double notaMediaExercicio2 = leitorUsuario.nextDouble();
        leitorUsuario.nextLine();

        int aluno3 = leitorUsuario.nextInt();
        leitorUsuario.nextLine();
        double notaMediaProva3 = leitorUsuario.nextDouble();
        leitorUsuario.nextLine();
        double notaMediaExercicio3 = leitorUsuario.nextDouble();
        leitorUsuario.nextLine();

        int aluno4 = leitorUsuario.nextInt();
        leitorUsuario.nextLine();
        double notaMediaProva4 = leitorUsuario.nextDouble();
        leitorUsuario.nextLine();
        double notaMediaExercicio4 = leitorUsuario.nextDouble();
        leitorUsuario.nextLine();

        int aluno5 = leitorUsuario.nextInt();
        leitorUsuario.nextLine();
        double notaMediaProva5 = leitorUsuario.nextDouble();
        leitorUsuario.nextLine();
        double notaMediaExercicio5 = leitorUsuario.nextDouble();
        leitorUsuario.nextLine();


        double[][] matriz = {
                {(int) aluno1, notaMediaProva1, notaMediaExercicio1,},
                {(int) aluno2, notaMediaProva2, notaMediaExercicio2,},
                {(int) aluno3, notaMediaProva3, notaMediaExercicio3,},
                {(int) aluno4, notaMediaProva4, notaMediaExercicio4,},
                {(int) aluno5, notaMediaProva5, notaMediaExercicio5,},
        };


        double notaFinalAluno1 = ((matriz[0][1] * 0.6) + (matriz[0][2]*0.4));
        double notaFinalAluno2 = ((matriz[0][1] * 0.6) + (matriz[0][2]*0.4));
        double notaFinalAluno3 = ((matriz[0][1] * 0.6) + (matriz[0][2]*0.4));
        double notaFinalAluno4 = ((matriz[0][1] * 0.6) + (matriz[0][2]*0.4));
        double notaFinalAluno5 = ((matriz[0][1] * 0.6) + (matriz[0][2]*0.4));

        double[][] matrizFinal = {
                {(int) aluno1, notaMediaProva1, notaMediaExercicio1,notaFinalAluno1},
                {(int) aluno2, notaMediaProva2, notaMediaExercicio2,notaFinalAluno2},
                {(int) aluno3, notaMediaProva3, notaMediaExercicio3,notaFinalAluno3},
                {(int) aluno4, notaMediaProva4, notaMediaExercicio4,notaFinalAluno4},
                {(int) aluno5, notaMediaProva5, notaMediaExercicio5,notaFinalAluno5},
        };
        double variavelComparacao= 0;
        double vetorNotasFinais [] = {notaFinalAluno1,notaFinalAluno2,notaFinalAluno3,notaFinalAluno4};

        for (int i = 0; i < variavelComparacao; i++) {
            vetorNotasFinais[i] = variavelComparacao;
            if (variavelComparacao > i){
                double maiorMedia = i;
                System.out.println(maiorMedia);
            }
            double notaAnterior = (int) i;


        }





        double mediaTodasFinais = (matrizFinal[0][3]  + matrizFinal[1][3] + matrizFinal[2][3]+
                matrizFinal[3][3] + matrizFinal[4][3]) / 5;
        System.out.println(mediaTodasFinais);

    }
}
