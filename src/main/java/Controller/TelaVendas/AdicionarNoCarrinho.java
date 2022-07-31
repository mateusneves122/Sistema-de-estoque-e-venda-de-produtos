/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.TelaVendas;

import View.TelaVendas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PICHAU
 */
public class AdicionarNoCarrinho implements ActionListener{
    private TelaVendas tela;// = new TelaVendas();

    public AdicionarNoCarrinho(TelaVendas tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = this.tela.getProdutos().getSelectedRow();
        
        if(index != -1) {
            DefaultTableModel carrinhoModel = (DefaultTableModel) this.tela.getCarrinho().getModel();
            DefaultTableModel tabelaModel = (DefaultTableModel) this.tela.getProdutos().getModel();
            try{
                //if(carrinhoModel.getRowCount()> 1){
                //    carrinhoModel.removeRow(carrinhoModel.getRowCount()-1);
                //}
                int qtd = Integer.parseInt(this.tela.getQuantidade().getText());
                int valorCelula = Integer.parseInt(tabelaModel.getValueAt(index, 3).toString());
                if(valorCelula >= qtd) {
                    
                    //altera o valor no estoque
                    valorCelula -= qtd;
                    tabelaModel.setValueAt(valorCelula, index, 3);
                    this.tela.getProdutos().setModel(tabelaModel);
                    //adicina no carrinho
                    carrinhoModel.addRow(new Object[]{tabelaModel.getValueAt(index, 0),tabelaModel.getValueAt(index, 1),tabelaModel.getValueAt(index, 2),qtd});
                    //calculat(carrinhoModel);
                    this.tela.getCarrinho().setModel(carrinhoModel);
                    
                }
                // limpeza tela
                tela.getQuantidade().setText("");
                tela.getQuantidade().setBackground(Color.white);
                this.tela.repaint();
            }
            catch (NumberFormatException err){
                tela.getQuantidade().setBackground(new Color(254,57,57));
            }
        }
    }
    
}
