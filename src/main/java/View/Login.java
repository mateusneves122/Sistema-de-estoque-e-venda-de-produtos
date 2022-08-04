//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package View;

import Controller.LoginEntrar.Entrar;
import Controller.janela.EventoJanelaLogin;
import Model.FuncionariosContratados;
import Interfaces.View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ice
 */
public class Login extends JFrame implements View {
    private JPanel tela;
    private JTextField tfNome;
    private JPasswordField tfSenha;
    
    private FuncionariosContratados funcionariosContratados;

    public Login() {
        funcionariosContratados = new FuncionariosContratados();
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public void setTfNome(JTextField tfNome) {
        this.tfNome = tfNome;
    }

    public JPasswordField getTfSenha() {
        return tfSenha;
    }

    public void setTfSenha(JPasswordField tfSenha) {
        this.tfSenha = tfSenha;
    }

    public FuncionariosContratados getFuncionariosContratados() {
        return funcionariosContratados;
    }

    public void setFuncionariosContratados(FuncionariosContratados funcionariosContratados) {
        this.funcionariosContratados = funcionariosContratados;
    }
    
    @Override
    public void configuraJanela() {
        this.setSize(320, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.tela = new JPanel();
        this.tela.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.addWindowListener(new EventoJanelaLogin(this));
    }
    
    private void configuraLogin() {
        int size = 20;
        JPanel jpLogin = new JPanel();
        jpLogin.setSize(300,600);
        jpLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        
        jpLogin.add(new JLabel("Nome "));
        tfNome = new JTextField(size);
        jpLogin.add(tfNome);
        
        jpLogin.add(new JLabel("Senha"));
        tfSenha = new JPasswordField(size);
        jpLogin.add(tfSenha);
        
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setPreferredSize(new Dimension(130,20));
        btnEntrar.addActionListener(new Entrar(this));
        
        jpLogin.add(btnEntrar);
        
        
        tela.add(jpLogin, BorderLayout.CENTER);
    }
    
    @Override
    public void mostraTela() {
        this.add(tela);
        this.setVisible(true);
    }
    
    @Override
    public void montaTela() {
        configuraJanela();
        configuraLogin();
        mostraTela();
    }
    
    public static void main(String[] args) {
        Login login = new Login();
        login.montaTela();
    }
}
