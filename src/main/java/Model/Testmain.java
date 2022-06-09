
//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model;

import java.util.Scanner;

import Model.product.Product;
import Model.employee.Employee;
import Model.*;

public class Testmain {
	public static void main(String[] args) {
		String name;
		String cpf;
		
		Scanner keyboard = new Scanner (System.in);
		
		System.out.println("CADASTRO DE FUNCIONARIO");
		System.out.println("Digite o nome: ");
		name = keyboard.next();
	
		System.out.println("Digite o cpf: ");
		cpf = keyboard.next();
		
		Employee funcionario = new Employee(name, cpf);
		
		double price;
		int amount;
		int option;
		int id;
		do { 
				 print_menu();
			     option = keyboard.nextInt();		     
			     switch (option) {
			     case 1:
			    	 	System.out.println("Nome do produto: ");
						name = keyboard.next();

						System.out.println("Preco do produto: ");
						price = keyboard.nextDouble();
						clearBuffer(keyboard);
						
						
						System.out.println("Quantidade do produto: ");
						amount = keyboard.nextInt();
						clearBuffer(keyboard);
						
						Product p = new Product(name, price, amount);
						
						funcionario.inventory.add_product(p);
				 break;
					
			     case 2:
			    	 	System.out.println("1) Editar quantidade");
			    	 	System.out.println("2) Editar preco");
			    	 	System.out.println("3) Sair");
			  
			    	 		int option2 = keyboard.nextInt();
			    	 		switch (option2) {
			    	 		case 1:
			    	 			System.out.println("Informe o ID: ");
			    	 			id = keyboard.nextInt();
			    	 			clearBuffer(keyboard);
			    	 			System.out.println("Informe a quantidade: ");
			    	 			amount = keyboard.nextInt();
			    	 			clearBuffer(keyboard);
			    	 			funcionario.inventory.edit_product_amount(id, amount);
			    	 		break;
			    	 		
			    	 		case 2:
			    	 			System.out.println("Informe o ID: ");
			    	 			id = keyboard.nextInt();
			    	 			clearBuffer(keyboard);
			    	 			System.out.println("Informe o preco: ");
			    	 			price = keyboard.nextInt();
			    	 			clearBuffer(keyboard);
			    	 			funcionario.inventory.edit_product_price(id, price);
			    	 		break; 
			    	 		}
			     break;
			     
			     case 3:
			    	 funcionario.inventory.inventory_print();
			    	 System.out.println("Informe o ID do produto");
			    	 id = keyboard.nextInt();
			    	 clearBuffer(keyboard);
			    	 funcionario.inventory.remove_product_id(id);
			     break;
			     
			     case 4:
			    	 System.out.println("Imprimir todos os produtos");
			    	 funcionario.inventory.inventory_print();
			     break;
			     }
			} while(option != 5);
}	
	
	private static void print_menu() {
		System.out.println("Escolha uma opção \n");
		System.out.println("1) Adicionar produto");
		System.out.println("2) Editar produto");
		System.out.println("3) Remover produto");
		System.out.println("4) Imprimir todos os produtos");
		System.out.println("5) Sair");
	}
	
	private static void clearBuffer(Scanner scanner) {
		if (scanner.hasNextLine()) {
				scanner.nextLine();
		}
	}
}
