//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model;

public abstract class Pessoa {

	protected String nome;
	protected String cpf;
	
	public Pessoa (String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCpf() {
		return this.cpf;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public boolean validaCpf(String cpf) {
		if(cpf.length() == 11)
			return true;
		 else 
			return false;
	}
}
