//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model;

public abstract class People {

	protected String name;
	protected String cpf;
	
	public People (String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
	}

	public String getName() {
		return this.name;
	}

	public String getCpf() {
		return this.cpf;
	}
	
	protected void setName(String name) {
		this.name = name;
	}

	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}

	protected boolean check_cpf_size(String cpf) {
		if(cpf.length() == 11)
			return true;
		 else 
			return false;
	}
}
