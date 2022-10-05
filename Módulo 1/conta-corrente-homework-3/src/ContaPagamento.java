public class ContaPagamento extends Conta implements Impressao {
    static final Double TAXA_SAQUE = 4.25;

    //Construtores:
    public ContaPagamento() {
    }

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }


    //Métodos
    @Override
    public boolean sacar(double valorSaque){
        if(valorSaque+TAXA_SAQUE > getSaldo()){
            System.out.println("\nSaldo insuficiente.");
            return false;
        }
        if (valorSaque <= 0){
            System.out.println("\nVocê não pode sacar valores negativos ou 0.");
            return false;
        }

        setSaldo(getSaldo() - (valorSaque+TAXA_SAQUE));
        return true;
    }

    @Override
    public boolean transferir(Conta conta, double valor){
        if(super.sacar(valor)){
            conta.depositar(valor);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Conta Pagamento:\n" +
                "\nCliente: " + getCliente().getNome() +
                " \nNúmero da Conta:" + getNumeroConta() +
                "\nAgência: " + getAgencia() +
                "\nSaldo: " + getSaldo());
    }

}
