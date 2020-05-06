package br.com.contimatic.test;

import br.com.contimatic.model.Endereco;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.BeforeClass;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class EnderecoTest {

	private static Endereco enderecos;

	@BeforeClass
	public static void BeforeClass() {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		enderecos.add(new Endereco("Rua Ana Gomes", 0, "Itaquera", "Sao Paulo", ""));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 200, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 2000, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 200000, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "082150"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "0821512-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao jao", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaqua", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360"));
		enderecos.add(new Endereco("", 20, "Itaquera", "Sao Paulo", "08215-360"));
	}
    @Order(1)
	@Test
	public void nao_deve_logradouro_ser_vazio() {
		MatcherAssert.assertThat(enderecos, Matchers.<Endereco>hasProperty("logradouri", Matchers.isEmptyString()));
	}

    @Order(2)
	@Test
	public void nao_deve_nmero_ser_negativo() {
		MatcherAssert.assertThat(enderecos, Matchers.hasProperty("numero", Matchers.greaterThan(0)));
	}
    @Order(3)
	@Test
	public void nao_deve_cep_ser_vazio_ou_nulo() {
		MatcherAssert.assertThat(enderecos, Matchers.hasProperty("cep", Matchers.isEmptyOrNullString()));
	}
    @Order(4)
	@Test
	public void nao_deve_bairro_ser_vazio_ou_nulo() {
		MatcherAssert.assertThat(enderecos, Matchers.hasProperty("bairro", Matchers.isEmptyOrNullString()));
	}
    @Order(5) 
	@Test
	public void nao_deve_cidade_ser_vazio_ou_nulo() {
		MatcherAssert.assertThat(enderecos, Matchers.hasProperty("cidade", Matchers.isEmptyOrNullString()));
	}

}
