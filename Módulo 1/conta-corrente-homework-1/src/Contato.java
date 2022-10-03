public class Contato {
        String descricao;
        String telefone;
        int tipo;

        public void imprimirContato(){

                String tipoContato;

                if (tipo == 1) {
                        tipoContato = "Residencial";
                        System.out.println ("Descrição: "+descricao+"\nTelefone: "+telefone+" ( "+tipoContato+ " );" );
                }
                if (tipo == 2) {
                        tipoContato = "Comercial";
                        System.out.println ("Descrição: "+descricao+"\nTelefone: "+telefone+" ( "+tipoContato+ " );" );
                }
                else {
                        System.out.println("Os tipos permitidos é somente RESIDENCIAL(1) ou COMERCIAL(2).");
                }


                }
}

