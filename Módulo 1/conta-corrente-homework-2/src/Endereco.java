public class Endereco {
    private int tipo;
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    //Construtores:
    public Endereco(){

    }
    public Endereco(int tipo, String logradouro, int numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }


    //Getters and Setters:
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }


    //Métodos:
    public void imprimirEndereco() {
        String tipoEndereco;
        if(getTipo()!=0) {
            if (tipo == 1) {
                tipoEndereco = "Residencial";
                System.out.println("Logradouro: " + logradouro + "  " + numero + " " + complemento + " - " + cep + " - "
                        + cidade + ", " + estado + ", " + pais + " ( " + tipoEndereco + " ).");

            }
            if (tipo == 2) {
                tipoEndereco = "Comercial";
                System.out.println("Logradouro: " + logradouro + "  " + numero + " " + complemento + " - " + cep + " - "
                        + cidade + ", " + estado + ", " + pais + " ( " + tipoEndereco + " ).");
            } else {
                System.out.println("Os tipos permitidos é somente RESIDENCIAL(1) ou COMERCIAL(2).");
            }
        }
    }
}
