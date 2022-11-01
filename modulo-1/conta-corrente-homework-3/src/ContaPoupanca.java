public class ContaPoupanca extends Conta implements Impressao {
    static final double JUROS_MENSAIS = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    //Métodos:

    public void creditarTaxa(){
            setSaldo(getSaldo()*JUROS_MENSAIS);
    }

    @Override
    public void imprimir(){
        System.out.println("Conta Poupança:\n" +
                "Cliente: " + getCliente().getNome() +
                "\nNumeroConta:" + getNumeroConta() +
                "\nAgencia: " + getAgencia() +
                "\nSaldo: " + getSaldo());
    }

}
