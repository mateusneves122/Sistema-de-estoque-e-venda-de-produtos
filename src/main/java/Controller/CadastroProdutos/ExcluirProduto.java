/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CadastroProdutos;

import View.product.CadastroProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yanfo
 */
public class ExcluirProduto implements ActionListener {
    private CadastroProduto tela;

    public ExcluirProduto(CadastroProduto tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = this.tela.getTabelaProdutos().getSelectedRow();
        if(index != -1) {
            int id = (int) this.tela.getTabelaProdutos().getValueAt(index, 0);
            this.tela.getListaProdutos().removeProductId(id);
            DefaultTableModel tabela = (DefaultTableModel) this.tela.getTabelaProdutos().getModel();
            tabela.removeRow(index);
            this.tela.getTabelaProdutos().setModel(tabela);
        }
    }
    
}
