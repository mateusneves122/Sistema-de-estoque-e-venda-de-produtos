package Model.employee;

import Model.People;

public class Employee extends People {
	
	private double salary;
	
	public Employee(String name, String cpf) {
		super(name, cpf);
	}

	void setSalary (double salary) {
		this.salary = salary;
	}

	double getSalary (double salary) {
		return this.salary;
	}
}
