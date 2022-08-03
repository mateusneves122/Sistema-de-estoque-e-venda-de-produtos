//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model.product;

import java.util.Random;

public class Produto {

    private double preco;
    private String nome;
    private static int codigo = 0;
    private int quantidade;
    private int id;

    private String descricao;
    private String tipo;
    private String localizacaoNoEstoque;
    private String fornecedor;
    
    private double pesoVolume;
    private String unidadeMedida;

    public Produto(String nome, double preco, int quantidade) {
        Random numeroRegistro = new Random();
        this.preco = preco;
        this.nome = nome;
        this.codigo++;
        this.id = codigo + numeroRegistro.nextInt(1000);
        this.quantidade = quantidade;
        this.descricao = "";
    }

    public Produto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public int getId() {
        return this.id;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int value) {
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

    public String getLocalizacaoNoEstoque() {
        return localizacaoNoEstoque;
    }

    public void setLocalizacaoNoEstoque(String localizacaoNoEstoque) {
        this.localizacaoNoEstoque = localizacaoNoEstoque;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getPesoVolume() {
        return pesoVolume;
    }

    public void setPesoVolume(double pesoVolume) {
        this.pesoVolume = pesoVolume;
    }

    public String getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    
}
