//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package View.produtoFuncionario;

import Controller.CadastroProdutos.AtualizarProduto;
import Controller.CadastroProdutos.CancelarEdicao;
import Controller.CadastroProdutos.EditarProduto;
import Controller.CadastroProdutos.ExcluirProduto;
import Controller.CadastroProdutos.SalvarProduto;
import Controller.CadastroProdutos.VisualizaItem;
import Controller.cadastroFuncionario.EditarFuncionario;
import Controller.cadastroFuncionario.LimparCampos;
import Controller.cadastroFuncionario.RemoverFuncionario;
import Controller.cadastroFuncionario.SalvarFuncionario;
import Controller.cadastroFuncionario.VisualizarFuncionario;
import Controller.janela.EventoJanelaCadastroProdutoFuncionario;
import Interfaces.View;
import Model.Estoque;
import Model.FuncionariosContratados;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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
public class CadastroProdutoFuncionario extends JFrame implements View {
    private int registroUsuarioAtual;
    
    protected JTabbedPane abas;
    protected JButton atualizar;
    protected JButton adicionar;
    protected JButton cancelar;
    
    private JPanel telaProduto;
    private JTable tabelaProdutos;
    private Estoque listaProdutos;
    private FuncionariosContratados funcionariosContratados;
    
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
    private JComboBox sexo;
    private JTextField cargo;
    private JComboBox isAdmin;
    private JLabel alerta;
    
    private JTable tabelaFuncionarios;

    
    public CadastroProdutoFuncionario(int registro) {
        this.registroUsuarioAtual = registro;
        this.funcionariosContratados = new FuncionariosContratados();
        this.listaProdutos = new Estoque();
        this.atualizar = new JButton("Atualizar");
        this.cancelar = new JButton("Cancelar");
        this.setTitle("Cadastro e edição de produtos e funcionários");
        
        //this.montaTela();
    }
    //////////////////////////////////// Métodos Getters e Setters///////////////////////////////////

    public FuncionariosContratados getFuncionariosContratados() {
        return funcionariosContratados;
    }
    
    public JButton getAtualizar() {
        return atualizar;
    }

    public JButton getCancelar() {
        return cancelar;
    }

    public JPanel getTelaProduto() {
        return telaProduto;
    }

    public JTable getTabelaProdutos() {
        return tabelaProdutos;
    }

    public Estoque getListaProdutos() {
        return listaProdutos;
    }

    public JTextField getNomeProduto() {
        return nomeProduto;
    }

    public JTextField getPreco() {
        return preco;
    }

    public JTextField getQuantidade() {
        return Quantidade;
    }

    public JTextArea getDescricao() {
        return descricao;
    }

    public JComboBox getTipoProduto() {
        return tipoProduto;
    }

    public JPanel getTelaFuncionario() {
        return telaFuncionario;
    }

    public JTable getTabelaFuncionarios() {
        return tabelaFuncionarios;
    }

    public JComboBox getUnidadeMedida() {
        return unidadeMedida;
    }

    public JTextField getValorUnidade() {
        return valorUnidade;
    }

    public JTextField getFornecedor() {
        return fornecedor;
    }

    public JTextField getLocalizacao() {
        return localizacao;
    }

    public JButton getAdicionar() {
        return adicionar;
    }

    public JTextArea getdDescricao() {
        return dDescricao;
    }

    public JTextField getdTipoProduto() {
        return dTipoProduto;
    }

    public JTextField getdUnidadeMedida() {
        return dUnidadeMedida;
    }

    public JTextField getdUnidadeOpt() {
        return dUnidadeOpt;
    }

    public JTextField getdFornecedor() {
        return dFornecedor;
    }

    public JTextField getdLocalizacao() {
        return dLocalizacao;
    }

    //////////////////////////////////// Métodos Getters e setters dos Funcionários///////////

    public JLabel getAlerta() {
        return alerta;
    }

    public int getRegistroUsuarioAtual() {
        return registroUsuarioAtual;
    }

    public JTextField getNomeFuncionario() {
        return nomeFuncionario;
    }

    public JTextField getCpf() {
        return cpf;
    }

    public JTextField getPagamentoFixo() {
        return pagamentoFixo;
    }

    public JPasswordField getSenha() {
        return senha;
    }

    public JTextField getRg() {
        return rg;
    }

    public JTextField getTelefone() {
        return telefone;
    }

    public JComboBox getSexo() {
        return sexo;
    }

    public JTextField getCargo() {
        return cargo;
    }

    public JComboBox getIsAdmin() {
        return isAdmin;
    }
    
    //////////////////////////////////// Métodos da Janela///////////////////////////////////
    
