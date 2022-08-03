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
public class CadastrarClienteBtn extends CadastrarCliente implements ActionListener {

    private CadastrarCliente telaCadastrarCliente;
    
    public CadastrarClienteBtn(CadastrarCliente telaPrincipal) {
        this.telaCadastrarCliente = telaPrincipal;
        System.out.println("TESTE DO NOME" + telaPrincipal.getNome().getText());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
//        String nome = this.getNome().getText();
//        System.out.println("TESTANDO NOME: " + this.getNome().getText());
    }
}
