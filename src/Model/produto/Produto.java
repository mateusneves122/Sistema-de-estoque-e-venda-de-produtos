package Model.produto;

public class Produto {

	private float price; 
	private String name; 
	private Integer code;
	
	public Produto(Float price, String name, Integer code) {
		this.price = price;
		this.name = name;
		this.code = code;
	}
	
	String getName () {
		return this.name;
	}
	
	float getPrice () {
		return this.price;
	}

	Integer getCode () {
		return this.code;
	}

	
	void setName (String name) {
		this.name = name;
	}
	
	void setPrice (float price) {
		this.price = price;
	}

}
