/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
