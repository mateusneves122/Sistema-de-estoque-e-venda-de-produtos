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

public class FinalizarCompraBtn implements ActionListener {

    private TelaVendas telaVenda;
    private FinalizarCompra telaFinCompra;
    private String formaDePagamento;
    private double totalPagar;
    
    public FinalizarCompraBtn(TelaVendas tela) {
       this.telaVenda = tela;
       this.totalPagar = 0;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       JTable carrinho = this.telaVenda.getCarrinho();
       
       //Paramêtros para instancia a telFinCompra;
       this.formaDePagamento = this.telaVenda.getFormaPagamentoToString();
       this.totalPagar = calculaTotal(carrinho);
       telaFinCompra = new FinalizarCompra(Double.toString(totalPagar), formaDePagamento);
       
       telaFinCompra.montaTela();
    }
    
    
    private double calculaTotal (JTable carrinho) {
       int totalRow = carrinho.getRowCount();
       double soma = 0;
       
       for(int i = 0;i < totalRow;i++) {
           double valor = Double.parseDouble((String) carrinho.getModel().getValueAt(i, 2));
           int quantidade = (int) carrinho.getModel().getValueAt(i, 3);
           soma += valor*(double)quantidade;
        }
       return soma;
    }
}