    @Override
    public void configuraJanela() {
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
        
        this.addWindowListener(new EventoJanelaCadastroProdutoFuncionario(this));
        
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
            "Bebida",
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
            "Construção",
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
        
        // Cancelar edição
        this.cancelar.addActionListener(new CancelarEdicao(this));
        this.cancelar.setEnabled(false);
        esquerda.add(this.cancelar);
        
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
        
        // Painel dos detalhes do produto selecionado na lpanilha
        JPanel jpDetalhes = new JPanel();
        
        // o painel ocupará a metade da largura da janela.
        // Ficará no canto inferior direito da tela ( à direita da tela)
        jpDetalhes.setPreferredSize(new Dimension(620,480));
        
        jpDetalhes.setBorder(BorderFactory.createTitledBorder("Detalhes"));
        jpDetalhes.setLayout(new BorderLayout());
        
        // Paineis esquerdo e direito do container de detalhes. São usados para
        // manter os campos formatados
        JPanel esquerda = new JPanel();
        esquerda.setPreferredSize(new Dimension(310,480));
        JPanel direita = new JPanel();
        direita.setPreferredSize(new Dimension(310,480));
        
        // Campos que serão usados para exibir os detalhes dos produtos ( Contém gambiarras para formatação)
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
        
        // Remover dados da planilha e do armazenamento
        JButton remove = new JButton("Remover");
        remove.addActionListener(new ExcluirProduto(this));
        esquerda.add(remove);
        
        // Editar dados do produto
        JButton editar = new JButton("Editar");
        editar.addActionListener(new EditarProduto(this));
        esquerda.add(editar);
        
        jpDetalhes.add(esquerda, BorderLayout.WEST);
        jpDetalhes.add(direita, BorderLayout.EAST);
        
        this.telaProduto.add(jpDetalhes, BorderLayout.EAST);
    }
    
    
    public void configuraCadastroFuncionario() {
        // Tamanho dos campos dos JTextFields
        int size = 14;
        
        // Painel do CRUD dos funcionários
        JPanel painelCrud = new JPanel();
        
        // Paineis esquerdo e direito para formatação
        JPanel esquerda = new JPanel();
        JPanel direitaVazia = new JPanel();
        
        // A tela de cadastro ficará no canto esquerdo da janela
        painelCrud.setLayout(new BorderLayout());
        painelCrud.setPreferredSize(new Dimension(426,720));
        esquerda.setPreferredSize(new Dimension(226,720));
        direitaVazia.setPreferredSize(new Dimension(200,720));
        
        // Adição dos campos no painel esquerdo
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
        telefone = new JTextField(11);
        esquerda.add(telefone);
        
        esquerda.add(new JLabel("      Sexo:"));
        String[] sexos = {"Masculino","Feminino","Outro"};
        sexo = new JComboBox(sexos);
        esquerda.add(sexo);
        
        esquerda.add(new JLabel("                     Cargo:"));
        cargo = new JTextField(10);
        esquerda.add(cargo);
        
        esquerda.add(new JLabel("Grupo:"));
        String[] funcoes = {"Vendas","Administração"};
        isAdmin = new JComboBox(funcoes);
        esquerda.add(isAdmin);
        
        // Botões para a manipulação dos dados
        JButton adicionar = new JButton("Adicionar");
        adicionar.addActionListener(new SalvarFuncionario(this));
        esquerda.add(adicionar);
        
        JButton remover = new JButton("Remover");
        remover.addActionListener(new RemoverFuncionario(this));
        esquerda.add(remover);
        
        JButton editar = new JButton("Editar");
        editar.addActionListener(new EditarFuncionario(this));
        esquerda.add(editar);
        
        JButton limpar = new JButton("Limpar");
        limpar.addActionListener(new LimparCampos(this));
        esquerda.add(limpar);
        
        this.alerta = new JLabel("");
        esquerda.add(this.alerta);
        
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
        this.tabelaFuncionarios.addMouseListener(new VisualizarFuncionario(this));
        
        JScrollPane painel = new JScrollPane(this.tabelaFuncionarios);
        jpTabela.add(painel);
        
        this.telaFuncionario.add(jpTabela);
    }
    
    
    @Override
    public void mostraTela() {
        this.add(this.abas);
        this.setVisible(true);
    }
    
    @Override
    public void montaTela() {
        configuraJanela();
        configuraInsercaoProduto();
        configuraPlanilhaProdutos();
        configuraTelaDetalhes();
        configuraCadastroFuncionario();
        configuraPlanilhaFuncionarios();
        mostraTela();
    }
    
    /*public static void main(String[] args) {
        CadastroProdutoFuncionario tela = new CadastroProdutoFuncionario();
        tela.montaTela();
    }*/
}
