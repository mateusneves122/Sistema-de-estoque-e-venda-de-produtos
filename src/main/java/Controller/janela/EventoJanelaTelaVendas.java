/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.janela;

import Armazenamento.Arquivo;
import Armazenamento.JSONCliente;
import Armazenamento.JSONProduto;
import Model.client.Cliente;
import Model.product.Produto;
import View.TelaVendas;
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
public class EventoJanelaTelaVendas implements WindowListener  {
    private TelaVendas tela;

    public EventoJanelaTelaVendas(TelaVendas tela) {
        this.tela = tela;
    }
    @Override
    public void windowOpened(WindowEvent e) {
        try {
            String lerArquivo = Arquivo.lerArquivo("dadosProdutos");
            List<Produto> estoque = JSONProduto.toProdutos(lerArquivo);
            this.tela.getEstoque().setProdutosEmEstoque(new ArrayList<>());
            this.tela.getEstoque().setProdutosEmEstoque(estoque);
            
            DefaultTableModel model = (DefaultTableModel) tela.getProdutos().getModel();
            for(Produto i : estoque) {
                model.addRow(new Object[]{i.getId(),i.getNome(),i.getPreco(),i.getQuantidade()});
            }
            tela.getProdutos().setModel(model);
            tela.repaint();
            
            /*// Carregar lista de clientes
            lerArquivo = Arquivo.lerArquivo("dadosClientes");
            List<Cliente> clientes = JSONCliente.toClientes(lerArquivo);
            
            //this.tela.getClienteList().setClientesCadastrados(new ArrayList<>());
            this.tela.getClienteList().setClientesCadastrados(clientes);
            
            for(Cliente i : clientes) {
                System.out.println(i.getNome() + " " + i.getCpf());
            }*/
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
