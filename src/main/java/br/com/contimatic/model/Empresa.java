package br.com.contimatic.model;

public class Empresa {
	private int codigo;
	private String nome;
	private String razao;
	private String cnpj;
	private Endereco endereco;

	public Empresa(int codigo, String nome, String razao, String cnpj, Endereco endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.razao = razao;
		this.cnpj = cnpj;
		this.endereco = endereco;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRazao(String razao) {
		this.razao = razao;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
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
		result = prime * result + codigo;
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
		return String.format("%-8d%-50s%-50s%-18s%", this.codigo, this.nome, this.razao, this.cnpj);
	}

};