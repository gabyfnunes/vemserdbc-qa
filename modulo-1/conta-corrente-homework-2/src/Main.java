public class Main {
    public static void main(String[] args) {
        //Cliente João
        Contato contatosJoao = new Contato("27994387652","27994387652",1);
        Endereco enderecosJoao = new Endereco(1,"Quadra 254 conj 14",12,"","72603-409","Recanto das Emas","DF", "Brasil");
        Cliente clienteJoao = new Cliente("João Barbosa", "021.987.652-98",contatosJoao, enderecosJoao);
        ContaCorrente contaCorrenteJoao = new ContaCorrente(clienteJoao, "46872-3", "2712", 1000.00,50.00);

        //Cliente Maria
        Contato contatosMaria = new Contato("Trabalho Maria","6134987756",2);
        Endereco enderecosMaria = new Endereco(1,"Quadra 457 conj 1",3,"","72403-609","Ceilândia","DF", "Brasil");
        Cliente clienteMaria = new Cliente("Maria José", "352.987.412-69",contatosMaria, enderecosMaria);
        ContaPoupanca contaPoupancaMaria = new ContaPoupanca(clienteMaria, "48759-3", "3244", 1500.00);

        //Impressão inicial das Contas:
        System.out.println("\nSituação Inicial Conta Maria\n");
        contaPoupancaMaria.imprimir();
        System.out.println("\nSituação Inicial Conta João\n");
        contaCorrenteJoao.imprimir();


        //Transferência João para Maria:
        boolean transferenciaJoao;
        transferenciaJoao = contaCorrenteJoao.transferir(contaPoupancaMaria,0.00);
        System.out.println("\nJoão transferiu R$10,00 para Maria. As contas ficaram assim:\n ");
        contaCorrenteJoao.imprimir();
        System.out.println("\n");
        contaPoupancaMaria.imprimir();

        //Saque João:
        boolean saqueJoao;
        saqueJoao = contaCorrenteJoao.sacar(350.50);
        System.out.println("\nJoão precisou sacar R$350,50. Sua conta após o saque: ");
        contaCorrenteJoao.imprimir();

        //Maria: Depósito e Taxa:
        boolean depositoMaria;
        depositoMaria=contaPoupancaMaria.depositar(50.00);
        contaPoupancaMaria.creditarTaxa();
        System.out.println("\nMaria depositou R$50,00 e verificou que houve um crédito referente a uma taxa:");
        contaPoupancaMaria.imprimir();


    }
}