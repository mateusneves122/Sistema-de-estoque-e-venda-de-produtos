//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model.product;

public class Product {
	
	private double price; 
	private String name; 
	private static int code = 0;
	private int amount;
	private int id;
        
        private String descricao;
        private String tipo;
	
	public Product (String name, double price, int amount) {
		this.price = price;
		this.name = name;
		this.code++;
		this.id = code;
		this.amount = amount;
	}
	
	public String getName () {
		return this.name;
	}
	
	public double getPrice () {
		return this.price;
	}

	public int getCode () {
		return this.code;
	}
	
	public int getId () {
		return this.id;
	}
	
	public int getAmount () {
		return this.amount;
	}
	
	public void setPrice (double price) {
		this.price = price;
	}
	
	public void setAmount (int value) {
		this.amount = value;
	}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

	
}
