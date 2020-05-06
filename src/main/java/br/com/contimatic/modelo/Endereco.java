package br.com.contimatic.modelo;

public class Endereco {
  private String logradouro;
  private int numero;
  private String bairro;
  private String cidade;
  private String cep;
  
  
  public Endereco(String logradouro, int numero, String bairro, String cidade, String cep) {
	  
	  this.logradouro = logradouro;
	  this.numero = numero;
	  this.bairro = bairro;
	  this.cidade = cidade;
	  this.cep = cep;
	  
	  
	  
	  
  }


public String getLogradouro() {
	return logradouro;
}


public int getNumero() {
	return numero;
}


public String getBairro() {
	return bairro;
}


public String getCidade() {
	return cidade;
}


public String getCep() {
	return cep;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
	result = prime * result + ((cep == null) ? 0 : cep.hashCode());
	result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
	result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
	result = prime * result + numero;
	return result;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Endereco other = (Endereco) obj;
	if (bairro == null) {
		if (other.bairro != null)
			return false;
	} else if (!bairro.equals(other.bairro))
		return false;
	if (cep == null) {
		if (other.cep != null)
			return false;
	} else if (!cep.equals(other.cep))
		return false;
	if (cidade == null) {
		if (other.cidade != null)
			return false;
	} else if (!cidade.equals(other.cidade))
		return false;
	if (logradouro == null) {
		if (other.logradouro != null)
			return false;
	} else if (!logradouro.equals(other.logradouro))
		return false;
	if (numero != other.numero)
		return false;
	return true;
}


@Override
public String toString() {
	return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade
			+ ", cep=" + cep + "]";
}



}
