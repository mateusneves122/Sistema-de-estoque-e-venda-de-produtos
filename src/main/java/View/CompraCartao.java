/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Interfaces.View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author PICHAU
 */
public class CompraCartao extends JFrame implements View{
    
    private JPanel tela;
    private String totalPagar;
    private String metodoPagamento;
    private JTextField nCartao;
    
    public CompraCartao(String totalPagar, String metodoPagamento) {
        this.totalPagar = totalPagar;
        this.metodoPagamento = metodoPagamento;
    }
    
    @Override
    public void configuraJanela(){
        this.setSize(680, 130);
        
        this.tela = new JPanel();
        this.tela.setLayout(new BorderLayout());
        
        this.setLocationRelativeTo(null);
    }
    
    private void configuraFinalizarCompra() {
        JPanel jpFinalizarCompra = new JPanel();
        jpFinalizarCompra.setSize(300,600);
        
        jpFinalizarCompra.setLayout(new GridLayout(3,3));
        jpFinalizarCompra.add(new JLabel("Total a pagar: " + totalPagar));
        jpFinalizarCompra.add(new JLabel("Desconto:"));
        jpFinalizarCompra.add(new JLabel("Metodo de pagamento: " + metodoPagamento));
        jpFinalizarCompra.add(new JLabel("Numero de parcelas:"));
        String[] parc = {"1","2","3","4","5","6","7","8","9","10","11","12"};        
        JComboBox pagList = new JComboBox(parc);
        jpFinalizarCompra.add(pagList);
        jpFinalizarCompra.add(new JLabel("Numero do cartão:"));
        this.nCartao = new JTextField(16);
        jpFinalizarCompra.add(nCartao);
        
        
        JButton btnConfimar = new JButton("Confirmar");
        btnConfimar.setPreferredSize(new Dimension(120,20));
        jpFinalizarCompra.add(btnConfimar);
        
        this.add(jpFinalizarCompra, BorderLayout.WEST);
    }

    
    
    @Override
    public void mostraTela() {
        this.add(tela);
        this.setVisible(true);
    }

    @Override
    public void montaTela() {
        configuraJanela();
        configuraFinalizarCompra();
        mostraTela();
    }
}
