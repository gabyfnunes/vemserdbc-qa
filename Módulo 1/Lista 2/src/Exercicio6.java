public class Exercicio6 {

    public static void main (String[] args){

        String diciplinas [] = {"portugues","matematica","historia","geografia","artes"};

        double[][] matriz = {
            {2.3, 5.4,6.5},
            {8.3, 5.6,7.4},
            {3.7, 4.4,10},
            {6.5, 8,1.6},
            {7.5, 5.4,6.5},
        };


        double media1 = ((matriz[0][0]) + (matriz[0][1]) + (matriz[0][2])/3);
        double media2 = ((matriz[0][0]) + (matriz[0][1]) + (matriz[0][2])/3);
        double media3 = ((matriz[0][0]) + (matriz[0][1]) + (matriz[0][2])/3);
        double media4 = ((matriz[0][0]) + (matriz[0][1]) + (matriz[0][2])/3);
        double media5 = ((matriz[0][0]) + (matriz[0][1]) + (matriz[0][2])/3);

        double mediaGeral = (media1+media2+media3+media4+media5)/5;

        System.out.println(diciplinas[0]+":"+media1);
        System.out.println(diciplinas[1]+":"+media2);
        System.out.println(diciplinas[2]+":"+media3);
        System.out.println(diciplinas[3]+":"+media4);
        System.out.println(diciplinas[4]+":"+media5);

        System.out.println("Media total de todas as máterias: "+mediaGeral);

    }

}
