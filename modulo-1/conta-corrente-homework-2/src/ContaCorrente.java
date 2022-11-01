public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;

    //Construtores
    public ContaCorrente() {

    }

    //Getters and Setter:

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    //Métodos:

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;

    }

    public double retornarValorComChequeEspecial() {

        return this.getSaldo() + chequeEspecial;
    }

    //Métodos:
    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public boolean sacar (double valorSaque){
        if (valorSaque>0){
            return false;
        }
        if((valorSaque >=retornarValorComChequeEspecial())){
            return true;
        }
        setSaldo(getSaldo()-valorSaque);
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



