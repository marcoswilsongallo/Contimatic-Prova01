package br.com.contimatic.test;

import br.com.contimatic.model.Empresa;
import br.com.contimatic.model.Endereco;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.BeforeClass;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class EmpresaTest {

	public static Empresa empresa;
	public static Endereco endereco;

	@BeforeClass
	public static void carregaClasseEmpresa() {
		endereco = new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360");
		empresa = new Empresa(1, "Gallo", "Gallo Import", "00.111.222/0001-01", endereco);
	}

	@Order(1)
	@Test
	public void deveTerCodigoPositivo() {
		assertTrue(empresa.getCodigo() > 0);
	}

	@Order(2)
	@Test
	public void deveTerNomeInciadoMaiuscula() {
		assertTrue(empresa.getNome().substring(0, 1) == empresa.getNome().toUpperCase().substring(0, 1));
	}

	@Order(12)
	@Test
	public void devTerNomeTamanhoMaximoCinquenta() {
		assertTrue(empresa.getNome().length() <= 50);
	}

	@Order(13)
	@Test
	public void deveTerRazaoTamanhoMaximoCinquenta() {
		assertTrue(empresa.getRazao().length() <= 50);
	}

	@Order(14)
	@Test
	public void naoDeveTerEspacoAntesDoNome() {
		assertFalse(empresa.getNome().trim() != empresa.getNome());
	}

	@Order(15)
	@Test
	public void naoDeveTerEspacoAntesDaRazao() {
		assertFalse(empresa.getRazao().trim() != empresa.getRazao());
	}

	@Order(3)
	@Test
	public void deveTerRazaoNaoNuloNaoVazio() {
		assertFalse(empresa.getRazao().trim().isEmpty() || empresa.getRazao() == null);
	}

	@Order(4)
	@Test
	public void deveTerCnpjComDezoitoDigitos() {
		assertTrue(empresa.getCnpj().length() == 18);
	}

	@Order(5)
	@Test
	public void deveTerCnpjFormatado() {
		assertTrue(empresa.getCnpj().matches("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})"));
	}

	@Order(6)
	@Test
	public void deveAlterarEnderecoDaEmpresa() {
		Endereco endereconovo = new Endereco("Av Paulista", 2300, "Bela Vista", "Sao Paulo", "02000-000");
		empresa.setEndereco(endereconovo);
		assertEquals(empresa.getEndereco(), endereconovo);
	}

	@Order(7)
	@Test
	public void deveTerEnderecoComNumeroMaiorQueZero() {
		assertFalse(empresa.getEndereco().getNumero() <= 0);
	}

	@Order(8)
	@Test
	public void naoDeveTerBairroNuloOuVazio() {
		assertFalse(empresa.getEndereco().getBairro().trim().isEmpty() || empresa.getEndereco().getBairro() == null);
	}

	@Order(9)
	@Test
	public void deveTerCidadeEmSaoPaulo() {
		MatcherAssert.assertThat(empresa.getEndereco().getCidade(), Matchers.containsString("Sao Paulo"));
	}

	@Order(10)
	@Test
	public void deveTerCepOitoDigitos() {
		assertTrue(empresa.getEndereco().getCep().length() == 8);
	}

	@Order(11)
	@Test(timeout = 100)
	public void deveAdicionarMilEndercosEmCemMilesimos() {
		Endereco endereconovo = new Endereco("Av Paulista", 2300, "Bela Vista", "Sao Paulo", "02000-000");
		int i;
		for (i = 0; i < 1000; i++)
			empresa.setEndereco(endereconovo);
	}

}
