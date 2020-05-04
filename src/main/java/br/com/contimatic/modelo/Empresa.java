package br.com.contimatic.modelo;

public class Empresa {
	private String nome;
	private String razao;
	private String cnpj;



public Empresa (String nome, String razao, String cnpj) {
	this.nome = nome;
	this.razao = razao;
	this.cnpj = cnpj;
}



public String getNome() {
	return nome;
}



public String getRazao() {
	return razao;
}



public String getCnpj() {
	return cnpj;
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((nome == null) ? 0 : nome.hashCode());
	result = prime * result + ((razao == null) ? 0 : razao.hashCode());
	result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
	Empresa other = (Empresa) obj;
	if (nome != other.nome)
		return false;
	if (razao == null) {
		if (other.razao != null)
			return false;
	} else if (!cnpj.equals(other.cnpj))
		return false;
	return true;
}


@Override
public String toString() {
	return String.format("%-50s%-50s%-18s%",
											this.nome,
											this.razao,
											this.cnpj);
}




};