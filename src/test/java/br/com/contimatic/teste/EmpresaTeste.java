package br.com.contimatic.teste;

import br.com.contimatic.modelo.Empresa;
import br.com.contimatic.modelo.Endereco;


import org.junit.Ignore;
import static org.hamcrest.MatcherAssert.assertThat;
 // @formatter:on
import org.junit.Test;

public class EmpresaTeste {
	
  Endereco endereco = new Endereco("Rua Ana Gomes", 20, "Itaquera", "Sao Paulo", "08215-360");	
  Empresa empresa  = new Empresa(1,"Gallo", "Gallo Import", "00.111.22s2/0001-01", endereco);
  
  @Test
  public void TestaCodigo(){
	  assert(empresa.getCodigo() > 2  );
  }
  
  
  @Test
  public void TestaCnpjFormat(){
  	assertThat(empresa.getCnpj(), empresa.getCnpj().matches("[0-9]{2}\\.?[0-9]{3}\\.?[0-9]{3}\\/?[0-9]{4}\\-?[0-9]{2}"));
  };
  
  
  
  @Test
  public void TestaCnpj(){
  	assert( empresa.getCnpj().length() == 18);
  };
  
  @Test(timeout = 200)
  public void TestaTimeOutLoop() throws InterruptedException {
	Thread t = new Thread();  
 
	while (true) {
	 t.currentThread().sleep(1000);;
    }
  }
  
  @Ignore
  @Test
  public void TestaNome() {
	  assert(empresa.getNome() != "Gallo" ):
		  "O nome da empresa esperada é Gallo";
  }
  
  
 
}
