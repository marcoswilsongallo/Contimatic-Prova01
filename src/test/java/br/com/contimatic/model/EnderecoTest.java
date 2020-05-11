package br.com.contimatic.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.TimeZone;
 

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.After;
import org.junit.Ignore;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class EnderecoTest {

	private static Endereco endereco;
	private static Calendar tempo_inicio;
	

	@BeforeClass
	public static void before_class() {
		System.out.println("Inicio dos Testes");
		TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
		endereco = new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360");
	}
	@Before
	public  void before_test() {
		tempo_inicio = Calendar.getInstance();
	}
	
	@AfterClass
	public static void after_class() {
		System.out.println("Fim dos Testes");
	}
	
	@After
	public void after() {
		Calendar tempo_final = Calendar.getInstance();
		Calendar duracao = Calendar.getInstance();
		duracao.setTimeInMillis(tempo_final.getTimeInMillis() - tempo_inicio.getTimeInMillis());
        System.out.println("Tempo de teste: " + duracao.getTimeInMillis());		
	}	
	
	
	@Order(1)
	@Test
	public void deve_alterar_logradouro_do_endereco() {
		endereco.setLogradouro("Rua Augusta");
		assertEquals( "Rua Augusta", endereco.getLogradouro());
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
		
		assertTrue(empresa.getEndereco().equals(endereconovo));
	}

}
