/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;

/**
 *
 * @author ice
 */
public class Login extends JFrame {
    private JPanel tela;
    private JTextField tfNome;
    private JTextField tfSenha;

    public Login() {
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public void setTfNome(JTextField tfNome) {
        this.tfNome = tfNome;
    }

    public JTextField getTfSenha() {
        return tfSenha;
    }

    public void setTfSenha(JTextField tfSenha) {
        this.tfSenha = tfSenha;
    }
    
    private void configuraJanela() {
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.tela = new JPanel();
        this.tela.setLayout(new BorderLayout());
        
        // this.addWindowListener();
    }
    
    private void configuraLogin() {
        int size = 15;
        JPanel jpLogin = new JPanel();
        jpLogin.setSize(300,600);
        jpLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        
        jpLogin.add(new JLabel("Nome"));
        tfNome = new JTextField(size);
        jpLogin.add(tfNome);
        
        jpLogin.add(new JLabel("Senha"));
        tfSenha = new JTextField(size);
        jpLogin.add(tfSenha);
        
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
