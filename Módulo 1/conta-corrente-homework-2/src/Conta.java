abstract class Conta implements Movimentacao {

    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private Double saldo;

    public Conta(){

    }

    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo) {
        this.cliente=cliente;
        this.numeroConta=numeroConta;
        this.agencia=agencia;
        this.saldo=saldo;
    }

    //Getters and Setters:


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    //Métodos:
    @Override
    public boolean sacar(double valorSaque) {
        if (valorSaque > getSaldo()) {
            System.out.println("Saldo insuficiente.");
            return false;
        }
        if (valorSaque < 0) {
            System.out.println("Não é possivel sacar valores negativos.");
            return false;
        }

        setSaldo(getSaldo() - valorSaque);
        return true;
    }
    @Override
    public boolean depositar(double valorDeposito){
        if (valorDeposito <= 0){
            System.out.println("Não é possivel depositar valores negativos.");
            return false;
        }

        setSaldo(getSaldo() + valorDeposito);
        return true;
    }

    @Override
    public boolean transferir(Conta conta, double valor){
        if(this.sacar(valor)){
            conta.depositar(valor);
            return true;
        }else {
            return false;
        }
    }
}


