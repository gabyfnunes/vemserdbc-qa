import java.util.Scanner;
public class Exercicio7 {
    public static void main(String[] args) {

        double[] mediaSuperMercado = new double[3];
        double temp = 0;
        int melhorPreço = 0;
        double[][] matriz = {
                {7.31, 9.19, 9.50, 6.99, 8.05, 2.50, 5.99, 9.99, 3.50, 22.30},
                {8.21, 6.20, 8.50, 6.30, 7.50, 3.0, 6.99, 12.20, 2.50, 21.10},
                {7.99, 8.50, 10.99, 5.60, 7.80, 4.20, 8.10, 11.30, 4.60, 20.0}
        };

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                temp += matriz[i][j];
            }
            mediaSuperMercado[i] = temp / matriz[i].length;
            temp = 0;
        }

        for (int i = 0; i < mediaSuperMercado.length; i++){
            if(mediaSuperMercado[i] > temp){
                temp  = mediaSuperMercado[i];
                melhorPreço = i + 1;
            }
        }

        System.out.println("O mercado mais barato é o: "+melhorPreço+"º");
    }
}
