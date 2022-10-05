public class Cliente{
    public String nome;
    public String cpf;
    public Contato contatos[] = new Contato[2];
    public Endereco enderecos[] = new Endereco[2];


    public void imprimirContatos(){
        int aux = 0;
        for(int i = 0; i < contatos.length; i++){
            if (contatos[i] != null){
                contatos[i].imprimirContato();
                aux++;
            }
        }
        if(aux==0){
            System.out.println("O CONTATO NÃO PODE SER VAZIO!");
        }
    }

   public void imprimirEndereco() {
       int aux = 0;
       for(int i = 0; i < enderecos.length; i++){
           if (enderecos[i] != null){
               enderecos[i].imprimirEndereco();
               aux++;
           }
       }
       if(aux==0){
           System.out.println("O ENDEREÇO NÃO PODE SER VAZIO!");
       }
    }

    public void imprimirCliente(){
        System.out.println("Nome: "+nome+"\nCPF: "+cpf);
    }


}
