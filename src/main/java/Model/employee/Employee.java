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
