/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.TelaVendas;

import Enum.ColumnNameProduto;
import View.TelaVendas;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PICHAU
 */ 
public abstract class LimpaCarrinho {
    void limpar(TelaVendas tela){
        String[][] dataTable ={};
            DefaultTableModel carrinhoModel = (DefaultTableModel) tela.getCarrinho().getModel();
            DefaultTableModel nModel = new DefaultTableModel(dataTable,ColumnNameProduto.values());
            carrinhoModel = nModel;
            tela.getCarrinho().setModel(carrinhoModel);
            tela.repaint();
    }
}
