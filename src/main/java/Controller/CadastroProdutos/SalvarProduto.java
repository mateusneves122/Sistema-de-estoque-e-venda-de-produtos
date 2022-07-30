/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CadastroProdutos;

import Model.product.Produto;
import View.product.CadastroProduto;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yanfo
 */
public class SalvarProduto implements ActionListener {
    private CadastroProduto tela = new CadastroProduto();

    public SalvarProduto(CadastroProduto tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = this.tela.getNomeProduto().getText();
        try {
            double preco = toDouble(this.tela.getPreco().getText());
            int quantidade = toInt(this.tela.getQuantidade().getText());
            Produto produto = new Produto(nome, preco, quantidade);
            
            
            String descricao = tela.getDescricao().getText();
            String tipo = tela.getTipoProduto().getSelectedItem().toString();
            String localizacao = tela.getLocalizacao().getText();
            String fornecedor = tela.getFornecedor().getText();
            double pesoVolume = Double.parseDouble(tela.getPesoVolume().getText());
            String unidadeMedida = tela.getUnidadeMedida().getSelectedItem().toString();
            
            produto.setDescricao(descricao);
            produto.setTipo(tipo);
            produto.setLocalizacaoNoEstoque(localizacao);
            produto.setFornecedor(fornecedor);
            produto.setPesoVolume(pesoVolume);
            produto.setUnidadeMedida(unidadeMedida);
            
            tela.getListaProdutos().addProduct(produto);
            DefaultTableModel model = (DefaultTableModel) this.tela.getTabelaProdutos().getModel();
            model.addRow(new Object[]{produto.getId(), nome, preco, quantidade});
            
            this.tela.getTabelaProdutos().setModel(model);
            
            tela.getNomeProduto().setText("");
            tela.getNomeProduto().setBackground(Color.white);
            
            tela.getPreco().setText("");
            tela.getPreco().setBackground(Color.white);
            
            tela.getQuantidade().setText("");
            tela.getQuantidade().setBackground(Color.white);
            
            tela.getTipoProduto().setSelectedIndex(0);
            tela.getPesoVolume().setText("");
            tela.getUnidadeMedida().setSelectedIndex(0);
            tela.getFornecedor().setText("");
            tela.getLocalizacao().setText("");
            tela.getDescricao().setText("");
            
            this.tela.repaint();
        }
        catch (NumberFormatException err) {
            tela.getPreco().setBackground(new Color(254,57,57));
            tela.getQuantidade().setBackground(new Color(254,57,57));
        }
    }
    
    private Double toDouble(String preco) throws NumberFormatException {
        Double number1 = Double.parseDouble(preco);
        return number1;
    }
    
    private int toInt(String qtd) throws NumberFormatException {
        int number2 = Integer.parseInt(qtd);
        return number2;
    }
}
