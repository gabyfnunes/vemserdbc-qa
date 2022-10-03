public class Cliente{
    public String nome;
    public String cpf;
    public Contato contatos[] = new Contato[2];
    public Endereco enderecos[] = new Endereco[2];

    public void imprimirContato() {
        for( int i = 0; i<2; i++){
            System.out.println(contatos[i]);
        }
    }
    public void imprimirEnderco(){
        for (int i = 0;i<2;i++){
            System.out.println(enderecos[i]);
        }
    }
    public void imprimirCliente(){
        System.out.println("Nome: "+nome+"\nCPF: "+cpf);
    }


}
