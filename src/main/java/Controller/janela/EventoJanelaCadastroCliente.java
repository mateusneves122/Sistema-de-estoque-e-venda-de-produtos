/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.janela;

import Armazenamento.Arquivo;
import Armazenamento.JSONCliente;
import Model.client.Cliente;
import View.CadastrarCliente;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SuvacoDeCobra
 */
public class EventoJanelaCadastroCliente extends CadastrarCliente implements WindowListener {

    private CadastrarCliente tela;
        
    public EventoJanelaCadastroCliente(CadastrarCliente cadastrarCliente) {
        this.tela = cadastrarCliente;
        this.clienteList.setClientesCadastrados(new ArrayList<>());
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        try {
            
            String lerArquivo = Arquivo.lerArquivo("dadosClientes");
            List<Cliente> clientes = JSONCliente.toClientes(lerArquivo);
            
            this.clienteList.setClientesCadastrados(new ArrayList<>());
            this.clienteList.setClientesCadastrados(clientes);
        } catch (FileNotFoundException ex) {
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Fechou");
        String toJSON = JSONCliente.toJSON(this.clienteList.getClientesCadastrados());
        Arquivo.escreverArquivo("dadosClientes", toJSON);
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
