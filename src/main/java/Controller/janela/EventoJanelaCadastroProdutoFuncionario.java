/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.janela;

import Armazenamento.Arquivo;
import Armazenamento.JSONFuncionario;
import Armazenamento.JSONProduto;
import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author yanfo
 */
public class EventoJanelaCadastroProdutoFuncionario implements WindowListener {
    private CadastroProdutoFuncionario tela;

    public EventoJanelaCadastroProdutoFuncionario(CadastroProdutoFuncionario tela) {
        this.tela = tela;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        String toJSON = JSONFuncionario.toJSON(this.tela.getFuncionariosContratados().getFuncionariosContratados());
        Arquivo.escreverArquivo("dadosFuncionarios", toJSON);
        
        toJSON = JSONProduto.toJSON(this.tela.getListaProdutos().getProdutosEmEstoque());
        Arquivo.escreverArquivo("dadosProdutos", toJSON);
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
