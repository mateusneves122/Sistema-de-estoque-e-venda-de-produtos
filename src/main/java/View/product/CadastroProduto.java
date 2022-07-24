/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.product;

import Controller.CadastroProdutos.SalvarProduto;
import Model.Inventory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yanfo
 */
public class CadastroProduto extends JFrame {
    private JPanel tela;
    private JTable tabela;
    private Inventory listaProdutos;
    
    private JTextField nome;
    private JTextField preco;
    private JTextField Quantidade;

    public JPanel getTela() {
        return tela;
    }

    public void setTela(JPanel tela) {
        this.tela = tela;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }

    public Inventory getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(Inventory listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public JTextField getNome() {
        return nome;
    }

    public void setNome(JTextField nome) {
        this.nome = nome;
    }

    public JTextField getPreco() {
        return preco;
    }

    public void setPreco(JTextField preco) {
        this.preco = preco;
    }

    public JTextField getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(JTextField Quantidade) {
        this.Quantidade = Quantidade;
    }

    
    
    public CadastroProduto() {
        
    }
    
    private void configuraJanela() {
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.tela = new JPanel();
        this.tela.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
    }
    
    private void configuraInsercao() {
        int size = 15;
        JPanel jpInsercao = new JPanel();
        jpInsercao.setPreferredSize(new Dimension(1280,240));
        
        this.nome = new JTextField(size);
        this.preco = new JTextField(size);
        this.Quantidade = new JTextField(size);
        
        
        
        jpInsercao.add(new JLabel("Nome:"));
        jpInsercao.add(this.nome);
        jpInsercao.add(new JLabel("Preço:"));
        jpInsercao.add(this.preco);
        jpInsercao.add(new JLabel("Quantidade:"));
        jpInsercao.add(this.Quantidade);
        
        JButton adicionar = new JButton("Salvar");
        adicionar.addActionListener(new SalvarProduto(this));
        jpInsercao.add(adicionar);
        
        this.tela.add(jpInsercao, BorderLayout.NORTH);
    }
    
    // TODO: realizar a inserção dos dados
    private void configuraPlanilha() {
        JPanel jpTabela = new JPanel();
        jpTabela.setPreferredSize(new Dimension(640, 480));
        
        this.listaProdutos = new Inventory();
        this.setTitle("Cadastro e edição de produtos");
        String[][] dataTable = {
            //{"","","",""}
        };
        
        String[] columnNames = {
            "Id",
            "Produto",
            "Valor Unitário",
            "Quantidade"
        };
        
        this.tabela = new JTable(new DefaultTableModel(dataTable, columnNames)) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        
        this.tabela.setPreferredScrollableViewportSize(new Dimension(640, 480));
        this.tabela.setFillsViewportHeight(true);
        
        JScrollPane painel = new JScrollPane(this.tabela);
        jpTabela.add(painel);
        
        this.tela.add(jpTabela, BorderLayout.WEST);
    }
    
    public void mostraTela() {
        this.add(this.tela);
        this.setVisible(true);
    }
    
    public void montaTela() {
        configuraJanela();
        configuraInsercao();
        configuraPlanilha();
        mostraTela();
    }
    
    public static void main(String[] args) {
        CadastroProduto tela = new CadastroProduto();
        tela.montaTela();
    }
}
