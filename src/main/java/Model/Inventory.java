package Model;

import java.util.ArrayList;
import java.util.List;

import Model.product.*;



public class Inventory {
	List <Product> products_in_inventory = new ArrayList <Product>();
	
	public void add_product (Product product) {
		products_in_inventory.add(product);
	}
	
	public void remove_product_id (int id) {
		
		if(this.check_if_there_is_only_one_element_in_the_list()) {
			this.remove_first_product();
		} else {
			for(Product p: products_in_inventory) {
				System.out.println("ID: " + p.getId());
				if(p.getId() == id) {
					products_in_inventory.remove(p);
				}
			}
		}
	}
	
	private boolean check_if_there_is_only_one_element_in_the_list () {
		if(products_in_inventory.size() == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	
	private void remove_first_product () {
		this.products_in_inventory.remove(0);
	}

	public void edit_product_amount (int id, int new_amount) {
		for(Product p: products_in_inventory) {
			if(p.getId() == id) {
				p.setAmount(new_amount);
			}
		}
	}

	public void edit_product_price (int id, double new_price) {
		for(Product p: products_in_inventory) {
			if(p.getId() == id) {
				p.setPrice(new_price);
			}
		}
	}
	
	public void inventory_print () {
		for(Product p: products_in_inventory) {
			System.out.println("Name: " + p.getName() + " ID: " + p.getId() +
			" Price: " + p.getPrice() + " Amount: " + p.getAmount());
		}
	}

	public boolean check_empty_list() {
		if(products_in_inventory.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
