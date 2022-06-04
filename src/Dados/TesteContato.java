package Dados;

import java.time.LocalDate;

public class TesteContato {
	public static void main(String[] args) {
		Contato c1 = new Contato("fulano de tal");
		Contato c2 = new Contato("fulano de tal", 10, 12, 1990);
		Contato c3 = new Contato("Tal", LocalDate.of(1995, 2, 25));
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		Endereco e1 = new Endereco("Rua das Flores", 123, "Curitiba", "PR", "82123-987");
		c2.setEnderecoResidencial(e1);
		System.out.println(c2.getEnderecoResidencial());
		System.out.println(c2.getEnderecoResidencial().getEtiquetaPostal());
		System.out.println(c2.getNome() + " mora em " + c2.getEnderecoResidencial().getCidade());
	}
}
