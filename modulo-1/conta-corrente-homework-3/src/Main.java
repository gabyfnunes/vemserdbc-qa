public class Main {
    public static void main(String[] args) {

        Contato joaoContato = new Contato("Contato principal.", "61997529277", 1);
        Endereco joaoEndereco = new Endereco(1, "Quadra 116 conj 6", 2,null, "72650-603", "Recanto das Emas", "DF", "Brasil");
        Cliente clienteJoao = new Cliente("João Barbosa", "258.364.148-25", joaoContato, joaoEndereco);
        ContaCorrente joaoContaCorrente = new ContaCorrente(clienteJoao, "48547-5", "3685", 1000, 250);

        ContaPagamento joaoContaPagamento = new ContaPagamento(clienteJoao, "48547-5", "3685", 1000.0);

        Contato mariaContato = new Contato("Trabalho da Maria", "6132579858", 2);
        Endereco mariaEndereco = new Endereco(2, "Comercial Sul QNH 42", 26,null, "75236-502", "Taguatinga", "DF", "Brasil");
        Cliente clienteMaria = new Cliente("Maria José", "120.658.994-27", mariaContato, mariaEndereco);
        ContaPoupanca mariaContaPoupanca = new ContaPoupanca(clienteMaria, "98653-5", "2147", 3000.0);

        //Transferência:
        System.out.println("\nSituação Inicial das contas: \n");
        mariaContaPoupanca.imprimir();
        joaoContaCorrente.imprimir();
        System.out.println("\nJoão transfere R$50.00 para Maria: \n");
        boolean transferenciaJoao;
        transferenciaJoao = mariaContaPoupanca.transferir(joaoContaCorrente, 50.0);
        System.out.println("\n\nApós a transferência, esses são os saldos atuais das contas: ");
        mariaContaPoupanca.imprimir();
        joaoContaCorrente.imprimir();

        //Deposito:
        System.out.println("\nMaria realizou um depósito de R$ 25,00.\n");
        boolean depositoMaria;
        mariaContaPoupanca.imprimir();
        depositoMaria = mariaContaPoupanca.depositar(25.00);
        System.out.println("\n\nApós o depósito, essa é a situação da conta: ");
        mariaContaPoupanca.imprimir();

        //Saque:
        System.out.println("\nJoao sacou R$200,00\n");
        boolean saqueJoao;
        joaoContaPagamento.imprimir();
        saqueJoao = joaoContaPagamento.sacar(199.0);
        System.out.println("\n--->Saque realizado na conta pagamento de"+clienteJoao.getNome()+" = " + saqueJoao);
        joaoContaPagamento.imprimir();

        //Teste saque negativo:
        System.out.println("\nTeste Saque Negativo: \n");
        mariaContaPoupanca.imprimir();
        mariaContaPoupanca.sacar(-50);
        mariaContaPoupanca.imprimir();

        //Imprimir Contas
        System.out.println("\n\nSituação final das contas: ");
        mariaContaPoupanca.imprimir();
        joaoContaCorrente.imprimir();
        joaoContaPagamento.imprimir();

    }
}
