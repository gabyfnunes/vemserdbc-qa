public class Contato {
       private String descricao;
       private String telefone;
       private int tipo;

       //Construtores:
        public Contato(){

        }
        public Contato(String descricao, String telefone, int tipo){
            this.descricao=descricao;
            this.telefone=telefone;
            this.tipo=tipo;
        }

       //Getters and Setters:
        public String getDescricao() {
                return descricao;
        }

        public void setDescricao(String descricao) {
                this.descricao = descricao;
        }

        public String getTelefone() {
                return telefone;
        }

        public void setTelefone(String telefone) {
                this.telefone = telefone;
        }

        public int getTipo() {
                return tipo;
        }

        public void setTipo(int tipo) {
                this.tipo = tipo;
        }

        //Métodos:
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

