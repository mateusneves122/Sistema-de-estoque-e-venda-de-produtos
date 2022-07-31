/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.produtoFuncionario;

import Controller.CadastroProdutos.AtualizarProduto;
import Controller.CadastroProdutos.EditarProduto;
import Controller.CadastroProdutos.ExcluirProduto;
import Controller.CadastroProdutos.SalvarProduto;
import Controller.CadastroProdutos.VisualizaItem;
import Model.Estoque;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
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
public class CadastroProdutoFuncionario extends JFrame {
    protected JTabbedPane abas;
    protected JButton atualizar;
    protected JButton adicionar;
    
    private JPanel telaProduto;
    private JTable tabelaProdutos;
    private Estoque listaProdutos;
    
    // Painel de inserção de produtos
    private JTextField nomeProduto;
    private JTextField preco;
    private JTextField Quantidade;
    private JTextArea descricao;
    private JComboBox tipoProduto;
    private JComboBox unidadeMedida;
    private JTextField valorUnidade;
    private JTextField fornecedor;
    private JTextField localizacao;
    
    // Painel de detalhes
    private JTextArea dDescricao;
    private JTextField dTipoProduto;
    private JTextField dUnidadeMedida;
    private JTextField dUnidadeOpt;
    private JTextField dFornecedor;
    private JTextField dLocalizacao;
    
    // Tela de funcionários
    private JPanel telaFuncionario;
    
    private JTextField nomeFuncionario;
    private JTextField cpf;
    private JTextField pagamentoFixo;
    private JPasswordField senha;
    private JTextField rg;
    private JTextField telefone;
    private JTextField registro;
    private JComboBox sexo;
    private JTextField cargo;
    private ButtonGroup isAdmin;
    
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

