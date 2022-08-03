/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.janela;

import Armazenamento.Arquivo;
import Armazenamento.JSONFuncionario;
import Armazenamento.JSONProduto;
import Model.employee.Funcionario;
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
            System.out.println("Abriu");
            List<Produto> estoque = JSONProduto.toProdutos(lerArquivo);
            System.out.println("Abriu");
            //this.tela.getListaProdutos().setProdutosEmEstoque(new ArrayList<>());
            System.out.println("Abriu");
            this.tela.getListaProdutos().setProdutosEmEstoque(estoque);
            
            System.out.println("Abriu2");
            
            DefaultTableModel model = (DefaultTableModel) tela.getTabelaProdutos().getModel();
            for(Produto i : estoque) {
                model.addRow(new Object[]{i.getId(),i.getNome(),i.getPreco(),i.getQuantidade()});
            }
            tela.getTabelaProdutos().setModel(model);
            
            
            
            lerArquivo = Arquivo.lerArquivo("dadosFuncionarios");
            List<Funcionario> funContratados = JSONFuncionario.toFuncionarios(lerArquivo);
            this.tela.getFuncionariosContratados().setFuncionariosContratados(new ArrayList<>());
            this.tela.getFuncionariosContratados().setFuncionariosContratados(funContratados);
            DefaultTableModel model2 = (DefaultTableModel) tela.getTabelaFuncionarios().getModel();
            
            String funcao;
            for(Funcionario i : funContratados) {
                if(i.isAdmin()) {
                    funcao = "Administração";
                }
                else {
                    funcao = "Vendas";
                }
                model2.addRow(new Object[]{i.getNome(),i.getRegistro(), i.getCargo(), funcao, i.getPagamentoFixo()});
            }
            tela.getTabelaFuncionarios().setModel(model2);
            
            
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
