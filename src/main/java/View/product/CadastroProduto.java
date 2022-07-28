/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.product;

import Controller.CadastroProdutos.ExcluirProduto;
import Controller.CadastroProdutos.SalvarProduto;
import Model.Estoque;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yanfo
 */
public class CadastroProduto extends JFrame {
    JTabbedPane abas;
    
    private JPanel telaProduto;
    private JTable tabelaProdutos;
    private Estoque listaProdutos;
    
    private JTextField nomeProduto;
    private JTextField preco;
    private JTextField Quantidade;
    
    private JPanel telaFuncionario;
    private JTable tabelaFuncionarios;

    //////////////////////////////////// Métodos Getters e Setters///////////////////////////////////
    public JPanel getTelaFuncionario() {
        return telaFuncionario;
    }

    public void setTelaFuncionario(JPanel telaFuncionario) {
        this.telaFuncionario = telaFuncionario;
    }

    public JTable getTabelaFuncionarios() {
        return tabelaFuncionarios;
    }

    public void setTabelaFuncionarios(JTable tabelaFuncionarios) {
        this.tabelaFuncionarios = tabelaFuncionarios;
    }

    public JPanel getTelaProduto() {
        return telaProduto;
    }

    public void setTelaProduto(JPanel tela) {
        this.telaProduto = tela;
    }

    public JTable getTabelaProdutos() {
        return tabelaProdutos;
    }

    public void setTabelaProdutos(JTable tabelaProdutos) {
        this.tabelaProdutos = tabelaProdutos;
    }

    public Estoque getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(Estoque listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public JTextField getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(JTextField nomeProduto) {
        this.nomeProduto = nomeProduto;
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

    //////////////////////////////////// Métodos Getters e Setters///////////////////////////////////
    
    public CadastroProduto() {
        this.listaProdutos = new Estoque();
    }
    
    private void configuraJanela() {
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.abas = new JTabbedPane();
        
        this.telaProduto = new JPanel();
        this.telaProduto.setLayout(new BorderLayout());
        
        this.telaFuncionario = new JPanel();
        this.telaFuncionario.setLayout(new BorderLayout());
        this.telaFuncionario.add(new JLabel("Olá!"));
        
        this.abas.addTab("Produtos", this.telaProduto);
        this.abas.addTab("Funcionários", this.telaFuncionario);
        
        this.setLocationRelativeTo(null);
    }
    
    private void configuraInsercaoProduto() {
        int size = 15;
        JPanel jpInsercao = new JPanel();
        jpInsercao.setPreferredSize(new Dimension(1280,240));
        
        this.nomeProduto = new JTextField(size);
        this.preco = new JTextField(size);
        this.Quantidade = new JTextField(size);
        
        
        
        jpInsercao.add(new JLabel("Nome:"));
        jpInsercao.add(this.nomeProduto);
        jpInsercao.add(new JLabel("Preço:"));
        jpInsercao.add(this.preco);
        jpInsercao.add(new JLabel("Quantidade:"));
        jpInsercao.add(this.Quantidade);
        
        JButton adicionar = new JButton("Salvar");
        adicionar.addActionListener(new SalvarProduto(this));
        jpInsercao.add(adicionar);
        
        
        
        this.telaProduto.add(jpInsercao, BorderLayout.NORTH);
    }
    
    // TODO: realizar a inserção dos dados
    private void configuraPlanilhaProdutos() {
        JPanel jpTabela = new JPanel();
        jpTabela.setPreferredSize(new Dimension(640, 480));
        
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
        
        this.tabelaProdutos = new JTable(new DefaultTableModel(dataTable, columnNames)) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        
        this.tabelaProdutos.setPreferredScrollableViewportSize(new Dimension(640, 480));
        this.tabelaProdutos.setFillsViewportHeight(true);
        
        JScrollPane painel = new JScrollPane(this.tabelaProdutos);
        jpTabela.add(painel);
        
        this.telaProduto.add(jpTabela, BorderLayout.WEST);
    }
    
    private void configuraTelaDetalhes() {
        JPanel jpDetalhes = new JPanel();
        jpDetalhes.setPreferredSize(new Dimension(620,480));
        jpDetalhes.setBorder(BorderFactory.createTitledBorder("Detalhes"));
        
        JButton remove = new JButton("Remover");
        remove.addActionListener(new ExcluirProduto(this));
        jpDetalhes.add(remove);
        
        this.telaProduto.add(jpDetalhes, BorderLayout.EAST);
    }
    
    public void mostraTela() {
        this.add(this.abas);
        this.setVisible(true);
    }
    
    public void montaTela() {
        configuraJanela();
        configuraInsercaoProduto();
        configuraPlanilhaProdutos();
        configuraTelaDetalhes();
        mostraTela();
    }
    
    public static void main(String[] args) {
        CadastroProduto tela = new CadastroProduto();
        tela.montaTela();
    }
}
