//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model.employee;

import Model.Estoque;
import Model.Pessoa;

public class Funcionario extends Pessoa {

	public static Estoque estoque;
        private String senha;
        private boolean admin;
	
	public Funcionario(String nome, String cpf, String senha) {
		super(nome, cpf);
		estoque = new Estoque();
                this.senha = senha;
	}

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
