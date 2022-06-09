//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model;

import java.util.ArrayList;
import java.util.List;

import Model.product.*;



public class Inventory {
	List <Product> products_in_inventory = new ArrayList <Product>();
	
	public void addProduct (Product product) {
		products_in_inventory.add(product);
	}
	
	public void removeProductId (int id) {
		
		if(this.checkIfThereIsOnlyOneElementInTheList()) {
			this.removeFirstProduct();
		} else if(!this.products_in_inventory.isEmpty()){
                        Product p;
			for(int i=0; i<products_in_inventory.size(); i++) {
                            p = products_in_inventory.get(i);
                            System.out.println("ID: " + p.getId());
                            if(p.getId() == id) {
                                products_in_inventory.remove(p);
                                break;
                            }
			}
		}
	}
	
	private boolean checkIfThereIsOnlyOneElementInTheList () {
		if(products_in_inventory.size() == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private void removeFirstProduct () {
		this.products_in_inventory.remove(0);
	}

	public void editProductAmount (int id, int new_amount) {
		for(Product p: products_in_inventory) {
			if(p.getId() == id) {
				p.setAmount(new_amount);
			}
		}
	}

	public void editProductPrice (int id, double new_price) {
		for(Product p: products_in_inventory) {
			if(p.getId() == id) {
				p.setPrice(new_price);
			}
		}
	}
	
	public void inventoryPrint () {
		for(Product p: products_in_inventory) {
			System.out.println("Name: " + p.getName() + " ID: " + p.getId() +
			" Price: " + p.getPrice() + " Amount: " + p.getAmount());
		}
	}

	
}
