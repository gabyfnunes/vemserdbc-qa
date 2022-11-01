import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {

        Scanner leitorUsuario = new Scanner(System.in);

        System.out.println("Escolha o Estado: \n1-Goiás; \n2-Distrito Federal; \n3-Bahia.");

        int escolhaEstado = leitorUsuario.nextInt();
        leitorUsuario.nextLine();

        if (escolhaEstado == 1) {
            System.out.println("Escolha a Cidade: \n1-Goiania; \n2-Caldas Novas.");
            int escolhaCidade = leitorUsuario.nextInt();
            leitorUsuario.nextLine();
            if (escolhaCidade == 1) {
                System.out.println("Goiânia é um município brasileiro, capital do estado de Goiás. Possui uma geografia contínua,\n" +
                        "com poucos morros e baixadas, caracterizada por ser uma região do Planalto Central do Brasil.\n" +
                        "Possui 1.555.626 habitantes. O festival mais esperado são os de Música Sertaneja \n" +
                        "Baseado em parâmetros como educação, renda e saúde, o Índice de Desenvolvimento Humano (IDH) de Goiânia\n" +
                        "é de 0.799, valor considerado alto e o maior de Goiás.");
            }
            if (escolhaCidade == 2) {
                System.out.println("Caldas Novas é uma cidade no centro do Brasil conhecida pelos seus banhos termais.\n" +
                        "As suas piscinas naturais e artificiais vão de parques temáticos a spas." +
                        "Baseado em parâmetros como educação, renda e saúde, o Índice de Desenvolvimento Humano (IDH) de Goiânia\n" +
                        "é de 0.733 e a população estimada é de 95.183 habitantes.");
            }

        }

        if (escolhaEstado == 2) {
            System.out.println("Escolha a Cidade: \n1-Taguatinga; \n2-Ceilândia.");
            int escolhaCidade = leitorUsuario.nextInt();
            leitorUsuario.nextLine();
            if (escolhaCidade == 1) {
                System.out.println("Taguatinga é uma região administrativa do Distrito Federal brasileiro.\n" +
                        "Conta com média de 16 683 habitante e Índice de Desenvolvimento Humano (IDH) de 0,873.\n" +
                        "Uma das principais festividade é A festa de Pentecostes em Taguatinga Sul.");
            }
            if (escolhaCidade == 2) {
                System.out.println("Ceilândia é uma região administrativa do Distrito Federal brasileiro.\n" +
                        "Com uma população de cerca de 400 mil habitantes, é considerada a região administrativa\n" +
                        "com maior influência nordestina no Distrito Federal. O Índice de Desenvolvimento Humano (IDH)\n" +
                        "é de 0,747. Um dos maiores Festivais aqui comemorados é O MAIOR SÃO JOÃO DO CERRADO.");
            }

        }
        if (escolhaEstado == 3) {
            System.out.println("Escolha a Cidade: \n1-Salvador; \n2-Porto Seguro.");
            int escolhaCidade = leitorUsuario.nextInt();
            leitorUsuario.nextLine();
            if (escolhaCidade == 1) {
                System.out.println("Salvador, a capital do estado da Bahia no nordeste do Brasil.\n" +
                        "É conhecida pela arquitetura colonial portuguesa, pela cultura afrobrasileira e pelo litoral tropical.\n" +
                        "O Índice de Desenvolvimento Humano (IDH) é de 0,673 e possui cerca de 2.886.698 de habitantes \n" +
                        "O carnaval de Salvador é a maior festa de rua do mundo. Mais de 2 milhões de pessoas participam para comemorar.");
            }
            if (escolhaCidade == 2) {
                System.out.println("Porto Seguro é uma estância turística costeira no estado brasileiro da Bahia. \n" +
                        "A cidade é conhecida pela vibrante vida noturna, centrada no passeio repleto de bares, a Passarela do Álcool.\n" +
                        "O Índice de Desenvolvimento Humano (IDH) é de 0,676 e possui cerca de 152 529 de habitantes \n" +
                        "A balada em Porto Seguro não tem hora para acontecer!" );
            }

        }




    }
}