/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.janela;

import Armazenamento.Arquivo;
import Armazenamento.JSONFuncionario;
import Model.employee.Funcionario;
import View.Login;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.List;

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
            
            String lerArquivo = Arquivo.lerArquivo("dadosFuncionarios");
            List<Funcionario> contatos = JSONFuncionario.toFuncionarios(lerArquivo);
            
            this.tela.getFuncionariosContratados().setFuncionariosContratados(contatos);
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
