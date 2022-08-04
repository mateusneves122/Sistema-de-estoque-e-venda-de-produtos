//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
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
            
            // Carregar lista de clientes
            lerArquivo = Arquivo.lerArquivo("dadosClientes");
            List<Cliente> clientes = JSONCliente.toClientes(lerArquivo);
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
        for(Cliente i : this.tela.getClienteList().getClientesCadastrados()) {
            System.out.println(i.getNome() + " " + i.getCpf());
        }
        
        toJSON = JSONProduto.toJSON(this.tela.getEstoque().getProdutosEmEstoque());
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
