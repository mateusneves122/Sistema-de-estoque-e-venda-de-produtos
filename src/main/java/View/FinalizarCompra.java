/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Interfaces.View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FinalizarCompra extends JFrame implements View {
    private JPanel tela;
    private String totalPagar;
    private String metodoPagamento;
    
    public FinalizarCompra(String totalPagar, String metodoPagamento) {
        this.totalPagar = totalPagar;
        this.metodoPagamento = metodoPagamento;
    }
    
    @Override
    public void configuraJanela(){
        this.setSize(200, 120);
        
        this.tela = new JPanel();
        this.tela.setLayout(new BorderLayout());
        
        this.setLocationRelativeTo(null);
    }
    
    private void configuraFinalizarCompra() {
        JPanel jpFinalizarCompra = new JPanel();
        jpFinalizarCompra.setSize(300,600);
        
        jpFinalizarCompra.setLayout(new GridLayout(4,4));
        jpFinalizarCompra.add(new JLabel("Total a pagar: " + totalPagar));
        jpFinalizarCompra.add(new JLabel("Desconto: " + "R$0.00"));
        jpFinalizarCompra.add(new JLabel("Metodo de pagamento: " + metodoPagamento));
        
        JButton btnConfimar = new JButton("Confirmar");
        btnConfimar.setPreferredSize(new Dimension(120,20));
        jpFinalizarCompra.add(btnConfimar);
        
        this.add(jpFinalizarCompra, BorderLayout.WEST);
    }

    
    
    public void mostraTela() {
        this.add(tela);
        this.setVisible(true);
    }

    public void montaTela() {
        configuraJanela();
        configuraFinalizarCompra();
        mostraTela();
    }
}

  