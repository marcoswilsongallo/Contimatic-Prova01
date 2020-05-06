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
	public void carrega_classe_empresa() {
		endereco = new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360");
		empresa =  new Empresa(1, "Gallo", "Gallo Import", "00.111.222/0001-01", endereco);
	}
	
    @Order(1)
	@Test
	public void deve_ter_codigo_positivo() {
	    assertTrue(empresa.getCodigo() > 0);	
	}
    
    @Order(2)	
	@Test
	public void deve_ter_nome_inciado_maiuscula() {
		assertTrue(empresa.getNome().substring(0,1) ==  empresa.getNome().toUpperCase().substring(0,1));
	}
    
    @Order(3)
	@Test
	public void deve_ter_razao_nao_nulo_e_nao_vazio() {
		assertFalse(empresa.getRazao().isEmpty());
		assertFalse(empresa.getRazao() == null );
	}
    
    @Order(4)
	@Test
	public void deve_ter_cnpj_com_dezoito_digitos() {
		assertTrue(empresa.getCnpj().length() == 18);
	}
    
    @Order(5)
	@Test
	public void deve_ter_cnpj_formatado() {
	  assertTrue(empresa.getCnpj().matches("([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})"));	
	}
	
    @Order(6)
	@Test
	public void deve_alterar_endereco_da_empresa() {
		Endereco endereconovo = new Endereco("Av Paulista", 2300, "Bela Vista", "Sao Paulo", "02000-000");
		empresa.setEndereco(endereconovo);
		assertEquals(empresa.getEndereco(), endereconovo);
	}
    
    @Order(7)
	@Test
	public void deve_ter_endereco_com_numero_maior_que_zero() {
		assertFalse(empresa.getEndereco().getNumero() <= 0);
	}
    
    @Order(8)
	@Test
    public void nao_deve_ter_bairro_nulo_ou_vazio() {
    	assertFalse(empresa.getEndereco().getBairro().isEmpty());
    	assertFalse(empresa.getEndereco().getBairro() == null);
    }
    
    @Order(9)
	@Test
	public void deve_ter_cidade_em_sao_paulo() {
		MatcherAssert.assertThat(empresa.getEndereco().getCidade(),Matchers.containsString("Sao Paulo"));
	}
    
    @Order(10)
    @Test
    public void deve_ter_cep_oito_digitos() {
    	assertTrue(empresa.getEndereco().getCep().length() == 8);
    }
    
    
}
