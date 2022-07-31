/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.cadastroFuncionario;

import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author yanfo
 */
public class VisualizarFuncionario implements MouseListener {
    private CadastroProdutoFuncionario tela;

    public VisualizarFuncionario(CadastroProdutoFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = this.tela.getTabelaFuncionarios().getSelectedRow();
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
