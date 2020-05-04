package br.com.contimatic.teste;

import br.com.contimatic.modelo.Empresa;
import static org.junit.Assert.*;
import org.junit.Ignore;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
 // @formatter:on



import org.junit.Test;

public class EmpresaTeste {
	
  Empresa empresa = new Empresa("Gallo", "Gallo Import", "00.111.222/0001-01"); 	

  @Test
  public void TestaCnpj(){
  	assertThat(empresa.getCnpj(), empresa.getCnpj().length() == 18 );
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
