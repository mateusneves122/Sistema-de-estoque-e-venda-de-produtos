//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
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
