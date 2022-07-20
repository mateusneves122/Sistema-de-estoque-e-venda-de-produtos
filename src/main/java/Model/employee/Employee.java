//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model.employee;

import Model.Inventory;
import Model.People;

public class Employee extends People {

	public static Inventory inventory;
        private String password;
        private boolean admin;
	
	public Employee(String name, String cpf, String password) {
		super(name, cpf);
		this.inventory = new Inventory();
                this.password = password;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
}
