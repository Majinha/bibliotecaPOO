package Dados;

public class TestaEndereco {

    public static void main(String[] args) {
        Endereco e1 = new Endereco("Rua das Flores", 123, "Curitiba", "PR", "82123-987");
        System.out.println(e1);
        System.out.println(e1.getEtiquetaPostal());
        e1.setLogradouro("Rua das Flores Vermelhas");
        System.out.println(e1.getEtiquetaPostal());
        // visualizando retorno do toString => é chamado de modo transparente ao imprimir o objeto
        System.out.println(e1);
    }
}
