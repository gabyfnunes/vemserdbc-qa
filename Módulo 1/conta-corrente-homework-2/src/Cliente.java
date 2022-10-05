public class Cliente{
    private String nome;
    private String cpf;
    private Contato contatos[] = new Contato[2];
    private Contato contato = new Contato();
    private Endereco enderecos[] = new Endereco[2];

    private Endereco endereco = new Endereco();

    //Construtores:
    public Cliente(){

    }
    public Cliente(String nome, String cpf, Contato contatos, Endereco enderecos){
        this.nome=nome;
        this.cpf=cpf;
        this.contatos [0]=contatos;
        this.enderecos[0]=enderecos;

    }


    //Getters and Setters:
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    //Métodos:
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
