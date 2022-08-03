/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.TelaVendas.CadastrarClienteBtn;
import Controller.janela.EventoJanelaCadastroCliente;
import Interfaces.View;
import Model.ClienteCadastrado;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author SuvacoDeCobra
 */
public class CadastrarCliente extends JFrame implements View {

    private JPanel tela;
    private JTextField nome;
    private JTextField cpf;
    protected ClienteCadastrado clienteList;

    public CadastrarCliente() {
        this.clienteList = new ClienteCadastrado();
    }

    public JTextField getNome() {
        return this.nome;
    }

    public JTextField getCpf() {
        return this.cpf;
    }

    @Override
    public void configuraJanela() {
        this.setSize(260, 180);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.addWindowListener(new EventoJanelaCadastroCliente(this));
        
        this.tela = new JPanel();
        this.tela.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
    }

    private void configuraCadastrarCliente() {
        int size = 20;
        JPanel jpCadastrarCliente = new JPanel();
        jpCadastrarCliente.setSize(300, 600);
        jpCadastrarCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        
        jpCadastrarCliente.add(new JLabel("Nome "));
        this.nome = new JTextField(size);
        jpCadastrarCliente.add(this.nome);
        
        jpCadastrarCliente.add(new JLabel("CPF "));
        this.cpf = new JTextField(size);
        jpCadastrarCliente.add(this.cpf);
        
        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.setPreferredSize(new Dimension(130,25));
        jpCadastrarCliente.add(cadastrar);
        cadastrar.addActionListener(new CadastrarClienteBtn(this));
        
        tela.add(jpCadastrarCliente, BorderLayout.CENTER);
        
    }

    @Override
    public void mostraTela() {
        this.add(tela);
        this.setVisible(true);
    }

    @Override
    public void montaTela() {
        configuraJanela();
        configuraCadastrarCliente();
        mostraTela();
    }

    public static void main(String[] args) {
        CadastrarCliente t = new CadastrarCliente();
        t.montaTela();
    }

}
