public class Exercicio7 {
    public static void main(String[] args) {

        double[] mediaSuperMercado = new double[10];
        double aux = 0;
        int melhorPreço = 0;
        double[][] matriz = {
                {7.31, 9.19, 9.50},
                {8.21, 6.20, 8.50},
                {7.99, 8.50, 10.9},
                {6.99, 8.05, 2.50},
                {5.99, 9.99, 3.50},
                {22.30,6.30, 7.50},
                {3.0, 6.99, 12.20},
                {2.5, 21.10, 5.60},
                {7.80, 4.20, 8.10},
                {11.30, 4.60, 7,50}
        };

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                aux += matriz[i][j];
            }
            mediaSuperMercado[i] = aux / matriz[i].length;
            aux = 0;
        }

        for (int i = 0; i < mediaSuperMercado.length; i++){
            if(mediaSuperMercado[i] > aux){
                aux  = mediaSuperMercado[i];
                melhorPreço = i + 1;
            }
        }

        System.out.println("O mercado mais barato é o: "+melhorPreço+"º");
    }
}