/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.LoginEntrar;

import Model.employee.Funcionario;
import View.Login;
import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ice
 */
public class Entrar implements ActionListener {
    Login tela;

    public Entrar(Login tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("teste");
        for(Funcionario i : tela.getFuncionariosContratados().getFuncionariosContratados()) {
            if(i.getNome().equals(tela.getTfNome().getText()) && i.getSenha().equals(String.copyValueOf(tela.getTfSenha().getPassword()))) {
                System.out.println("Entrou!");
                if(i.isAdmin()) {
                    this.tela.dispose();
                    CadastroProdutoFuncionario tela = new CadastroProdutoFuncionario();
                    tela.montaTela();
                }
            }
        }
    }

    /*@Override
    public void actionPerformed(ActionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
