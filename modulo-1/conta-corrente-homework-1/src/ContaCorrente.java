public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

    public void imprimirContaCorrente(){
        System.out.println("\n\n\nNome: "+cliente.nome+"\nConta Corrente: "+numeroConta+
                "\nAgência: "+agencia+"\nSaldo Disponível: "+ saldo+"\nLimite Cheque Especial: "+chequeEspecial);
    }
    public boolean sacar (double valorSaque){
        if (valorSaque<(saldo+chequeEspecial) && valorSaque>0){
            double valorAtual = (saldo+chequeEspecial)-valorSaque;
            saldo = valorAtual;
        }
        else{
            System.out.println("Saldo insuficiente. Saque não permitido.");
        }
        return true;
    }
    public boolean depositar(double valorDeposito){
        if (valorDeposito>0){
            double valorAtual = saldo+valorDeposito;
            saldo = valorAtual;
        }
        else{
            System.out.println("Valor para depósito deve ser maior que R$0,00.");
        }
        return true;
    }
    public double retornarValorComChequeEspecial(){

        return saldo+chequeEspecial;
    }
    public boolean transferir(ContaCorrente contaReceptora, double valorTransferir){
        if (valorTransferir < 0 && valorTransferir<saldo+chequeEspecial){
            System.out.println("Não é possivel transferir valores negativos.");
            return false;
        }
        this.saldo -= valorTransferir;
        contaReceptora.saldo += valorTransferir;
        return true;

    }




}
