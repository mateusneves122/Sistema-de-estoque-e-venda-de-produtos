/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.TelaVendas;

import View.FinalizarCompra;
import View.TelaVendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

/**
 *
 * @author SuvacoDeCobra
 */
public class btnFinalizarCompra implements ActionListener {

    private TelaVendas telaVenda;
    private FinalizarCompra telaFinCompra;
    private double totalPagar;
    
    public btnFinalizarCompra(TelaVendas tela) {
       this.telaVenda = tela;
       this.totalPagar = 0;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       //Calculando o total a pagar;
       JTable carrinho = this.telaVenda.getCarrinho();
       int totalRow = carrinho.getRowCount();
       int soma = 0;
       
       for(int i = 0;i < totalRow;i++) {
           double valor = Double.parseDouble((String) carrinho.getModel().getValueAt(i, 2));
           int quantidade = (int) carrinho.getModel().getValueAt(i, 3);
           this.totalPagar += valor*(double)quantidade;
        }
        
        telaFinCompra = new FinalizarCompra(Double.toString(totalPagar), "Dinheiro");
        telaFinCompra.montaTela();
    }
    
}
