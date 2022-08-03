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

    private CadastrarCliente tela;
        
    public EventoJanelaCadastroCliente(CadastrarCliente cadastrarCliente) {
        this.tela = cadastrarCliente;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
        try {
            
            String lerArquivo = Arquivo.lerArquivo("dadosClientes");
            List<Cliente> clientes = JSONCliente.toClientes(lerArquivo);
            
            //this.tela.getClienteList().setClientesCadastrados(new ArrayList<>());
            this.tela.getClienteList().setClientesCadastrados(clientes);
            
            for(Cliente i : clientes) {
                System.out.println(i.getNome() + " " + i.getCpf());
            }
        } catch (FileNotFoundException ex) {
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Fechou");
        String toJSON = JSONCliente.toJSON(this.tela.getClienteList().getClientesCadastrados());
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
