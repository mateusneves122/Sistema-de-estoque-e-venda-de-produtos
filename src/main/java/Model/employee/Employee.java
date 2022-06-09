//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model.employee;

import Model.Inventory;
import Model.People;

public class Employee extends People {

	public static Inventory inventory;
	
	public Employee(String name, String cpf) {
		super(name, cpf);
		this.inventory = new Inventory();
	}
}
