/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.janela;

import Armazenamento.Arquivo;
import Armazenamento.JSONFuncionario;
import Armazenamento.JSONProduto;
import Model.product.Produto;
import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

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
        try {
            System.out.println("Abriu");
            String lerArquivo = Arquivo.lerArquivo("dadosProdutos");
            List<Produto> estoque = JSONProduto.toProdutos(lerArquivo);
            
            this.tela.getListaProdutos().setProdutosEmEstoque(new ArrayList<>());
            this.tela.getListaProdutos().setProdutosEmEstoque(estoque);
            System.out.println("Abriu2");
            
            DefaultTableModel model = (DefaultTableModel) tela.getTabelaProdutos().getModel();
            
            for(Produto i : estoque) {
                model.addRow(new Object[]{i.getId(),i.getNome(),i.getPreco(),i.getQuantidade()});
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Fechou");
        String toJSON = JSONFuncionario.toJSON(this.tela.getFuncionariosContratados().getFuncionariosContratados());
        Arquivo.escreverArquivo("dadosFuncionarios", toJSON);
        
        toJSON = JSONProduto.toJSON(this.tela.getListaProdutos().getProdutosEmEstoque());
        Arquivo.escreverArquivo("dadosProdutos", toJSON);
        System.out.println("Fechou2");
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
