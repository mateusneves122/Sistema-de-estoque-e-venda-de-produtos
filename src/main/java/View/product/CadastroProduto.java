/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.product;

import Controller.CadastroProdutos.AtualizarProduto;
import Controller.CadastroProdutos.EditarProduto;
import Controller.CadastroProdutos.ExcluirProduto;
import Controller.CadastroProdutos.SalvarProduto;
import Model.Estoque;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yanfo
 */
public class CadastroProduto extends JFrame {
    protected JTabbedPane abas;
    protected JButton atualizar;
    protected JButton adicionar;
    
    private JPanel telaProduto;
    private JTable tabelaProdutos;
    private Estoque listaProdutos;
    
    private JTextField nomeProduto;
    private JTextField preco;
    private JTextField Quantidade;
    private JTextArea descricao;
    private JComboBox tipoProduto;
    private JComboBox unidadeMedida;
    private JTextField pesoVolume;
    private JTextField fornecedor;
    private JTextField localizacao;
    
    private JPanel telaFuncionario;
    private JTable tabelaFuncionarios;

    //////////////////////////////////// Métodos Getters e Setters///////////////////////////////////

    public JButton getAtualizar() {
        return atualizar;
    }

    public void setAtualizar(JButton atualizar) {
        this.atualizar = atualizar;
    }

    public JPanel getTelaProduto() {
        return telaProduto;
    }

    public void setTelaProduto(JPanel telaProduto) {
        this.telaProduto = telaProduto;
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

    public JTextArea getDescricao() {
        return descricao;
    }

    public void setDescricao(JTextArea descricao) {
        this.descricao = descricao;
    }

    public JComboBox getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(JComboBox tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

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

    public JComboBox getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(JComboBox unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public JTextField getPesoVolume() {
        return pesoVolume;
    }

    public void setPesoVolume(JTextField pesoVolume) {
        this.pesoVolume = pesoVolume;
    }

    public JTextField getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(JTextField fornecedor) {
        this.fornecedor = fornecedor;
    }

    public JTextField getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(JTextField localizacao) {
        this.localizacao = localizacao;
    }

    public JButton getAdicionar() {
        return adicionar;
    }

    public void setAdicionar(JButton adicionar) {
        this.adicionar = adicionar;
    }

    
    //////////////////////////////////// Métodos Getters e Setters///////////////////////////////////
    
    public CadastroProduto() {
        this.listaProdutos = new Estoque();
        this.atualizar = new JButton("Atualizar");
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
        int size = 10;
        JPanel jpInsercao = new JPanel();
        JPanel esquerda = new JPanel();
        JPanel direita = new JPanel();
        jpInsercao.setPreferredSize(new Dimension(1280,240));
        esquerda.setPreferredSize(new Dimension(960,240));
        direita.setPreferredSize(new Dimension(320,240));
        
        jpInsercao.setLayout(new BorderLayout());
        
        this.nomeProduto = new JTextField(size);
        this.preco = new JTextField(size);
        this.Quantidade = new JTextField(size);
        
        
        esquerda.add(new JLabel("Nome:"));
        esquerda.add(this.nomeProduto);
        esquerda.add(new JLabel("Preço:"));
        esquerda.add(this.preco);
        esquerda.add(new JLabel("Quantidade:"));
        esquerda.add(this.Quantidade);
        
        String[] tipos = {"Alimento", "Material", "Fármaco", "Eletrônico"};
        this.tipoProduto = new JComboBox(tipos);
        this.tipoProduto.setSelectedIndex(0);
        esquerda.add(new JLabel("Tipo:"));
        esquerda.add(this.tipoProduto);
        
        esquerda.add(new JLabel("Peso/Volume:"));
        this.pesoVolume = new JTextField(size);
        esquerda.add(this.pesoVolume);
        
        String[] uniMedida = {"(---)","Kg","g","mg","L","ml"};
        this.unidadeMedida = new JComboBox(uniMedida);
        this.unidadeMedida.setSelectedIndex(0);
        esquerda.add(this.unidadeMedida);
        
        esquerda.add(new JLabel("Fornecedor:"));
        this.fornecedor = new JTextField(size);
        esquerda.add(this.fornecedor);
        
        esquerda.add(new JLabel("Localização no estoque:"));
        this.localizacao = new JTextField(size);
        esquerda.add(this.localizacao);
        
        this.descricao = new JTextArea();
        this.descricao.setPreferredSize(new Dimension(240,150));
        this.descricao.setBorder(BorderFactory.createTitledBorder("Descrição"));
        direita.add(this.descricao);
        
        this.adicionar = new JButton("Adicionar");
        adicionar.addActionListener(new SalvarProduto(this));
        esquerda.add(adicionar);
        
        this.atualizar.addActionListener(new AtualizarProduto(this));
        this.atualizar.setEnabled(false);
        esquerda.add(this.atualizar);
        
        jpInsercao.add(esquerda, BorderLayout.WEST);
        jpInsercao.add(direita, BorderLayout.EAST);
        
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
        
        JButton editar = new JButton("Editar");
        editar.addActionListener(new EditarProduto(this));
        jpDetalhes.add(editar);
        
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
