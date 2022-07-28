
//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model;

import java.util.Scanner;

import Model.product.Produto;
import Model.employee.Funcionario;
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
		
		Funcionario funcionario = new Funcionario(name, cpf, "123");
		
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
						
                            Produto p = new Produto(name, price, amount);
						
                            funcionario.estoque.addProduct(p);
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
                                    funcionario.estoque.editProductAmount(id, amount);
                                    break;
			    	 		
			    	case 2:
                                    System.out.println("Informe o ID: ");
                                    id = keyboard.nextInt();
                                    clearBuffer(keyboard);
                                    System.out.println("Informe o preco: ");
                                    price = keyboard.nextInt();
                                    clearBuffer(keyboard);
                                    funcionario.estoque.editProductPrice(id, price);
                                    break; 
			    }
			    break;
			     
			    case 3:
                                funcionario.estoque.inventoryPrint();
			    	System.out.println("Informe o ID do produto");
			    	id = keyboard.nextInt();
			    	clearBuffer(keyboard);
			    	funcionario.estoque.removeProductId(id);
                                break;
			     
			    case 4:
			    	System.out.println("Imprimir todos os produtos");
			    	funcionario.estoque.inventoryPrint();
                                break;
                    }
		} while(option != 5);
        }	
	
	private static void print_menu() {
		System.out.println("Escolha uma op��o \n");
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
