/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.TelaVendas;

import View.CadastrarCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author SuvacoDeCobra
 */
public class AdicionarClienteBtn implements ActionListener {
    
    private JPanel telaVenda;
    private CadastrarCliente telaCadastrarCliente;
    
    public AdicionarClienteBtn(JPanel tela) {
        this.telaVenda = tela;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        telaCadastrarCliente = new CadastrarCliente();
        telaCadastrarCliente.montaTela();
    }
    
}
