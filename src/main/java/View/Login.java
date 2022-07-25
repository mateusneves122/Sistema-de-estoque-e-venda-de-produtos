/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.LoginEntrar.Entrar;
import Model.employee.Employee;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ice
 */
public class Login extends JFrame {
    private JPanel tela;
    private JTextField tfNome;
    private JPasswordField tfSenha;
    
    private JList<Employee> funcionarios;

    public Login() {
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

    public JList<Employee> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(JList<Employee> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    private void configuraJanela() {
        this.setSize(320, 120);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.tela = new JPanel();
        this.tela.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        // this.addWindowListener();
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
        
        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.setPreferredSize(new Dimension(130,20));
        jpLogin.add(cadastrar);
        
        tela.add(jpLogin, BorderLayout.CENTER);
    }
    
    public void mostraTela() {
        this.add(tela);
        this.setVisible(true);
    }
    
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
