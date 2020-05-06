package br.com.contimatic.teste;
import br.com.contimatic.modelo.Endereco;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Before;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

public class EnderecoTeste {
	
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
	
	
	@Test
	public void TestaLogradouro() {
		MatcherAssert.assertThat(enderecos, Matchers.<Endereco>hasProperty("logradouri", Matchers.isEmptyString() ) );
	}
	
	
	@Test
	public void TestaNumero() {
		MatcherAssert.assertThat(enderecos,Matchers.hasProperty("numero", Matchers.greaterThan(0) ) );
	}
	
	@Test
	public void TestaCep() {
		MatcherAssert.assertThat(enderecos,  Matchers.hasProperty("cep", Matchers.isEmptyOrNullString() ) ) ;
	}
	
	@Test
	public void TestaBairro() {
		MatcherAssert.assertThat(enderecos, Matchers.hasProperty("bairro", Matchers.isEmptyOrNullString()));
	}
	
	@Test
	public void TestaCidade() {
		MatcherAssert.assertThat(enderecos, Matchers.hasProperty("cidade", Matchers.isEmptyOrNullString()));
	}

}
