/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.janela;

import Armazenamento.Arquivo;
import Armazenamento.JSONCliente;
import Model.ClienteCadastrado;
import Model.client.Cliente;
import View.CadastrarCliente;
import View.TelaVendas;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SuvacoDeCobra
 */
public class EventoJanelaCadastroCliente implements WindowListener {

    private TelaVendas tela;
        
    public EventoJanelaCadastroCliente(TelaVendas tela) {
        this.tela = tela;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        /*System.out.println("Fechou");
        String toJSON = JSONCliente.toJSON(this.tela.getClienteList().getClientesCadastrados());
        Arquivo.escreverArquivo("dadosClientes", toJSON);
        for(Cliente i : this.tela.getClienteList().getClientesCadastrados()) {
            System.out.println(i.getNome() + " " + i.getCpf());
        }*/
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}
