public class Cliente{
    public String nome;
    public String cpf;
    public Contato contatos[] = new Contato[2];
    public Contato contato = new Contato();
    public Endereco enderecos[] = new Endereco[2];
    public Endereco endereco = new Endereco();



   public void imprimirContato() {
       if (contato != null) {
           contato.imprimirContato();
       }
   }
   public void imprimirEndereco() {
           if (endereco != null) {
               endereco.imprimirEndereco();
           }
       }
    public void imprimirCliente(){
        System.out.println("Nome: "+nome+"\nCPF: "+cpf);
    }


}
