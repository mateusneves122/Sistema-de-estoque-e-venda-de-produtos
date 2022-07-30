/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.LoginEntrar.Entrar;
import Controller.TelaVendas.AdicionarNoCarrinho;
import Controller.TelaVendas.ExcluirDoCarrinho;
import Model.employee.Funcionario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PICHAU
 */
public class TelaVendas extends JFrame {
    private JPanel tela;
    private JTable produtos;
    private JTable carrinho;
    private JPanel telaEsq;
    private JPanel telaDir;
    private JTextField Quantidade;

    public JPanel getTela() {
        return tela;
    }

    public void setTela(JPanel tela) {
        this.tela = tela;
    }

    public JTable getProdutos() {
        return produtos;
    }

    public void setProdutos(JTable produtos) {
        this.produtos = produtos;
    }

    public JTable getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(JTable carrinho) {
        this.carrinho = carrinho;
    }

    public JPanel getTelaEsq() {
        return telaEsq;
    }

    public void setTelaEsq(JPanel telaEsq) {
        this.telaEsq = telaEsq;
    }

    public JPanel getTelaDir() {
        return telaDir;
    }

    public void setTelaDir(JPanel telaDir) {
        this.telaDir = telaDir;
    }

    public JTextField getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(JTextField Quantidade) {
        this.Quantidade = Quantidade;
    }
    
    
    
    private void configuraJanela() {
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.tela = new JPanel();
        this.tela.setLayout(new BorderLayout());
        
        this.telaEsq = new JPanel();
        this.telaEsq.setLayout(new BorderLayout());
        
        this.telaDir = new JPanel();
        this.telaDir.setLayout(new BorderLayout());
        
        this.setLocationRelativeTo(null);
        
        //JButton adicionar = new JButton("Salvar");
        
    }
    private void configuraFun() {
        int size = 5;
        JPanel jpFun = new JPanel();
        jpFun.setPreferredSize(new Dimension(620,200));
        
        JButton adicionar = new JButton("Adicionar");
        adicionar.addActionListener(new AdicionarNoCarrinho(this));
        jpFun.add(adicionar);
        this.Quantidade = new JTextField(size);
        jpFun.add(this.Quantidade);
        JButton remover = new JButton("Remover");
        remover.addActionListener(new ExcluirDoCarrinho(this));
        jpFun.add(remover);
        
        String[] fPagamento = { "Cartão", "Dinheiro" };
        JComboBox pagList = new JComboBox(fPagamento);
        pagList.setSelectedIndex(0);
        //pagList.addActionListener(this);
        jpFun.add(new JLabel("Forma de pagamento:"));
        jpFun.add(pagList);
        
        JButton fim = new JButton("Finalizar compra");
        jpFun.add(fim);
        telaDir.add(jpFun, BorderLayout.SOUTH);

    }
    
    //TODO :POSSIVEL ERRO 
    private void configuraPlanilha() {
        JPanel jpTabela = new JPanel();
        jpTabela.setBorder(BorderFactory.createTitledBorder("Estoque"));
        jpTabela.setLayout(new BorderLayout());
        jpTabela.setPreferredSize(new Dimension(630, 480));
        
        //this.listaProdutos = new Estoque();
        this.setTitle("Vendas");
        String[][] dataTable = {
            {"1","banana","1.99","100"},
            {"2","pera","2.99","50"}
        };
        
        String[] columnNames = {
            "Id",
            "Produto",
            "Valor Unitário",
            "Quantidade"
        };
        
        this.produtos = new JTable(new DefaultTableModel(dataTable, columnNames)) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        
        this.produtos.setPreferredScrollableViewportSize(new Dimension(630, 480));
        this.produtos.setFillsViewportHeight(true);
        
        JScrollPane painel = new JScrollPane(this.produtos);
        jpTabela.add(painel);
        telaEsq.add(jpTabela, BorderLayout.WEST);
        
        
    }
    private void configuraCarrinho() {
        JPanel jpCarrinho = new JPanel();
        jpCarrinho.setBorder(BorderFactory.createTitledBorder("Carrinho"));
        jpCarrinho.setLayout(new BorderLayout());
        jpCarrinho.setPreferredSize(new Dimension(630, 460));
        
        //this.listaProdutos = new Estoque();
        this.setTitle("Vendas");
        String[][] dataTable = {
            //{"","","",""}
        };
        
        String[] columnNames = {
            "Id",
            "Produto",
            "Valor Unitário",
            "Quantidade"
        };
        
        this.carrinho = new JTable(new DefaultTableModel(dataTable, columnNames)) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        
        this.carrinho.setPreferredScrollableViewportSize(new Dimension(630, 360));
        this.carrinho.setFillsViewportHeight(true);
        
        JScrollPane painel = new JScrollPane(this.carrinho);
        jpCarrinho.add(painel);
        telaDir.add(jpCarrinho, BorderLayout.NORTH);
        
    }
    public void mostraTela() {
        this.tela.add(this.telaEsq,BorderLayout.WEST);
        this.tela.add(this.telaDir,BorderLayout.EAST);
        this.add(tela);
        this.setVisible(true);
    }
    
    public void montaTela() {
        configuraJanela();
        configuraPlanilha();
        configuraCarrinho();
        configuraFun();
        mostraTela();
    }
    
    public static void main(String[] args) {
        TelaVendas tela = new TelaVendas();
        tela.montaTela();
    }
}
