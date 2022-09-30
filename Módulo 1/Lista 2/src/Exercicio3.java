import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome;
        String maiorPeso = "";
        String maiorIdade = "";
        double altura;
        double peso;
        double auxAltura = 0;
        double maiorAltura = 0;
        double mediaAltura = 0;
        double auxPeso = 0;
        int contagemJogadores = 0;
        int idade;
        int auxIdade = 0;

        do {
            System.out.println("Preencha os dados a baixo:  (Para sair digite: SAIR)");
            System.out.println("Nome: ");
            nome = scanner.nextLine();
            if (nome.equals("SAIR")){
                break;
            }
            System.out.println("Altura: ");
            altura = scanner.nextDouble();
            System.out.println("Idade: ");
            idade = scanner.nextInt();
            System.out.println("Peso: ");
            peso = scanner.nextDouble();

            if (altura > maiorAltura){
                maiorAltura = altura;
            }
            if(idade > auxIdade){
                auxIdade = idade;
                maiorIdade = nome;
            }
            if (peso > auxPeso){
                auxPeso = peso;
                maiorPeso = nome;
            }

            auxAltura += altura;
            contagemJogadores++;
            scanner.nextLine();
        }while (!nome.equals("SAIR"));

        if (contagemJogadores != 0){
            mediaAltura = auxAltura / contagemJogadores;
        }

        System.out.println("Quantidade de jogadores cadastrados: "+contagemJogadores);
        System.out.println("Altura do maior jogador: "+maiorAltura);
        System.out.println("Jogador mais velho: "+maiorIdade);
        System.out.println("Jogador mais pesado: "+maiorPeso);
        System.out.printf("Média das alturas dos jogadores: %.2f",mediaAltura);

        scanner.close();
    }
}