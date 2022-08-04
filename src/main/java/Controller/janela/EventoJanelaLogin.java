//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Controller.janela;

import Armazenamento.Arquivo;
import Armazenamento.JSONFuncionario;
import Model.employee.Funcionario;
import View.Login;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
            
            this.tela.getFuncionariosContratados().setFuncionariosContratados(new ArrayList<>());
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
