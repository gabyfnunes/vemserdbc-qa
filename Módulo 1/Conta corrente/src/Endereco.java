public class Endereco {
    public int tipo;
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

        public void imprimirEndereco() {
            String tipoEndereco;
            if (tipo == 1) {
                tipoEndereco = "Residencial";
                System.out.println ("Logradouro: "+logradouro+"  "+numero+" "+complemento+" - "+cep+" - "
                +cidade+", "+estado+", "+pais+" ( "+tipoEndereco+" ).");

            }
            if (tipo == 2) {
                tipoEndereco = "Comercial";
                System.out.println ("Logradouro: "+logradouro+"  "+numero+" "+complemento+" - "+cep+" - "
                        +cidade+", "+estado+", "+pais+" ( "+tipoEndereco+" ).");
            } else {
                System.out.println("Os tipos permitidos é somente RESIDENCIAL(1) ou COMERCIAL(2).");
            }

        }
}