    public JTextField getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(JTextField valorUnidade) {
        this.valorUnidade = valorUnidade;
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

    public JTextArea getdDescricao() {
        return dDescricao;
    }

    public void setdDescricao(JTextArea dDescricao) {
        this.dDescricao = dDescricao;
    }

    public JTextField getdTipoProduto() {
        return dTipoProduto;
    }

    public void setdTipoProduto(JTextField dTipoProduto) {
        this.dTipoProduto = dTipoProduto;
    }

    public JTextField getdUnidadeMedida() {
        return dUnidadeMedida;
    }

    public void setdUnidadeMedida(JTextField dUnidadeMedida) {
        this.dUnidadeMedida = dUnidadeMedida;
    }

    public JTextField getdUnidadeOpt() {
        return dUnidadeOpt;
    }

    public void setdUnidadeOpt(JTextField dUnidadeOpt) {
        this.dUnidadeOpt = dUnidadeOpt;
    }

    public JTextField getdFornecedor() {
        return dFornecedor;
    }

    public void setdFornecedor(JTextField dFornecedor) {
        this.dFornecedor = dFornecedor;
    }

    public JTextField getdLocalizacao() {
        return dLocalizacao;
    }

    public void setdLocalizacao(JTextField dLocalizacao) {
        this.dLocalizacao = dLocalizacao;
    }

    //////////////////////////////////// Métodos Getters e setters dos Funcionários///////////

    public JTextField getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(JTextField nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public JTextField getCpf() {
        return cpf;
    }

    public void setCpf(JTextField cpf) {
        this.cpf = cpf;
    }

    public JTextField getPagamentoFixo() {
        return pagamentoFixo;
    }

    public void setPagamentoFixo(JTextField pagamentoFixo) {
        this.pagamentoFixo = pagamentoFixo;
    }

    public JPasswordField getSenha() {
        return senha;
    }

    public void setSenha(JPasswordField senha) {
        this.senha = senha;
    }

    public JTextField getRg() {
        return rg;
    }

    public void setRg(JTextField rg) {
        this.rg = rg;
    }

    public JTextField getTelefone() {
        return telefone;
    }

    public void setTelefone(JTextField telefone) {
        this.telefone = telefone;
    }

    public JTextField getRegistro() {
        return registro;
    }

    public void setRegistro(JTextField registro) {
        this.registro = registro;
    }

    public JComboBox getSexo() {
        return sexo;
    }

    public void setSexo(JComboBox sexo) {
        this.sexo = sexo;
    }

    public JTextField getCargo() {
        return cargo;
    }

    public void setCargo(JTextField cargo) {
        this.cargo = cargo;
    }

    public ButtonGroup getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(ButtonGroup isAdmin) {
        this.isAdmin = isAdmin;
    }

    
    
    //////////////////////////////////// Métodos da Janela///////////////////////////////////
    
    public CadastroProdutoFuncionario() {
        this.listaProdutos = new Estoque();
        this.atualizar = new JButton("Atualizar");
        this.setTitle("Cadastro e edição de produtos e funcionários");
    }
    
    private void configuraJanela() {
        // Janela por padrão na Resolução 1280x720
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.abas = new JTabbedPane();
        
        this.telaProduto = new JPanel();
        this.telaProduto.setLayout(new BorderLayout());
        
        this.telaFuncionario = new JPanel();
        this.telaFuncionario.setLayout(new BorderLayout());
        
        this.abas.addTab("Produtos", this.telaProduto);
        this.abas.addTab("Funcionários", this.telaFuncionario);
        
        this.setLocationRelativeTo(null);
    }
    
    private void configuraInsercaoProduto() {
        // Tamanho dos campos dos JTextFields
        int size = 11;
        // Container do gerenciamento de produtos no estoque.
        JPanel jpInsercao = new JPanel();
        
        // Divisão do container de gerenciamento de produtos para fins de formatação
        JPanel esquerda = new JPanel();
        JPanel direita = new JPanel();
        
        // Tamanho do container de gerenciamento de produtos irá ter toda a largura
        // da tela e metade da altura. Ficará no cabeçalho da tela
        jpInsercao.setPreferredSize(new Dimension(1280,240));
        
        // painel esquerdo tem dois terços da largura da tela e o painel direito,
        // um terço.
        esquerda.setPreferredSize(new Dimension(960,240));
        direita.setPreferredSize(new Dimension(320,240));
        
        jpInsercao.setLayout(new BorderLayout());
        
        this.nomeProduto = new JTextField(size);
        this.preco = new JTextField(size);
        this.Quantidade = new JTextField(size);
        
        // Inserção dos componentes no painel esquerdo
        esquerda.add(new JLabel("Nome:"));
        esquerda.add(this.nomeProduto);
        esquerda.add(new JLabel("Preço:"));
        esquerda.add(this.preco);
        esquerda.add(new JLabel("Quantidade:"));
        esquerda.add(this.Quantidade);
        
        // Unidade de medida
        esquerda.add(new JLabel("Unidade:"));
        this.valorUnidade = new JTextField(size);
        esquerda.add(this.valorUnidade);
        
        String[] uniMedida = {"UN","DZ","RS","TO","KG","GR","MG","LT","ML","MT","CM","MM","PC"};
        this.unidadeMedida = new JComboBox(uniMedida);
        this.unidadeMedida.setSelectedIndex(0);
        esquerda.add(this.unidadeMedida);
        
        // Grupos de produtos disponíveis para inserção
        String[] grupo = {
            "Alimento",
            "Material",
            "Fármaco",
            "Eletrônico",
            "Cosmético",
            "Livro",
            "Vestuário",
            "Higiene",
            "Limpeza",
            "Maquinário",
            "Infantil",
            "Jogo",
            "Áudio",
            "Escritório",
            "Automotivo",
            "Cozinha",
            "Jardim",
            "Esporte",
            "Ferramenta",
            "Pet Shop"};
        this.tipoProduto = new JComboBox(grupo);
        this.tipoProduto.setSelectedIndex(0);
        esquerda.add(new JLabel("Grupo:"));
        esquerda.add(this.tipoProduto);
        
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
        
        // Adição do botão adicionar: Adiciona os produtos na planilha
        this.adicionar = new JButton("Adicionar");
        adicionar.addActionListener(new SalvarProduto(this));
        esquerda.add(adicionar);
        
        // Atualização dos itens editados na planilha
        this.atualizar.addActionListener(new AtualizarProduto(this));
        this.atualizar.setEnabled(false);
        esquerda.add(this.atualizar);
        
        jpInsercao.add(esquerda, BorderLayout.WEST);
        jpInsercao.add(direita, BorderLayout.EAST);
        
        this.telaProduto.add(jpInsercao, BorderLayout.NORTH);
    }
    
    // TODO: realizar a inserção dos dados
    private void configuraPlanilhaProdutos() {
        // Container da planilha
        JPanel jpTabela = new JPanel();
        // Tamanho do container da planilha irá ter metade da largura da janela.
        // Ficará no canto inferior esquerdo
        jpTabela.setPreferredSize(new Dimension(640, 480));
        
        String[][] dataTable = {};
        
        String[] columnNames = {
            "Id",
            "Produto",
            "Valor Unitário",
            "Quantidade"
        };
        
        // A planilha de produtos não terá suas células editáveis
        this.tabelaProdutos = new JTable(new DefaultTableModel(dataTable, columnNames)) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        
        this.tabelaProdutos.setPreferredScrollableViewportSize(new Dimension(640, 480));
        this.tabelaProdutos.setFillsViewportHeight(true);
        
        // Ao clicar em alguma linha da planilha, os dados do produto serão colocados
        // em detalhes na tela de Detalhes ( Tela à direita da planilha)
        this.tabelaProdutos.addMouseListener(new VisualizaItem(this));
        
        JScrollPane painel = new JScrollPane(this.tabelaProdutos);
        jpTabela.add(painel);
        
        this.telaProduto.add(jpTabela, BorderLayout.WEST);
    }
    
    private void configuraTelaDetalhes() {
        // Tamanho dos campos do JTextField
        int size = 20;
        JPanel jpDetalhes = new JPanel();
        jpDetalhes.setPreferredSize(new Dimension(620,480));
        jpDetalhes.setBorder(BorderFactory.createTitledBorder("Detalhes"));
        jpDetalhes.setLayout(new BorderLayout());
        
        JPanel esquerda = new JPanel();
        esquerda.setPreferredSize(new Dimension(310,480));
        JPanel direita = new JPanel();
        direita.setPreferredSize(new Dimension(310,480));
        
        esquerda.add(new JLabel("Grupo:"));
        dTipoProduto = new JTextField(size);
        dTipoProduto.setEditable(false);
        esquerda.add(dTipoProduto);
        
        esquerda.add(new JLabel("Unidade:"));
        dUnidadeMedida = new JTextField(17);
        dUnidadeMedida.setEditable(false);
        esquerda.add(dUnidadeMedida);
        
        dUnidadeOpt = new JTextField(3);
        dUnidadeOpt.setEditable(false); 
        esquerda.add(dUnidadeOpt);
        
        esquerda.add(new JLabel("Fornecedor:"));
        dFornecedor = new JTextField(size);
        dFornecedor.setEditable(false);
        esquerda.add(dFornecedor);
        
        esquerda.add(new JLabel("Localização:"));
        dLocalizacao = new JTextField(size);
        dLocalizacao.setEditable(false);
        esquerda.add(dLocalizacao);
        
        direita.add(new JLabel("Descrição:"));
        dDescricao = new JTextArea();
        dDescricao.setPreferredSize(new Dimension(240,150));
        dDescricao.setEditable(false);
        direita.add(dDescricao);
        
        JButton remove = new JButton("Remover");
        remove.addActionListener(new ExcluirProduto(this));
        esquerda.add(remove);
        
        JButton editar = new JButton("Editar");
        editar.addActionListener(new EditarProduto(this));
        esquerda.add(editar);
        
        jpDetalhes.add(esquerda, BorderLayout.WEST);
        jpDetalhes.add(direita, BorderLayout.EAST);
        
        this.telaProduto.add(jpDetalhes, BorderLayout.EAST);
    }
    
    
    public void configuraCadastroFuncionario() {
        int size = 14;
        JPanel painelCrud = new JPanel();
        JPanel esquerda = new JPanel();
        JPanel direitaVazia = new JPanel();
        
        painelCrud.setLayout(new BorderLayout());
        painelCrud.setPreferredSize(new Dimension(426,720));
        esquerda.setPreferredSize(new Dimension(226,720));
        direitaVazia.setPreferredSize(new Dimension(200,720));
        
        
        esquerda.add(new JLabel("Nome:"));
        nomeFuncionario = new JTextField(size);
        esquerda.add(nomeFuncionario);
        
        esquerda.add(new JLabel("CPF:"));
        cpf = new JTextField(size);
        esquerda.add(cpf);
        
        esquerda.add(new JLabel("Senha:"));
        senha = new JPasswordField(size);
        esquerda.add(senha);
        
        // Observação: Fiz umas gambiarras abaixo para deixar os campos
        // minimamente formatados da tela
        esquerda.add(new JLabel("Pagamento fixo:"));
        pagamentoFixo = new JTextField(9);
        esquerda.add(pagamentoFixo);
        
        esquerda.add(new JLabel("RG:"));
        rg = new JTextField(size);
        esquerda.add(rg);
        
        esquerda.add(new JLabel("Telefone:"));
        telefone = new JTextField(10);
        esquerda.add(telefone);
        
        esquerda.add(new JLabel("Registro:"));
        registro = new JTextField(13);
        esquerda.add(registro);
        
        esquerda.add(new JLabel("Sexo:"));
        String[] sexos = {"Masculino","Feminino","Outro"};
        sexo = new JComboBox(sexos);
        esquerda.add(sexo);
        
        esquerda.add(new JLabel("                     Cargo:"));
        cargo = new JTextField(10);
        esquerda.add(cargo);
        
        esquerda.add(new JLabel("Grupo:"));
        JRadioButton funcionario = new JRadioButton("vendas");
        JRadioButton admin = new JRadioButton("Administração");
        isAdmin = new ButtonGroup();
        isAdmin.add(funcionario);
        isAdmin.add(admin);
        isAdmin.setSelected(funcionario.getModel(), rootPaneCheckingEnabled);
        esquerda.add(funcionario);
        esquerda.add(admin);
        
        JButton adicionar = new JButton("Adicionar");
        esquerda.add(adicionar);
        
        JButton remover = new JButton("Remover");
        esquerda.add(remover);
        
        JButton editar = new JButton("Editar");
        esquerda.add(editar);
        
        JButton limpar = new JButton("Limpar");
        esquerda.add(limpar);
        
        painelCrud.add(esquerda, BorderLayout.WEST);
        
        this.telaFuncionario.add(painelCrud, BorderLayout.WEST);
    }
    
    public void configuraPlanilhaFuncionarios() {
        JPanel jpTabela = new JPanel();
        jpTabela.setPreferredSize(new Dimension(640, 720));
        String[][] dataTable = {};
        
        String[] nomeColunas = {
            "Nome",
            "Registro",
            "Cargo",
            "Função",
            "Pagamento"
        };
        
        this.tabelaFuncionarios = new JTable(new DefaultTableModel(dataTable, nomeColunas)) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };
        this.tabelaFuncionarios.setPreferredScrollableViewportSize(new Dimension(640, 480));
        this.tabelaFuncionarios.setFillsViewportHeight(true);
        //this.tabelaFuncionarios.addMouseListener();
        
        JScrollPane painel = new JScrollPane(this.tabelaFuncionarios);
        jpTabela.add(painel);
        
        this.telaFuncionario.add(jpTabela);
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
        configuraCadastroFuncionario();
        configuraPlanilhaFuncionarios();
        mostraTela();
    }
    
    public static void main(String[] args) {
        CadastroProdutoFuncionario tela = new CadastroProdutoFuncionario();
        tela.montaTela();
    }
}
