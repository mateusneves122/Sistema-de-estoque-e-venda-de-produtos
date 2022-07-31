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
        private float pagamentoFixo;
        private String rg;
        private int telefone;
        private String registro;
        private String sexo;
        private String cargo;
	
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

    public float getPagamentoFixo() {
        return pagamentoFixo;
    }

    public void setPagamentoFixo(float pagamentoFixo) {
        this.pagamentoFixo = pagamentoFixo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
}
