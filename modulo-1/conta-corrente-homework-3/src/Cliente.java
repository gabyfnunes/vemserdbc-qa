import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private List<Contato> contatos = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(String nome, String cpf, Contato contatos, Endereco enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos.add(contatos);
        this.enderecos.add(enderecos);
    }

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

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContato(Contato contato) {
        this.contatos.add(contato);
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEndereco(Endereco endereco) {
        this.enderecos.add(endereco);
    }

    public void imprimirContatos(){

        if (contatos != null){
            for (Contato entidade : contatos){
                entidade.imprimirContato();
            }
        }else {
            System.out.println("Contato vazio.");
        }
    }

    public void imprimirEnderecos(){

        if(enderecos != null){
            for (Endereco entidade : enderecos){
                entidade.imprimirEndereco();
            }
        }else {
            System.out.println("Endereço vazio.");
        }
    }

    public void imprimirCliente(){
        System.out.println("Nome = "+nome+", cpf = "+cpf);
    }
}