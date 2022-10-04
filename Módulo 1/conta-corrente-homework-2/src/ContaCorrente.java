public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;

    //Construtores
    public ContaCorrente() {

    }
    //Métodos:

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;

    }

    public double retornarValorComChequeEspecial() {

        return this.getSaldo() + chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public boolean sacar(double valorSaque) {
        double saldoAtual = getSaldo();
        if (valorSaque > (saldoAtual + chequeEspecial) && valorSaque > 0) {
            double valorAtual = (saldoAtual + chequeEspecial) - valorSaque;

        } else {
            System.out.println("Saldo insuficiente. Saque não permitido.");
        }
        return true;
    }

    @Override
    public void imprimir(){
        System.out.println("Conta Corrente:\n" +
                "Cliente: " + getCliente().getNome() +
                "\nNumeroConta:" + getNumeroConta() +
                "\nAgencia: " + getAgencia() +
                "\nSaldo: " + getSaldo() +
                "\nLimite Cheque Especial: " + this.chequeEspecial);
    }
}



