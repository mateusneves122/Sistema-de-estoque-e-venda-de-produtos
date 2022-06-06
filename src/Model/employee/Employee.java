package Model.employee;

import Model.*;

//commit

public class Employee extends People {

	private String registration_number;
	private double salary;
	
	public Employee(String name, String cpf) {
		super(name, cpf);
	}
}
