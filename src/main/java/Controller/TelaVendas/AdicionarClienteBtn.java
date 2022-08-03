/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.TelaVendas;

import View.CadastrarCliente;
import View.TelaVendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author SuvacoDeCobra
 */
public class AdicionarClienteBtn implements ActionListener {
    
    private CadastrarCliente telaCadastrarCliente;
    private TelaVendas tela;
    
    public AdicionarClienteBtn(TelaVendas tela) {
        this.tela = tela;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        telaCadastrarCliente = new CadastrarCliente(tela);
        telaCadastrarCliente.montaTela();
    }
    
}
