package br.com.contimatic.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class EnderecoTest {

	private static Endereco endereco;

	@BeforeClass
	public static void BeforeClass() {
		endereco = new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360");
	}
	
	@Order(1)
	@Test
	public void deve_alterar_logradouro_do_endereco() {
		endereco.setLogradouro("Rua Augusta");
		assertEquals(endereco.getLogradouro(), "Rua Augusta");
	}

	@Order(2)
	@Test
	public void deve_ter_endereco_com_numero_maior_que_zero() {
		assertFalse(endereco.getNumero() <= 0);
	}

	@Order(3)
	@Test
	public void nao_deve_ter_bairro_nulo_ou_vazio() {
		assertFalse(endereco.getBairro().trim().isEmpty()); 
	    assertFalse(endereco.getBairro() == null);
	}

	@Order(4)
	@Test
	public void deve_ter_cidade_em_sao_paulo() {
		MatcherAssert.assertThat(endereco.getCidade(), Matchers.containsString("Sao Paulo"));
	}

	@Order(5)
	@Ignore
	@Test
	public void deve_ter_cidade_Campinas() {
		MatcherAssert.assertThat(endereco.getCidade(), Matchers.containsString("Campinas"));
	}
	
	@Order(6)
	@Test
	public void deve_ter_cep_oito_digitos() {
		assertTrue(endereco.getCep().length() == 9);
	}

	@Order(11)
	@Test(timeout = 100)
	public void deve_adicionar_mil_enderecos_em_cem_milesimos() {
		Endereco endereconovo = new Endereco("Av Paulista", 2300, "Bela Vista", "Sao Paulo", "02000-000");
		Empresa empresa = new Empresa(2, "Gallo", "Gallo Java Dev", "00.111.222/0001-01", endereconovo);
		
		int i;
		for (i = 0; i < 1000; i++)
			empresa.setEndereco(endereconovo);
	}

}
