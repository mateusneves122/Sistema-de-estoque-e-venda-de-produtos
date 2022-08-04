//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Controller.janela;


import View.TelaVendas;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

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
