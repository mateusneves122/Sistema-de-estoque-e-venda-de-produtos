/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CadastroProdutos;

import Model.product.Product;
import View.product.CadastroProduto;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
        String nome = this.tela.getNome().getText();
        try {
            double preco = toDouble(this.tela.getPreco().getText());
            int quantidade = toInt(this.tela.getQuantidade().getText());
            Product produto = new Product(nome, preco, quantidade);
            tela.getListaProdutos().addProduct(produto);
            
            
            DefaultTableModel model = (DefaultTableModel) this.tela.getTabela().getModel();
            model.addRow(new Object[]{produto.getId(), nome, preco, quantidade});
            
            this.tela.getTabela().setModel(model);
            
            tela.getNome().setText("");
            tela.getNome().setBackground(Color.white);
            
            tela.getPreco().setText("");
            tela.getPreco().setBackground(Color.white);
            
            tela.getQuantidade().setText("");
            tela.getQuantidade().setBackground(Color.white);
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
