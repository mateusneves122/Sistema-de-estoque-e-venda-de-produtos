/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.TelaVendas;

import View.TelaVendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PICHAU
 */
public class ExcluirDoCarrinho implements ActionListener {
    private TelaVendas tela;

    public ExcluirDoCarrinho(TelaVendas tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = this.tela.getCarrinho().getSelectedRow();
        if(index != -1){
            DefaultTableModel carrinhoModel = (DefaultTableModel) this.tela.getCarrinho().getModel();
            DefaultTableModel tabelaModel = (DefaultTableModel) this.tela.getProdutos().getModel();
            try{
                int qtd = Integer.parseInt(carrinhoModel.getValueAt(index, 3).toString());
                int id = Integer.parseInt(carrinhoModel.getValueAt(index, 0).toString());
                for(int i = 0;i < tabelaModel.getRowCount();i++){
                    if(Integer.parseInt(tabelaModel.getValueAt(i, 0).toString()) == id){
                        tabelaModel.setValueAt(Integer.parseInt(tabelaModel.getValueAt(i, 3).toString())+qtd, i, 3);
                        this.tela.getProdutos().setModel(tabelaModel);
                        break;
                    }
                }
                carrinhoModel.removeRow(index);
                this.tela.getCarrinho().setModel(carrinhoModel);
                this.tela.getProdutos().setModel(tabelaModel);
            }catch(RuntimeException a){
                
            }
        }
    }
    
}
