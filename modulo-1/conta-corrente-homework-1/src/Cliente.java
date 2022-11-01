public class Cliente{
    public String nome;
    public String cpf;
    public Contato contatos[] = new Contato[2];
    public Endereco enderecos[] = new Endereco[2];


    public void imprimirContato() {
        if (contatos != null) {
            for (int i =0; i < contatos.length; i++){
                if(contatos[i]!=null){
                    contatos[i].imprimirContato();
                }
            }
        }
    }
    public void imprimirEnderecos() {
        if (enderecos != null) {
            for (int i = 0; i <enderecos.length; i++){
                if (enderecos[i]!=null){
                    enderecos[i].imprimirEndereco();
            }
        }
    }
 }

    public void imprimirCliente(){
        System.out.println("Nome: "+nome+"\nCPF: "+cpf);
    }


}
