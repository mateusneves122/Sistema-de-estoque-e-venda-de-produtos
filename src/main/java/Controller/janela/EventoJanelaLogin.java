/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.janela;

import Armazenamento.Arquivo;
import Armazenamento.JSON;
import Model.employee.Funcionario;
import View.Login;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author yanfo
 */
public class EventoJanelaLogin implements WindowListener {
    private Login tela;

    public EventoJanelaLogin(Login tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try {
            String lerArquivo = Arquivo.lerArquivo("dados");
            List<Funcionario> contatos = JSON.toFuncionarios(lerArquivo);
            
            DefaultListModel<Funcionario> modelo = new DefaultListModel<>();
            
            for (Funcionario contato : contatos) {
                modelo.addElement(contato);
            }
            // Editar aqui
            //tela.getLista().setModel(modelo);
            tela.repaint();
            
        } catch (FileNotFoundException ex) {
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
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
