//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model.product;

public class Produto {
	
	private double preco; 
	private String name; 
	private static int codigo = 0;
	private int quantidade;
	private int id;
        
        private String descricao;
        private String tipo;
	
	public Produto (String nome, double preco, int quantidade) {
		this.preco = preco;
		this.name = nome;
		this.codigo++;
		this.id = codigo;
		this.quantidade = quantidade;
	}
	
	public String getName () {
		return this.name;
	}
	
	public double getPreco () {
		return this.preco;
	}

	public int getCodigo () {
		return this.codigo;
	}
	
	public int getId () {
		return this.id;
	}
	
	public int getQuantidade () {
		return this.quantidade;
	}
	
	public void setPreco (double preco) {
		this.preco = preco;
	}
	
	public void setQuantidade (int value) {
		this.quantidade = value;
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
