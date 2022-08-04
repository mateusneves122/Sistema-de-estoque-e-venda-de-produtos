//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Controller.TelaVendas;

import Enum.ColumnNameProduto;
import View.FinalizarCompra;
import View.TelaVendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PICHAU
 */
public class CompraD extends LimpaCarrinho implements ActionListener {
    private TelaVendas tela;
    private FinalizarCompra fecha;

    public CompraD(TelaVendas tela,FinalizarCompra f) {
        this.tela = tela;
        this.fecha = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            limpar(tela);
            fecha.dispose();
            
        }catch(RuntimeException a){
            
        }
    }
    
}
