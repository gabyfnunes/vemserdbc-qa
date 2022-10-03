public class Main {
    public static void main(String[] args) {

        /*Cliente João - instanciando objeto */
        Contato contatosJoao = new Contato();
        contatosJoao.telefone = "27994387652";
        contatosJoao.tipo = 1;
        contatosJoao.descricao = "Contato principal com whatsapp.";

        Endereco enderecosJoao = new Endereco();
        enderecosJoao.logradouro = "Quadra 22 conjunto 12";
        enderecosJoao.numero = 2;
        enderecosJoao.complemento = "";
        enderecosJoao.cep = "72603-409";
        enderecosJoao.cidade = "Recanto das Emas";
        enderecosJoao.estado = "Distrito Federal";
        enderecosJoao.pais = "Brasil";

        Cliente clienteJoao = new Cliente();
        clienteJoao.nome = "João Barbosa";
        clienteJoao.cpf = "021.987.652-98";
        clienteJoao.contatos [0] = contatosJoao;
        clienteJoao.enderecos [0] = enderecosJoao;

        ContaCorrente contaCorrenteJoao = new ContaCorrente();
        contaCorrenteJoao.cliente = clienteJoao;
        contaCorrenteJoao.numeroConta = "46872-3";
        contaCorrenteJoao.agencia = 2712;
        contaCorrenteJoao.saldo = 1000.00;
        contaCorrenteJoao.chequeEspecial = 50.00;

        /*Cliente Maria - instanciando objeto */
        Contato contatosMaria  = new Contato();
        contatosMaria.telefone = "3136587413";
        contatosMaria.tipo = 2;
        contatosMaria.descricao = "Contato principal com whatsapp.";


        Endereco enderecosMaria = new Endereco();
        enderecosMaria.logradouro = "Quadra 22 conjunto 12";
        enderecosMaria.numero = 34;
        enderecosMaria.complemento = "";
        enderecosMaria.cep = "72941-409";
        enderecosMaria.cidade = "Ouro Preto";
        enderecosMaria.estado = "Minas Gerais";
        enderecosMaria.pais = "Brasil";

        Cliente clienteMaria = new Cliente();
        clienteMaria.nome = "Maria Santos";
        clienteMaria.cpf = "369.584.204-65";
        clienteMaria.contatos [0] = contatosMaria;
        clienteMaria.enderecos [0] = enderecosMaria;

        ContaCorrente contaCorrenteMaria = new ContaCorrente();
        contaCorrenteMaria.cliente = clienteMaria;
        contaCorrenteMaria.numeroConta = "41587-3";
        contaCorrenteMaria.agencia = 3214;
        contaCorrenteMaria.saldo = 500.00;
        contaCorrenteMaria.chequeEspecial = 0;

        /*testes  das operações: */
        System.out.println("Situação inicial da conta: ");
        contaCorrenteJoao.imprimirContaCorrente();
        contaCorrenteMaria.imprimirContaCorrente();

        contaCorrenteJoao.depositar(250.00);
        contaCorrenteJoao.imprimirContaCorrente();

        contaCorrenteMaria.sacar(20.00);
        contaCorrenteMaria.imprimirContaCorrente();

        contaCorrenteJoao.transferir(contaCorrenteMaria,200);
        contaCorrenteJoao.imprimirContaCorrente();

        System.out.println("\n\nApós todas as operações: ");
        contaCorrenteJoao.imprimirContaCorrente();
        contaCorrenteMaria.imprimirContaCorrente();


    }
}